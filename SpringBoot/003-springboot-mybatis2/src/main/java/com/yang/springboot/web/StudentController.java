package com.yang.springboot.web;

import com.yang.springboot.model.Student;
import com.yang.springboot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class StudentController {
    @Autowired
    StudentService studentService;
    @RequestMapping("/student.do")
    @ResponseBody
    public Student queryStudentById(Integer id){
        Student stu = studentService.queryStudentById(id);
        return stu;
    }
}
