package com.demo.cashierapp.api.service;


import com.demo.cashierapp.model.apiService.employee.EmployeeDetailsResponseModel;

public interface EmployeeDetailsResponseModelBuilder {

    EmployeeDetailsResponseModel build(String username);
}
