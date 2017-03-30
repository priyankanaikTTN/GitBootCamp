package com.spring2.demo;

import com.spring.demo.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;


/**
 * Created by priyanka on 29/3/17.
 */
@Configuration
@ComponentScan(basePackages= {"com.spring2.demo"})
public class RestaurantConfig {
//    @Bean
//    public HotDrink getTea()
//    {
//        return new ExpressTea();
//    }
//    @Bean(name = "expressTea")
//    public ExpressTea expressTea()
//    {
//        ExpressTea expressTea = new ExpressTea();
//        return  expressTea;
//    }
//    @Bean(name="restaurant1")
//    public Restaurant getRestaurant_1(@Qualifier("expressTea") HotDrink hotDrink)
//    {
//        Restaurant restaurant =new Restaurant(hotDrink);
//        return restaurant;
//    }


}
