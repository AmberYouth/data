package com.yang.springboot.web;

import com.yang.springboot.model.Student;
import com.yang.springboot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@org.springframework.stereotype.Controller
public class Controller {
    @Autowired
    StudentService studentService;
    @RequestMapping("/student.do")
    @ResponseBody
    public Object queryStudentById(Integer id){
        Student stu = studentService.queryStudentById(id);
        return stu;
    }
}
