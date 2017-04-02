package com.bootcamp.events.exercise;

import com.bootcamp.events.customEvents.Email;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * Created by priyanka on 31/3/17.
 */
@Component
public class EmployeeListener implements ApplicationListener<EmployeeEvent> {
    @Override
    public void onApplicationEvent(EmployeeEvent event) {

        if(event.getSource() instanceof Employee)
        {



            System.out.println("ALERT ::: salary greater than 30000");
        }

    }
}
