package com.yang.dubbo.controller;

import com.yang.dubbo.model.User;
import com.yang.dubbo.service.UserService;
import jdk.internal.org.objectweb.asm.Handle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Controller
public class UserController {
    @Resource
    UserService userService;

    @Resource
    UserService userService2;

    @RequestMapping("/userDetail")
    public String userDetail(Model model,Integer id,String userName){
        User user = userService.queryUserById(id,userName);
        User user2 = userService2.queryUserById(id,userName);
        model.addAttribute(user);
        model.addAttribute(user2);
        Map map = new HashMap<>();
        return "userDetail";
    }
}
