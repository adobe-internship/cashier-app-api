package com.demo.cashierapp.api.service.employee;

import com.demo.cashierapp.exception.ErrorSubtype;
import com.demo.cashierapp.model.apiService.employee.BaseEmployee;
import com.demo.cashierapp.model.apiService.employee.CreateEmployeeRequestModel;
import com.demo.cashierapp.model.apiService.employee.UpdateEmployeeRequestModel;

import java.util.List;


public interface EmployeeValidator {
    List<ErrorSubtype> validate(CreateEmployeeRequestModel requestModel);
    List<ErrorSubtype> validate(UpdateEmployeeRequestModel requestModel);
    List<ErrorSubtype> validate(String name);
}
