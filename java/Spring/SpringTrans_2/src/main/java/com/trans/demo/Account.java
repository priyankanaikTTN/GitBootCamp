package com.trans.demo;

/**
 * Created by priyanka on 29/3/17.
 */
public class Account {

   Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    String name;
    Integer bal;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getBal() {
        return bal;
    }

    public Account() {
    }

    public Account(String name, Integer bal) {

        this.name = name;
        this.bal = bal;
    }

    public void setBal(Integer bal) {
        this.bal = bal;

    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", bal=" + bal +
                '}';
    }
}
