package com.bootcamp.events.exercise;

import org.springframework.context.ApplicationEvent;

/**
 * Created by priyanka on 31/3/17.
 */
public class EmployeeEvent extends ApplicationEvent {
    /**
     * Create a new ApplicationEvent.
     *
     * @param source the component that published the event (never {@code null})
     */
    public EmployeeEvent(Object source) {
        super(source);
    }
}
