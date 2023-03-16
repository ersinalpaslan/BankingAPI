package com.bankingapi.bankingapi.exception;

import com.bankingapi.bankingapi.model.ExceptionModel;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GeneralExceptionAdviser {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> generalExceptionHandler(Exception exception){
        return new ResponseEntity<>(exception.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler({AccountNotFoundException.class,CustomerNotFoundException.class})
    public ResponseEntity<?> baseExceptionHandler(BaseException exception){
        ExceptionModel exceptionModel = new ExceptionModel(HttpStatus.NOT_FOUND, exception.getMessage());
        return new ResponseEntity<ExceptionModel>(exceptionModel,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InsufficientAmountException.class)
    public ResponseEntity<?> InsufficientAmountExceptionHandler(BaseException exception){
        ExceptionModel exceptionModel = new ExceptionModel(HttpStatus.UNPROCESSABLE_ENTITY, exception.getMessage());
        return new ResponseEntity<ExceptionModel>(exceptionModel,HttpStatus.BAD_REQUEST);
    }
}
