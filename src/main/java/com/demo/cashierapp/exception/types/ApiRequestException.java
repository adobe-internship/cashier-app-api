package com.demo.cashierapp.exception.types;

import com.demo.cashierapp.exception.ErrorSubtype;
import lombok.Getter;

import java.util.List;
@Getter
public class ApiRequestException extends RuntimeException{
    private final List<ErrorSubtype> errors;
    public ApiRequestException(String message, List<ErrorSubtype> errors ) {
        super(message);
        this.errors = errors;
    }
}
