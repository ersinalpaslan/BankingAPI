package com.bankingapi.bankingapi.exception;

public abstract class BaseException extends RuntimeException {
    public BaseException(String message){
        super(message);
    }
}
