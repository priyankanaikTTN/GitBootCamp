package com.spring2.demo;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

/**
 * Created by priyanka on 28/3/17.
 */
@Component
public class ExpressTea implements HotDrink {
    @Override
    public void prepareDrink() {
        System.out.println("preapring Coffee .... ");
        System.out.println("Item : Expresso");
        System.out.println("Price : Rs 200 ");
    }
}
