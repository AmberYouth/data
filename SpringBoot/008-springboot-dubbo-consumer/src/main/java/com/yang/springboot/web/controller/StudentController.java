package com.yang.springboot.web.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.yang.springboot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
public class StudentController {
    @Reference(interfaceClass = StudentService.class,version = "1.0.0",check = false)
    StudentService studentService;
    @RequestMapping("/student/count")
    public @ResponseBody Object studentCount(){
        Integer allStudentCount =  studentService.queryAllStudentCount();
        return allStudentCount;
    }
}
