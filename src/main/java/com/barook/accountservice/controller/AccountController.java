package com.barook.accountservice.controller;

import com.barook.accountservice.Dto.ChangeBalanceDto;
import com.barook.accountservice.model.Transaction;
import com.barook.accountservice.service.AccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/account")
public class AccountController {

    AccountService accountService;

    private static final Logger logger = LoggerFactory.getLogger(AccountController.class);


    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/get-balance/{id}")
    public ResponseEntity<Map> getBalance(@PathVariable Integer id){
        logger.info("user {} requested for balance information", id);
        Map balance = accountService.balance(id);
        return ResponseEntity.ok(balance);
    }

    @PostMapping("/change-balance")
    public ResponseEntity<Map> changeBalance(@RequestBody ChangeBalanceDto changeBalanceDto){
        Transaction transaction = accountService.changeBalance(changeBalanceDto.userId(), changeBalanceDto.amount());
        logger.info("user {} requested for changed it's own balance (amount info: {})", changeBalanceDto.userId(), changeBalanceDto.amount());
        return ResponseEntity.ok(new HashMap<>(){{ put("referenceId", transaction.getReferenceId());}});
    }
}
