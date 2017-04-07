package com.springAop.demo;

import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * Created by priyanka on 29/3/17.
 */
@Service
public class UserService {

    User user= new User("Priyanka","jvm");

    public UserService(User user) {
        this.user = user;
    }

    public UserService() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void printUser()
    {


        System.out.println();
        System.out.println("prrinting User");

    }
    @Deprecated
    public  void deprecatedMethod()
    {
        System.out.println();
        System.out.println("Inside deprected method1");
    }

    @Deprecated
    public  void deprecatedMethod2()
    {

        System.out.println()
        ;System.out.println("Inside deprected method2");
    }

    public  void throwEror1()throws ArithmeticException
    {
        System.out.println();
        System.out.println("Inside method throwing Arithmetic Exception");
        throw new ArithmeticException("arithmetic exception thrown ");
    }
    public  void  throwError2()throws IOException
    {
        System.out.println();
        System.out.println("Inside method throwing IOException");
        throw  new IOException("io exception thrown");
    }


    public void display() {
        System.out.println( "UserService{" +
                "user=" + user +
                '}');
    }

    public void pointcut_1()
    {
        System.out.println("Using @pointcut annotations 1");
    }

    public void pointcut_2()
    {
        System.out.println("Using @pointcut annotations 2");
    }
}
