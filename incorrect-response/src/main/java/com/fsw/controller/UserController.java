package com.fsw.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fsw.config.ApiResponse;
import com.fsw.entity.User;
import com.fsw.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("/all")
    public String getAll() throws JsonProcessingException {
        List<User> users = userService.selectAll();
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(users);
    }
    @GetMapping("/throw")
    public String throwException() throws ApiResponse {
        throw new ApiResponse.Builder()
                .state(1)
                .msg("AOP捕获异常!")
                .build();
    }
}
