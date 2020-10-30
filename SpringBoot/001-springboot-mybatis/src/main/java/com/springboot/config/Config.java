package com.springboot.config;

import com.springboot.entity.Friend;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    @Bean
    public Friend friend1(){
        System.out.println("配置类@Bean添加组件了");
        return new Friend();
    }
}
