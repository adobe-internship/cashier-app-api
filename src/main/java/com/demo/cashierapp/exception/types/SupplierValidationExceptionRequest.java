package com.demo.cashierapp.exception.types;

import com.demo.cashierapp.exception.ErrorSubtype;

import java.util.List;

public class SupplierValidationExceptionRequest extends ApiExceptionRequest {
    public SupplierValidationExceptionRequest(String message, List<ErrorSubtype> errors) {
        super(message, errors);
    }
}