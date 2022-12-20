package com.simplishop.item.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND, reason = "No user found with that id")
public class UserNotFoundException extends RuntimeException{

    private String message;

    public UserNotFoundException() {}

    public UserNotFoundException(String msg) {
        super(msg);
    }
}