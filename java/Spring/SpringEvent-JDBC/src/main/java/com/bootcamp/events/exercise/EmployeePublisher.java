package com.bootcamp.events.exercise;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;

/**
 * Created by priyanka on 31/3/17.
 */
@Component
public class EmployeePublisher implements ApplicationEventPublisherAware {


     private ApplicationEventPublisher publisher;
    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {

        publisher=applicationEventPublisher;

    }

    public void publish(EmployeeEvent employeeEvent)
    {

        publisher.publishEvent(employeeEvent);
    }
}
