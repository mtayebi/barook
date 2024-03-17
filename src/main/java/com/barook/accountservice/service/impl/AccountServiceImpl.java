package com.barook.accountservice.service.impl;

import com.barook.accountservice.model.Account;
import com.barook.accountservice.model.Transaction;
import com.barook.accountservice.model.User;
import com.barook.accountservice.repository.AccountRepository;
import com.barook.accountservice.service.AccountService;
import com.barook.accountservice.service.TransactionService;
import jakarta.persistence.Transient;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AccountServiceImpl implements AccountService {
    AccountRepository accountRepository;
    TransactionService transactionService;

    public AccountServiceImpl(AccountRepository accountRepository, TransactionService transactionService) {
        this.accountRepository = accountRepository;
        this.transactionService = transactionService;
    }

    @Override
    public Map balance(Integer id) {
        Account account = accountRepository.findAccountByUserId(id);
        return new HashMap<>(){{ put("balance", account.getBalance());}};
    }

    @Override
    @Transactional
    public Transaction changeBalance(Integer userId, String amount) {
        Account account = accountRepository.findAccountByUserId(userId);
        Long balance = Long.valueOf(account.getBalance());
        String newBalance = String.valueOf(balance + Long.valueOf(amount));
        account.setBalance(newBalance);

        return transactionService.create(amount, userId);
    }
}
