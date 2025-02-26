package com.example.demo.iterator;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Component
public class LoginIterator implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        HttpSession session = request.getSession();

        Object login = session.getAttribute("loginResult");

        if (login == null) {

            request.setAttribute("error", "请登录后访问");

            //dispatcher n. 调度员；[计] 调度程序；[计] 分配器
            //转发到登录页面
            request.getRequestDispatcher(request.getContextPath() + "/user/login").forward(request, response);
//            return false;
        }
        return true;
    }
}
