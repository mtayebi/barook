package com.barook.accountservice.repository;

import com.barook.accountservice.model.Transaction;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface TransactionRepository extends CrudRepository<Transaction, Integer> {

    @Query("SELECT SUM(CAST(t.amount AS double)) FROM Transaction t")
    public Double totalTransactionAmount();
}
