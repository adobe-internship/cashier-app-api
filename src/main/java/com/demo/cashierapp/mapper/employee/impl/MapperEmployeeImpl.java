package com.demo.cashierapp.mapper.employee.impl;

import com.demo.cashierapp.mapper.employee.MapperEmployee;
import com.demo.cashierapp.model.apiService.employee.CreateEmployeeRequestModel;
import com.demo.cashierapp.model.apiService.employee.UpdateEmployeeRequestModel;
import com.demo.cashierapp.model.service.employee.CreateEmployeeParams;
import com.demo.cashierapp.model.service.employee.UpdateEmployeeParams;
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

    @Override
    public UpdateEmployeeParams mapToUpdateEmployeeParams(UpdateEmployeeRequestModel updateEmployeeRequestModel) {
        return new UpdateEmployeeParams(
                updateEmployeeRequestModel.getUsername(),
                updateEmployeeRequestModel.getPassword(),
                updateEmployeeRequestModel.getFirstName(),
                updateEmployeeRequestModel.getLastName()
        );
    }
}
