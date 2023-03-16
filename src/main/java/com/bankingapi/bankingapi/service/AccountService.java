package com.bankingapi.bankingapi.service;

import com.bankingapi.bankingapi.dto.mapper.AccountMapper;
import com.bankingapi.bankingapi.dto.mapper.TransferMapper;
import com.bankingapi.bankingapi.dto.request.CreateAccountRequestDto;
import com.bankingapi.bankingapi.dto.response.AccountResponseDto;
import com.bankingapi.bankingapi.dto.response.CustomerResponseDto;
import com.bankingapi.bankingapi.dto.response.TransferResponseDto;
import com.bankingapi.bankingapi.exception.AccountNotFoundException;
import com.bankingapi.bankingapi.exception.CustomerNotFoundException;
import com.bankingapi.bankingapi.model.Account;
import com.bankingapi.bankingapi.model.Customer;
import com.bankingapi.bankingapi.model.Transfer;
import com.bankingapi.bankingapi.repository.AccountRepository;
import com.bankingapi.bankingapi.repository.TransferRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccountService {
    private final AccountRepository accountRepository;
    private final TransferRepository transferRepository;
    private final CustomerService customerService;
    private final AccountMapper accountMapper;

    public AccountResponseDto createAccount(CreateAccountRequestDto createAccountRequestDto) {
        Account account = accountMapper.toAccountFromCreateAccountRequest(createAccountRequestDto);
        account.setCustomer(customerService.findById(createAccountRequestDto.getCustomerId()).orElseThrow(()-> new CustomerNotFoundException("Customer not found!")));
        accountRepository.save(account);

        return accountMapper.toAccountResponseDto(account);
    }

    public AccountResponseDto getAccountById(Integer id) {
        Optional<Account> accountOptional = accountRepository.findById(id);

        return accountOptional.map(this::toAccountResponseDto)
                .orElseThrow(()-> new AccountNotFoundException("Account not found!"));
    }

    public List<TransferResponseDto> getTranfersByAccountId(Integer id) {

        Optional<Account> account = accountRepository.findById(id);
        List<Transfer> transfers = transferRepository.findByReceiverOrSender(account,account);

        return transfers.stream().map(this::toTransferResponseDto).toList();

    }
    public TransferResponseDto toTransferResponseDto(Transfer transfer){
        return TransferResponseDto.builder()
                .sender(transfer.getSender().getId())
                .receiver(transfer.getReceiver().getId())
                .amount(transfer.getAmount())
                .build();
    }

    public List<AccountResponseDto> getAllAccounts() {
        List<Account> accountList = accountRepository.findAll();
        return accountList.stream()
                .map(this::toAccountResponseDto)
                .toList();
    }

    public AccountResponseDto toAccountResponseDto(Account account){
        return AccountResponseDto.builder()
                .customerId(account.getCustomer().getId())
                .amount(account.getAmount())
                .build();
    }
}
