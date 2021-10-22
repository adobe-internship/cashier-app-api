package com.demo.cashierapp.mapper.employee.impl;

import com.demo.cashierapp.mapper.employee.MapperEmployee;
import com.demo.cashierapp.model.apiService.employee.CreateEmployeeRequestModel;
import com.demo.cashierapp.model.service.employee.CreateEmployeeParams;
import org.springframework.stereotype.Component;


@Component
public class MapperEmployeeImpl implements MapperEmployee {

    public CreateEmployeeParams mapToCreateEmployeeParams(CreateEmployeeRequestModel createEmployeeRequestModel) {
        return new CreateEmployeeParams(
                createEmployeeRequestModel.getUsername(),
                createEmployeeRequestModel.getPassword(),
                createEmployeeRequestModel.getFirstName(),
                createEmployeeRequestModel.getLastName()
        );
    }
}
