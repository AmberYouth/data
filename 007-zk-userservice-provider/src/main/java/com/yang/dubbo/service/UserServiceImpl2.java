package com.yang.dubbo.service;

import com.yang.dubbo.model.User;

public class UserServiceImpl2 implements UserService {
    @Override
    public User queryUserById(Integer id, String userName) {
        User user = new User();
        user.setName(userName+"-2");
        user.setId(id);

        return user;
    }
}
