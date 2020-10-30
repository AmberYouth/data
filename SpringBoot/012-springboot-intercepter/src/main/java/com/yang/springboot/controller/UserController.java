package com.yang.springboot.controller;

import com.yang.springboot.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/user")
public class UserController {
    @RequestMapping("/login")
    public @ResponseBody Object login(HttpServletRequest request){
        User user = new User();
        user.setId(1001);
        user.setUsername("zhangsan");
        request.getSession().setAttribute("user",user);
        return "login success";
    }

    @RequestMapping("/center")
    public @ResponseBody Object center(){
        return "See Center Message";
    }

    @RequestMapping("/out")
    public @ResponseBody Object out(){
        return "Out see anyTime";
    }

    @RequestMapping("/error")
    public @ResponseBody Object error(){
        return "error";
    }
}
