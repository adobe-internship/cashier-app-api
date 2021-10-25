package com.demo.cashierapp.model.apiService.authentication;

import com.demo.cashierapp.model.apiService.employee.EmployeeDetailsResponseModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AuthenticatedEmployeeResponseModel {
    private String token;
    EmployeeDetailsResponseModel employeeModel;

}
