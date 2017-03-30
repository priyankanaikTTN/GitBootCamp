package com.spring.demo;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by priyanka on 28/3/17.
 */
public class Complex {

    List list;
    Map map;
    Set set;


    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public Set getSet() {
        return set;
    }

    public void setSet(Set set) {
        this.set = set;
    }

    @Override
    public String toString() {
        return "Complex{" +
                "list=" + list +
                ", map=" + map +
                ", set=" + set +
                '}';
    }
}
