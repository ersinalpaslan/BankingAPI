package com.bankingapi.bankingapi;

import com.bankingapi.bankingapi.model.Customer;
import com.bankingapi.bankingapi.model.Transfer;
import com.bankingapi.bankingapi.repository.AccountRepository;
import com.bankingapi.bankingapi.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;

@SpringBootApplication
public class BankingapiApplication implements CommandLineRunner {

	private final CustomerRepository customerRepository;
	private final AccountRepository accountRepository;

	public BankingapiApplication(CustomerRepository customerRepository, AccountRepository accountRepository) {
		this.customerRepository = customerRepository;
		this.accountRepository = accountRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(BankingapiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		Customer customer1 = Customer.builder()
//				.name("Sarah")
//				.lastName("Johnson")
//				.build();
//		Customer customer2 = Customer.builder()
//				.name("Michael")
//				.lastName("Garcia")
//				.build();
//		Customer customer3 = Customer.builder()
//				.name("Emily")
//				.lastName("Rodriguez")
//				.build();
//		customerRepository.save(customer1);
//		customerRepository.save(customer2);
//		customerRepository.save(customer3);
//		Transfer transfer1 = Transfer.builder()
//				.amount(new BigDecimal(45))
//				.sender()
//				.receiver()
//				.build();
	}
}
