package com.bootcamp.events.exercise;

import java.util.Random;

/**
 * Created by priyanka on 31/3/17.
 */
public class Account {

     Random random ;
    Integer pin;
    Integer balance;
    Integer acc_num;

    public Account() {
        random=new Random();
    }

    public Integer getPin() {
        return pin;
    }

    public void setPin() {
        this.pin=random.nextInt(5000)+1000;

    }

    public void setPin_Account(Integer pin)
    {
        this.pin=pin;
    }

    public  void setAcc_num_Account(Integer acc_num)
    {
        this.acc_num=acc_num;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public Integer getAcc_num() {
         return acc_num;
    }

    public void setAcc_num() {
       this.acc_num=random.nextInt(5000000)+1000000;
    }

    @Override
    public String toString() {
        return "Account{" +
                "pin='" + pin + '\'' +
                ", balance=" + balance +
                ", acc_num=" + acc_num +
                '}';
    }
}
