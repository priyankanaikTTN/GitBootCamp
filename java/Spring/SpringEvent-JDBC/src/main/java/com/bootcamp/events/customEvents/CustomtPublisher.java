package com.bootcamp.events.customEvents;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;

/**
 * Created by priyanka on 31/3/17.
 */

public class CustomtPublisher implements ApplicationEventPublisherAware {

    private ApplicationEventPublisher publisher;

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {

        System.out.println("Application event publisher is set to Custom Publisher");
  publisher=applicationEventPublisher;
    }

    public void publish(EmailEvent event)
    {

        publisher.publishEvent(event);

    }
}
