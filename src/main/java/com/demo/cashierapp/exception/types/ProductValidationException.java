package com.demo.cashierapp.exception.types;

import com.demo.cashierapp.exception.ErrorSubtype;

import java.util.List;

public class ProductValidationException extends ApiRequestException{
    public ProductValidationException(String message, List<ErrorSubtype> errors) {
        super(message, errors);
    }
}
