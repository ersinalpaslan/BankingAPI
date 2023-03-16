package com.bankingapi.bankingapi.controller;

import com.bankingapi.bankingapi.dto.request.CreateAccountRequestDto;
import com.bankingapi.bankingapi.dto.response.AccountResponseDto;
import com.bankingapi.bankingapi.dto.response.CustomerResponseDto;
import com.bankingapi.bankingapi.dto.response.TransferResponseDto;
import com.bankingapi.bankingapi.service.AccountService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/v1/accounts")
public class AccountController {
    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping
    public ResponseEntity<List<AccountResponseDto>> getAllAccounts(){
        return ResponseEntity.ok(accountService.getAllAccounts());
    }

    @PostMapping()
    public ResponseEntity<AccountResponseDto> createAccount(@Valid @RequestBody CreateAccountRequestDto createAccountRequestDto){
        return new ResponseEntity(accountService.createAccount(createAccountRequestDto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccountResponseDto> getAccountById(@PathVariable Integer id){
        return ResponseEntity.ok(accountService.getAccountById(id));
    }

    @GetMapping("/{id}/transfers")
    public ResponseEntity<List<TransferResponseDto>> getTranfersByAccountId(@PathVariable Integer id){
        return ResponseEntity.ok(accountService.getTranfersByAccountId(id));
    }

}
