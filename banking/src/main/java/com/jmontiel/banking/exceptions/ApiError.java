package com.jmontiel.banking.exceptions;


import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
@Getter
@Setter
public class ApiError {

    private int code;

    private String message;

    private HttpStatus status;

    public ApiError(final HttpStatus status, final String message) {
        this.code = status.value();
        this.status = status;
        this.message = message;
    }
}
