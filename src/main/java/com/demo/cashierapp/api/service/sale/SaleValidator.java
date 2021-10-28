package com.demo.cashierapp.api.service.sale;

import com.demo.cashierapp.exception.ErrorSubtype;
import com.demo.cashierapp.model.apiService.sale.CreateSaleRequestModel;

import java.util.List;

public interface SaleValidator {

    List<ErrorSubtype> validate(CreateSaleRequestModel requestModel);

}