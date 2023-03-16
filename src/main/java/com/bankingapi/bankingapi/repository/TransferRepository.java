package com.bankingapi.bankingapi.repository;

import com.bankingapi.bankingapi.model.Account;
import com.bankingapi.bankingapi.model.Transfer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TransferRepository extends JpaRepository<Transfer,Integer> {
    List<Transfer> findByReceiverOrSender(Optional<Account> account,  Optional<Account> account1);
}
