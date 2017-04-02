package com.bootcamp.events.customEvents;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * Created by priyanka on 31/3/17.
 */
@Component
public class EmailListener implements ApplicationListener<EmailEvent>{
    @Override
    public void onApplicationEvent(EmailEvent event) {

        if(event.getSource() instanceof Email)
        {
            Email email=(Email) event.getSource();
            System.out.println("Email is sent to : "+email.getTomail()+"\n from: "+email.getFromMail()+"\n with subject :"+email.getSubject());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("email is : \n"+ email.getBody());
        }
    }
}
