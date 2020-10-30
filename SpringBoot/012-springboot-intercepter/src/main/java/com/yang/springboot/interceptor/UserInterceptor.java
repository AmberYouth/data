package com.yang.springboot.interceptor;

import com.yang.springboot.model.User;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        User user = (User) request.getSession().getAttribute("user");
        if (user==null){
            response.sendRedirect(request.getContextPath()+"/user/error");
            return false;
        }
        return true;
    }
}
