package com.bootcamp.events.exercise;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;

/**
 * Created by priyanka on 2/4/17.
 */
@Component
public class AccountPublisher implements ApplicationEventPublisherAware{

    private ApplicationEventPublisher publisher;
    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {

        publisher=applicationEventPublisher;
    }

    public void publish(AccountEvent accountEvent)
    {

        publisher.publishEvent(accountEvent);
    }
}
