package com.spring2.demo;

import jdk.nashorn.internal.ir.annotations.Reference;
import jdk.nashorn.internal.objects.annotations.Property;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;


/**
 * Created by priyanka on 28/3/17.
 */
@Controller("restaurant2")
public class Restaurant {


    @Autowired
    HotDrink hotDrink;


   //@Autowired
    public Restaurant(HotDrink hotDrinks) {
        this.hotDrink = hotDrinks;
    }

    public Restaurant() {
    }
    public HotDrink getHotDrink() {


        return hotDrink;
    }


   //@Autowired(required = false)
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
