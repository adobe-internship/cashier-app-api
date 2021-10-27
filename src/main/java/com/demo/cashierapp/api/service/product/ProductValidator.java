package com.demo.cashierapp.api.service.product;

import com.demo.cashierapp.exception.ErrorSubtype;
import com.demo.cashierapp.model.apiService.product.CreateProductRequestModel;

import java.util.List;

public interface ProductValidator {
    List<ErrorSubtype> validate(CreateProductRequestModel requestModel);

    List<ErrorSubtype> validate(String barcode);
}
