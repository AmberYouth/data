package com.yang.springboot.service.serviceImpl;

import com.yang.springboot.mapper.StudentMapper;
import com.yang.springboot.model.Student;
import com.yang.springboot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.ws.Action;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentMapper studentMapper;
    @Override
    public Student queryStudentById(Integer id) {
        Student stu = studentMapper.selectByPrimaryKey(id);

        return stu;
    }
}
