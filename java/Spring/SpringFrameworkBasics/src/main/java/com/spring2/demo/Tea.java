package com.spring2.demo;

import org.springframework.stereotype.Component;

/**
 * Created by priyanka on 28/3/17.
 */

public class Tea implements HotDrink {
    @Override
    public void prepareDrink() {
        System.out.println("preapring tea .... ");
        System.out.println("Item : Latte");
        System.out.println("Price : Rs 145 ");
    }
}
