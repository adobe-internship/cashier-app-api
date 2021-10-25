package com.demo.cashierapp.api.service.supplier;

import com.demo.cashierapp.exception.ErrorSubtype;
import com.demo.cashierapp.model.apiService.supplier.CreateSupplierRequestModel;

import java.util.List;

public interface SupplierValidator {

    List<ErrorSubtype> validate(CreateSupplierRequestModel requestModel);

    List<ErrorSubtype> validate(String username);

}
