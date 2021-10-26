package com.demo.cashierapp.exception.types;

import com.demo.cashierapp.exception.ErrorSubtype;

import java.util.List;

public class EmployeeValidationExceptionRequest extends ApiExceptionRequest {
    public EmployeeValidationExceptionRequest(String message, List<ErrorSubtype> errors) {
        super(message, errors);
    }
}
