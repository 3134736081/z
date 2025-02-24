package com.example.demo.service;

import com.example.demo.DTO.ResponseDTO;
import com.example.demo.domain.User;

public interface UserService {

    ResponseDTO<User> loginUser(User user);
}
