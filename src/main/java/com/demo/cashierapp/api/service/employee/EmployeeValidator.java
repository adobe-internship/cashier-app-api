package com.demo.cashierapp.api.service.employee;

import com.demo.cashierapp.exception.ErrorSubtype;
import com.demo.cashierapp.model.apiService.employee.CreateEmployeeRequestModel;

import java.util.List;

public interface EmployeeValidator {
    List<ErrorSubtype> validate(CreateEmployeeRequestModel requestModel);
    List<ErrorSubtype> validate(String username);
}
