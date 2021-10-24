package com.demo.cashierapp.exception.types;

import com.demo.cashierapp.exception.ErrorSubtype;

import java.util.List;

public class EmployeeValidationException extends ApiRequestException{
    public EmployeeValidationException(String message, List<ErrorSubtype> errors) {
        super(message, errors);
    }
}
