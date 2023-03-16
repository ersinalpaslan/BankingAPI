package com.bankingapi.bankingapi.repository;

import com.bankingapi.bankingapi.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {

}
