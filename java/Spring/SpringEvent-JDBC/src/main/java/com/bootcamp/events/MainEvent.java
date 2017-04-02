package com.bootcamp.events;

import com.bootcamp.events.customEvents.CustomtPublisher;
import com.bootcamp.events.customEvents.Email;
import com.bootcamp.events.customEvents.EmailEvent;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by nidhi on 31/3/17.
 */
@ComponentScan(basePackages = {"com.bootcamp.events"})
public class MainEvent {

  
  
  public static void main(String[] args) {
    ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("Beans.xml");
    context.start();



    CustomtPublisher publisher = (CustomtPublisher) context.getBean(CustomtPublisher.class);


    Email email = new Email();

    email.setTomail("abc.tothenew.com");

    email.setSubject("testing");

    email.setBody("today's session on event");

    email.setFromMail("priyanka.tothenew.com");

    EmailEvent emailEvent = new EmailEvent(email);

    publisher.publish(emailEvent);

    context.stop();
  }
}
