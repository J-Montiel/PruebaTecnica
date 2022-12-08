package com.jmontiel.banking.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

public class CustomException extends RuntimeException {

    @Getter
    private final HttpStatus errorCode;

    public CustomException(final HttpStatus errorCode, final String message) {
        super(message);
        this.errorCode = errorCode;
    }

}
