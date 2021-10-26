package com.demo.cashierapp.exception.types;

import com.demo.cashierapp.exception.ErrorSubtype;

import java.util.List;

public class ProductValidationExceptionRequest extends ApiExceptionRequest {
    public ProductValidationExceptionRequest(String message, List<ErrorSubtype> errors) {
        super(message, errors);
    }
}
