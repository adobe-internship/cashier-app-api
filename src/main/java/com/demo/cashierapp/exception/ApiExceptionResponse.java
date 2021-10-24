package com.demo.cashierapp.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;
import java.util.List;

@Getter
@RequiredArgsConstructor
public class ApiExceptionResponse {
    private final String message;
    private final List<ErrorSubtype> errors;
    private final HttpStatus httpStatus;
    private final ZonedDateTime zonedDateTime;
}
