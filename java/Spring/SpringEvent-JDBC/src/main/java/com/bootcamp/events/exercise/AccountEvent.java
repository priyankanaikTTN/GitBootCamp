package com.bootcamp.events.exercise;

import org.springframework.context.ApplicationEvent;

/**
 * Created by priyanka on 2/4/17.
 */
public class AccountEvent extends ApplicationEvent{
    /**
     * Create a new ApplicationEvent.
     *
     * @param source the component that published the event (never {@code null})
     *
     *
     */

    private String eventType;
    public AccountEvent(Object source,String eventType) {
        super(source);
         this.eventType=eventType;


    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }
}
