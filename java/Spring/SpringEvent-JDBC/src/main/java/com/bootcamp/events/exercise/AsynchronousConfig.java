package com.bootcamp.events.exercise;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ApplicationEventMulticaster;
import org.springframework.context.event.SimpleApplicationEventMulticaster;
import org.springframework.core.task.SimpleAsyncTaskExecutor;

/**
 * Created by priyanka on 31/3/17.
 */

//@Configuration

public class AsynchronousConfig {

   /* @Bean(name="applicationEventMulticaster")
     public ApplicationEventMulticaster simpleApplicationEventMulticaster()
       {

           SimpleApplicationEventMulticaster simpleApplicationEventMulticaster = new
                   SimpleApplicationEventMulticaster();

           simpleApplicationEventMulticaster.setTaskExecutor(new SimpleAsyncTaskExecutor());

           return simpleApplicationEventMulticaster;
       }*/

}
