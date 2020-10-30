package com.yang.springboot.service;

import com.yang.springboot.model.Student;

public interface StudentService {
    Student queryStudentById(Integer id);

    Integer queryAllStudentCount();
    String say(String msg);
}
