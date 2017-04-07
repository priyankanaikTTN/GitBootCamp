package com.springAop.demo;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Aspect
@Component
public class LoggingAspect {

    @Before("execution(* print*(..))")
    public void logBefore(JoinPoint joinPoint)
    {
        System.out.println();
        System.out.println("*******logging before*********");
        System.out.println("joinpoint : "+joinPoint.getSignature());
        System.out.println(joinPoint.getArgs().toString());

    }

    @After("@annotation(Deprecated)")
            public void logDeprecated(JoinPoint joinPoint)
    {

        System.out.println("***********deprecated logging after************");
        System.out.println("joinpoint : "+joinPoint.getSignature());
    }

    @AfterReturning(value="execution(* getUser())",returning = "u1")
    public  void returnLogging(JoinPoint joinPoint,User u1)
    {
        System.out.println();
        System.out.println("******** after returning loggin********");
        System.out.println(u1.toString());
        System.out.println("joinpoint :"+joinPoint.getSignature());

    }

    @AfterThrowing(value="execution(* throw*())" , throwing = "ex")
    public void afterThrowing(JoinPoint joinPoint,IOException ex)
    {
        System.out.println();
        System.out.println("************After throwing loggin***********");
        System.out.println(ex);
        System.out.println("joinpoint :"+joinPoint.getSignature());


    }

    @Around("execution(* display())")
    void aroundAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("Around before");
        proceedingJoinPoint.proceed();
        System.out.println("Around after");

    }

    @Before("displayPointcut_1() || displayPointcut_2()")
    void pointcutannotation()
    {
        System.out.println("inside the pointcut annotations used");
    }


    @Pointcut("execution(void pointcut_1())")
    void displayPointcut_1(){}

    @Pointcut("execution(void pointcut_2())")
    void displayPointcut_2(){}

}
