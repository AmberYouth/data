package com.yang.dubbo.web.controller;

import com.yang.dubbo.model.User;
import com.yang.dubbo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping("/userDetail")
    public String userDetail(Model model, Integer id){
        int allStudentCount = userService.getAllStudentCount();
        User user = userService.queryUserById(id);
        model.addAttribute("allStudentCount",allStudentCount);
        model.addAttribute("user",user);
        return "userDetail";
    }
}
