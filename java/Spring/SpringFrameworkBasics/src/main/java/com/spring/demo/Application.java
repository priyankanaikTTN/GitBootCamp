package com.spring.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.applet.AppletContext;

public class Application
{
    public static void main(String[] args) {

        ApplicationContext applicationContext1 = new ClassPathXmlApplicationContext("config.xml");


        /*
           *********************Exercise q1 - q8*******************************/

        Database db = applicationContext1.getBean(Database.class);

         System.out.println(db);
        System.out.println();

         Restaurant resTea = applicationContext1.getBean("teaRestaurant",Restaurant.class);
          resTea.getHotDrink().prepareDrink();

        System.out.println();

          Restaurant resExpress = applicationContext1.getBean("expressRestaurant",Restaurant.class);
          resExpress.getHotDrink().prepareDrink();

        System.out.println();

        Complex complex = applicationContext1.getBean("complexBean",Complex.class);
        System.out.println(complex);

        System.out.println();

        System.out.println("Auto - wired By Name");

        Restaurant autoWiredRes = applicationContext1.getBean("autoWiredNamedRestaurant",Restaurant.class);
        autoWiredRes.getHotDrink().prepareDrink();


      /*  System.out.println("Auto - wired By Type");

        Restaurant autoWiredRes1 = applicationContext1.getBean("autoWiredTypeRestaurant",Restaurant.class);
        autoWiredRes1.getHotDrink().prepareDrink();
*/
        System.out.println();
        System.out.println("Auto - wired By Constructor");

        Restaurant autoWiredconsRes = applicationContext1.getBean("autoWiredConsRestaurant",Restaurant.class);
        autoWiredconsRes.getHotDrink().prepareDrink();


        System.out.println();
        System.out.println("**********Singleton Bean***********");


        System.out.println("If singleRes singleton");
        System.out.println(applicationContext1.isSingleton("SingleRes"));


        System.out.println("**********Prototype Bean***********");

        System.out.println("If protoRes prototype");
        System.out.println(applicationContext1.isPrototype("PrototypeRes"));


        System.out.println("@Required Annotations");

        Restaurant requiredRes = applicationContext1.getBean("requiredRes",Restaurant.class);
        HotDrink hotDrink=requiredRes.getHotDrink();
        hotDrink.prepareDrink();





    }
}
