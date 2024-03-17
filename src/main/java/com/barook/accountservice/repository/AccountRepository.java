package com.barook.accountservice.repository;

import com.barook.accountservice.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Integer> {
    Account findAccountByUserId(Integer id);
}
