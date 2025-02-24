package com.example.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.DTO.ResponseDTO;
import com.example.demo.domain.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public ResponseDTO<User> loginUser(User user) {

        QueryWrapper<User> objectQueryWrapper = new QueryWrapper<User>()
                .eq("id", user.getId())
                .eq("username", user.getUsername())
                .eq("password", user.getPassword());
        User user1 = userMapper.selectOne(objectQueryWrapper);

        if (Objects.isNull(user1)) {
            return new ResponseDTO<>(401, "用户名或密码错误", null);
        } else {
            return new ResponseDTO<>(200, "登录成功", user1);
        }
    }
}
