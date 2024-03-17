package com.barook.accountservice.service;

import com.barook.accountservice.model.User;
import org.springframework.stereotype.Service;


public interface UserService {
    User getUser(Integer id);
}
