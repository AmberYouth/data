package com.yang.springboot.web.controller;

import com.yang.springboot.web.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class StudentController {
    @Autowired
    private StudentService studentService;
    @RequestMapping("/put")
    public @ResponseBody Object put(String key , String value){
        studentService.put(key,value);
        return "值已放入redis中";
    }

    @RequestMapping("/get")
    public @ResponseBody Object get(String key){
        String value = studentService.get(key);
        return "value="+value;
    }
}
