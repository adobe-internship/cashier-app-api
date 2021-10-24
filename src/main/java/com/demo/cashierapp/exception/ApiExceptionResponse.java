package com.demo.cashierapp.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

@Getter
@RequiredArgsConstructor
public class ApiExceptionResponse {
    private final String message;
    private final ErrorSubtype error;
    private final HttpStatus httpStatus;
    private final ZonedDateTime zonedDateTime;
}
