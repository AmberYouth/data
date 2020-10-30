package com.springboot.entity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
@PropertySource(value = "classpath:application-friend.properties")
@Component
//@ConfigurationProperties(prefix = "friend")
public class Friend {
    @Value("${friend.name}")
     String name;
    @Value("${friend.id}")
     String id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "friend{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
