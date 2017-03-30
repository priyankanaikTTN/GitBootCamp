package com.spring2.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application
{
    public static void main(String[] args)
    {





        //*********************** Exercsie q9 - q 10 ***********************


        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(RestaurantConfig.class);
        ctx.refresh();


         /*Restaurant restaurant = ctx.getBean("restaurant1",Restaurant.class);
         restaurant.getHotDrink().prepareDrink();
*/


         Restaurant restaurant1=ctx.getBean("restaurant2" ,Restaurant.class);
         restaurant1.getHotDrink().prepareDrink();
       // ctx.close();
    }
}
