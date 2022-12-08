package com.jmontiel.banking.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class ApiExeptionHandler {

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<ApiError> jwtTokenExceptionHandler(final CustomException ex, final WebRequest request) {
        final ApiError apiError = new ApiError(ex.getErrorCode(), ex.getMessage());
        return new ResponseEntity<>(apiError, ex.getErrorCode());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiError> jwtTokenExceptionHandler(final Exception ex, final WebRequest request) {
        final ApiError apiError = new ApiError(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
        return new ResponseEntity<>(apiError, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
