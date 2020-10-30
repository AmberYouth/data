package com.yang.dubbo.service;

import com.yang.dubbo.model.User;

public interface UserService {
    User queryUserById(int id);
    int getAllStudentCount();
}
