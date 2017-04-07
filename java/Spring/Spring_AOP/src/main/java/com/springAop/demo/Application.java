package com.springAop.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * Created by priyanka on 29/3/17.
 */
public class Application {

    public static void main(String[] args) throws Exception {

        ApplicationContext applicationContext = new
                ClassPathXmlApplicationContext("spring-config.xml");

      UserService userService = applicationContext.getBean(UserService.class);
      userService.printUser();
      userService.getUser();
      try
      {
          userService.throwEror1();
      }
      catch (ArithmeticException ex)
      {

          System.out.println("Handled  arithmetic ");
      }

      try {
          userService.throwError2();
      }catch (IOException ex)
      {
          System.out.println("handled ioexception ");
      }


      userService.deprecatedMethod();
      userService.deprecatedMethod2();

        userService.display();


        userService.pointcut_1();

        userService.pointcut_2();

    }



}
