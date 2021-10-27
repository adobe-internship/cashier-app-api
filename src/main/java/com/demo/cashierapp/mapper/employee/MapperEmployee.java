package com.demo.cashierapp.mapper.employee;

import com.demo.cashierapp.model.apiService.employee.CreateEmployeeRequestModel;
import com.demo.cashierapp.model.apiService.employee.UpdateEmployeeRequestModel;
import com.demo.cashierapp.model.service.employee.CreateEmployeeParams;
import com.demo.cashierapp.model.service.employee.UpdateEmployeeParams;

public interface MapperEmployee {
    CreateEmployeeParams mapToCreateEmployeeParams(CreateEmployeeRequestModel createEmployeeRequestModel);

    UpdateEmployeeParams mapToUpdateEmployeeParams(UpdateEmployeeRequestModel updateEmployeeRequestModel);
}
