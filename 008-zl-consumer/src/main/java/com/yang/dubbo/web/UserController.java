package com.yang.dubbo.web;

import com.yang.dubbo.model.User;
import com.yang.dubbo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping("/userDetail")
    public String userDetail(Model model,Integer id, String userName){

        User user = userService.queryUserById(id, userName);
        model.addAttribute(user);

        return "userDetail";
    }
}
