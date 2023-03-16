package com.bankingapi.bankingapi.repository;

import com.bankingapi.bankingapi.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;

public interface AccountRepository extends JpaRepository<Account,Integer> {
    @Modifying
    @Query("update Account ac set ac.amount = ?1 where ac.id = ?2")
    int setAmountForAccount(BigDecimal amount, Integer id);
}
