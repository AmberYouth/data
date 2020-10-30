package com.yang.springboot.web;

import com.alibaba.dubbo.config.annotation.Reference;
import com.yang.springboot.model.Student;
import com.yang.springboot.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.http.HttpRequest;

@Controller
public class StudentController {
   @Reference(interfaceName = "com.yang.springboot.service.StudentService",version = "1.0.0",check = false)
    private StudentService studentService;
    @RequestMapping("/student/detail/{id}")
    public void studentDetail(HttpServletRequest request, HttpServletResponse response, @PathVariable("id") Integer id){
        System.out.println("我进来了");
        System.out.println(studentService+"service");
        Student stu = studentService.queryStudentById(id);
        request.setAttribute("student",stu);
        System.out.println(stu);
        try {
            request.getRequestDispatcher("/studentDetail.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/student/all/count")
    public @ResponseBody Object allStudentCount(){
        Integer allStudentCount = studentService.queryAllStudentCount();
        return "学生人数为:"+allStudentCount;
    }
    
}
