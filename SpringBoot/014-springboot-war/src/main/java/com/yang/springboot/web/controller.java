package com.yang.springboot.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class controller {
    @RequestMapping("/userDetail")
    public  Object hello(Model model){
        model.addAttribute("id",1001);
        model.addAttribute("username","lisi");
        return "userDetail";
    }

    @RequestMapping("/user")
    public @ResponseBody Object hello2(){
        Map<String,Object> retMap = new HashMap<>();
        retMap.put("id",1001);
        retMap.put("username","lisi");
        return retMap;
    }
}
