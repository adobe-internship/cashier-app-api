package com.demo.cashierapp.exception;

import com.demo.cashierapp.exception.types.ApiRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@ControllerAdvice
public class ApiExceptionHandler{

    @ExceptionHandler(value = {ApiRequestException.class})
    public ResponseEntity<Object> handleUserExistsException (ApiRequestException e) {
        final HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
        final ApiExceptionResponse response = new ApiExceptionResponse(
                e.getMessage(),
                ErrorSubtype.USERNAME_EXISTS,
                httpStatus,
                ZonedDateTime.now(ZoneId.of("Z"))
        );
        return new ResponseEntity<>(response, httpStatus);
    }
}
