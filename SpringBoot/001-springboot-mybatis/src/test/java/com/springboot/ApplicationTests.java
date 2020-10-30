package com.springboot;

import com.springboot.entity.Friend;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.security.RunAs;


@SpringBootTest
class ApplicationTests {
    @Autowired
    Friend friend;
    @Autowired
    ApplicationContext ioc;
    @Test
    void contextLoads() {
        System.out.println(friend);
        Boolean flag = ioc.containsBean("friend1");
        System.out.println("flag="+flag);
    }

}
