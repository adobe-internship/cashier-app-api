package com.demo.cashierapp.api.service.employee;

import com.demo.cashierapp.model.apiService.employee.*;
import java.util.List;

public interface EmployeeApiService {
    EmployeeDetailsResponseModel create(CreateEmployeeRequestModel createEmployeeRequestModel);

    List<EmployeeDetailsResponseModel> getAll();

    EmployeeDetailsResponseModel getByUsername(String username);

    void deleteByUsername(String username);

    EmployeeDetailsResponseModel update(UpdateEmployeeRequestModel updateEmployeeRequestModel);
}
