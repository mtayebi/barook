package com.barook.accountservice.service;

import com.barook.accountservice.model.Transaction;
import org.springframework.stereotype.Service;

import java.util.Map;

public interface AccountService {
    Map balance(Integer id);

    Transaction changeBalance(Integer userId, String amount);
}
