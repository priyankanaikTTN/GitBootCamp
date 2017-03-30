package com.spring.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.RequiredAnnotationBeanPostProcessor;
import org.springframework.stereotype.Controller;


/**
 * Created by priyanka on 28/3/17.
 */

public class Restaurant {


    HotDrink hotDrink;



    public Restaurant(HotDrink hotDrinks) {
        this.hotDrink = hotDrinks;
    }

    public Restaurant() {
    }
    public HotDrink getHotDrink() {


        return hotDrink;
    }

    @Required
    public void setHotDrink(HotDrink hotDrink) {
        this.hotDrink = hotDrink;
    }



    @Override
    public String toString() {
        return "Restaurant{" +
                "hotDrink=" + hotDrink +
                '}';
    }
}
