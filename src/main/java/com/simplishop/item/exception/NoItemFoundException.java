package com.simplishop.item.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND, reason = "No item found with that id")
public class NoItemFoundException extends RuntimeException{

    private String message;

    public NoItemFoundException() {}

    public NoItemFoundException(String msg) {
        super(msg);
    }
}
