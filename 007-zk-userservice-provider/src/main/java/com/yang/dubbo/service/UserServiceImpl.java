package com.yang.dubbo.service;

import com.yang.dubbo.model.User;

public class UserServiceImpl implements UserService{

    @Override
    public User queryUserById(Integer id,String userName) {
        User user = new User();
        user.setName(userName);
        user.setId(id);
        return user;
    }
}
