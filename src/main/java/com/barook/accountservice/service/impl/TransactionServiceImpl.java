package com.barook.accountservice.service.impl;

import com.barook.accountservice.model.Transaction;
import com.barook.accountservice.model.User;
import com.barook.accountservice.repository.TransactionRepository;
import com.barook.accountservice.service.TransactionService;
import com.barook.accountservice.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class TransactionServiceImpl implements TransactionService {
    TransactionRepository transactionRepository;
    UserService userService;

    public TransactionServiceImpl(TransactionRepository transactionRepository, UserService userService) {
        this.transactionRepository = transactionRepository;
        this.userService  = userService;
    }

    @Override
    public Transaction create(String amount, Integer userId) {
        Transaction transaction = Transaction.builder().amount(amount).user(userService.getUser(userId)).build();
        return transactionRepository.save(transaction);
    }

    @Override
    public Double getTotalTransactionAmount() {
        return transactionRepository.totalTransactionAmount();
    }
}
