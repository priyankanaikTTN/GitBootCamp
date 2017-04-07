package com.springAop.demo;

import org.springframework.stereotype.Component;

/**
 * Created by priyanka on 29/3/17.
 */
@Component
public class User {

    String name;
    String dep;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDep() {
        return dep;
    }

    public void setDep(String dep) {
        this.dep = dep;
    }

    public User(String name,String dep) {
        this.name = name;
        this.dep=dep;
    }

    public User() {
    }

    @Override
    public String toString() {

        return "User{" +
                "name='" + name + '\'' +
                ", dep='" + dep + '\'' +
                '}';
    }
}
