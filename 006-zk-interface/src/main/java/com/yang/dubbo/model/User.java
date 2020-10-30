package com.yang.dubbo.model;

import java.io.Serializable;

public class User implements Serializable {
    String name;
    Integer id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User(String name, Integer id) {
        this.name = name;
        this.id = id;
    }

    public User() {
    }
}
