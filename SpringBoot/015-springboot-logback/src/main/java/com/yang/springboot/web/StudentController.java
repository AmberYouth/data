package com.yang.springboot.web;

import com.yang.springboot.mapper.StudentMapper;
import com.yang.springboot.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
@Slf4j
@Controller
public class StudentController {
    @Autowired
    private StudentService studentService;
    @RequestMapping("/student/count")
    public @ResponseBody String student(){
        log.info("查询学生人数");
        int count  = studentService.queryStudentCount();
        return "学生总人数为"+count;
    }
}
