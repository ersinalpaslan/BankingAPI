package com.bankingapi.bankingapi.exception;

public class AccountNotFoundException extends BaseException{
    public AccountNotFoundException(String message){
        super(message);
    }
}
