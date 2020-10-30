package com.yang.springboot.service.serviceImpl;

import com.yang.springboot.mapper.StudentMapper;
import com.yang.springboot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentMapper studentMapper;
    @Override
    public int queryStudentCount() {
        int count  = studentMapper.queryStudentCount();

        return count;
    }
}
