package com.bootcamp.events.customEvents;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ApplicationEventMulticaster;
import org.springframework.context.event.SimpleApplicationEventMulticaster;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.stereotype.Component;

/**
 * Created by priyanka on 31/3/17.
 */

/*@Configuration

public class AsynchronousEmployeeConfig {

    @Bean(name="applicationEventMulticaster")
     public ApplicationEventMulticaster simpleApplicationEventMulticaster()
       {

           SimpleApplicationEventMulticaster simpleApplicationEventMulticaster = new
                   SimpleApplicationEventMulticaster();

           simpleApplicationEventMulticaster.setTaskExecutor(new SimpleAsyncTaskExecutor());

           return simpleApplicationEventMulticaster;
       }

}*/
