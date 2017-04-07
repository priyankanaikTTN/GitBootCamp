package com.trans.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by priyanka on 29/3/17.
 */
public class Application {

    public static void main(String[] args) {
        ApplicationContext applicationContext= new
                ClassPathXmlApplicationContext("config.xml");

        AccountService accountService= applicationContext.getBean(AccountService.class);
        accountService.transferAmount("priyanka","sargam",500L);

       /*Account account= accountService.getAccountStateOfUser("priyanka");
        System.out.println(account.toString());
*/
    }
}
