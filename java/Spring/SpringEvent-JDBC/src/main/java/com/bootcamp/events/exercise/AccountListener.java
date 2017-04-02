package com.bootcamp.events.exercise;

import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.Scanner;

/**
 * Created by priyanka on 2/4/17.
 */
@Component
public class AccountListener implements ApplicationListener<AccountEvent> {


    @Override
    public void onApplicationEvent(AccountEvent event) {

        boolean flag ;
        Scanner in = new Scanner(System.in);

        if(event.getSource() instanceof Account) {


            if(event.getEventType()=="update") {


                do {
                    Random random = new Random();

                    Integer Otp = random.nextInt(2000) + 1000;

                    System.out.println("Enter the OTP sent to your mobile: " + Otp);


                    Integer otp_entered = in.nextInt();

                    if (Otp.equals(otp_entered)) {

                        flag = true;
                    } else {

                        System.out.println("Wrong OTP entered... try again");
                        flag = false;
                    }

                } while (!flag);

            }

            if(event.getEventType()=="deposit")
            {
                System.out.println("Amount successfully credited to account :"+((Account) event.getSource()).getAcc_num());

            }

            if(event.getEventType()=="withdraw")
            {
                System.out.println("Amount successfully debited from account :"+((Account) event.getSource()).getAcc_num());

            }
        }

    }
}
