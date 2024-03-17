package com.barook.accountservice.service.impl;

import com.barook.accountservice.model.User;
import com.barook.accountservice.repository.UserRepository;
import com.barook.accountservice.service.UserService;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {
    UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User getUser(Integer id) {
        return userRepository.findById(id).get();
    }
}
