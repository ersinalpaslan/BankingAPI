package com.bankingapi.bankingapi.exception;

public class CustomerNotFoundException extends BaseException{
    public CustomerNotFoundException(String message){
        super(message);
    }
}
