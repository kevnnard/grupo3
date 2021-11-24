package com.misionticg9.account_ms.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

public class InsufficientBalanceException extends RuntimeException{

    public InsufficientBalanceException(String message){
        super(message);
    }

    @ResponseBody
    @ExceptionHandler(InsufficientBalanceException.class)
        @ResponseStatus(HttpStatus.CONFLICT)
        String InsufficientBalanceAdvice(){
            return getMessage();
        }
}