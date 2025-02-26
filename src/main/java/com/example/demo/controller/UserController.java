package com.example.demo.controller;

import com.example.demo.DTO.ResponseDTO;
import com.example.demo.domain.User;
import com.example.demo.service.UserService;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("user")
public class UserController {

    @Resource
    private UserService userService;

    private org.slf4j.Logger logger = LoggerFactory.getLogger(UserController.class);

    @GetMapping("index")
    public String index() {
        return "index";
    }

    @GetMapping("login")
    public String userLogin() {
        return "login";
    }

    @PostMapping("login")
    public String login(@ModelAttribute User user, Model model, HttpSession httpSession) {

        ResponseDTO<User> userResponseDTO1 = userService.loginUser(user);
        //info n. 信息；情报
        logger.info("info:{}", userResponseDTO1);
        model.addAttribute("result", userResponseDTO1);

        System.out.println(user);

        if (userResponseDTO1.code() == 401) {

            return "login";
        } else {
            httpSession.setAttribute("loginResult", userResponseDTO1);
            return "redirect:/user/index";
        }
    }

    @GetMapping("loginOut")
    public String loginOut(HttpSession httpSession) {

        httpSession.removeAttribute("loginResult");
        return "index";
    }
}
