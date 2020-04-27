package com.fsw.service;

import com.fsw.entity.User;
import com.fsw.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> selectAll() {
        return userRepository.findAll();
    }
}
