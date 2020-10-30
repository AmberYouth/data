package com.yang.dubbo.service.serviceImpl;

import com.yang.dubbo.model.User;
import com.yang.dubbo.service.UserService;

public class serviceImpl implements UserService {
    @Override
    public User queryUserById(int id) {
        User user = new User();
        user.setName("zs");
        user.setId(id);
        return user;
    }

    @Override
    public int getAllStudentCount() {
        return 52;
    }
}
