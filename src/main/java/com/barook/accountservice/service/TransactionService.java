package com.barook.accountservice.service;

import com.barook.accountservice.model.Transaction;
import com.barook.accountservice.model.User;
import org.springframework.stereotype.Service;


public interface TransactionService {
    Transaction create(String amount, Integer userId);

    Double getTotalTransactionAmount();
}
