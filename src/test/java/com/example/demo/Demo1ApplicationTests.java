package com.example.demo;

import com.example.demo.DTO.ResponseDTO;
import com.example.demo.domain.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class Demo1ApplicationTests {

    @Resource
    private UserMapper userMapper;

    @Resource
    private UserService userService;

    @Test
    void contextLoads() {

        User user = new User(1, "张三", "123");
        ResponseDTO<User> userResponseDTO = userService.loginUser(user);
        System.out.println(userResponseDTO.code());
    }

}
