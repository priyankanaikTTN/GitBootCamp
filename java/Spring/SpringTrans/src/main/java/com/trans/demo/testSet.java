package com.trans.demo;

/**
 * Created by priyanka on 30/3/17.
 */
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;


class HelloEx {

    String str  = "HelloEx" ;

    HelloEx(String s){
        str = s ;
    }


    public int hashCode() {
        System.out.println("Inside HashCode");
        return 1;
    }


    public boolean equals(Object  o) {
        HelloEx s = (HelloEx)o ;
        System.out.println(str);
        System.out.println(s.str);
        if(str.equals(s.str)){
            System.out.println("Both are equal");
            return true;
        }
        System.out.println("Inside equals");
        return false;
    }

    @Override
    public String toString() {
        return "HelloEx{" +
                "str='" + str + '\'' +
                '}';
    }
}


public class testSet {

    public static void main(String[] args) {

        HelloEx hEx4 = new HelloEx("Four");
        HelloEx hEx5 = new HelloEx("Five");
        HelloEx hEx6 = new HelloEx("Six");

        Set hp = new HashSet();
        hp.add(hEx4);
        hp.add(hEx5);
        hp.add(hEx6);
        System.out.println("Test");
        System.out.println(hp.contains(new HelloEx("Five")));
        System.out.println("HashSet " +  hp  );


    }
}