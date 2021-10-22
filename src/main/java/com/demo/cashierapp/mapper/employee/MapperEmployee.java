package com.demo.cashierapp.mapper.employee;

import com.demo.cashierapp.entity.Employee;
import com.demo.cashierapp.entity.Role;
import com.demo.cashierapp.model.apiService.employee.CreateEmployeeRequestModel;
import com.demo.cashierapp.model.service.employee.CreateEmployeeParams;

import java.util.List;

public interface MapperEmployee {
    CreateEmployeeParams mapToCreateEmployeeParams(CreateEmployeeRequestModel createEmployeeRequestModel);
}
