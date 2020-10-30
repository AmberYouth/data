package com.yang.dubbo.service.serviceImpl;

import com.yang.dubbo.model.User;
import com.yang.dubbo.service.UserService;

public class UserServiceImpl implements UserService {
    @Override
    public User queryUserId(Integer id) {
        User user = new User();
        user.setId(1001);
        user.setName("lisi");
        return user;
    }
}
