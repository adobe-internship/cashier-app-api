package com.demo.cashierapp.model.apiService.authentication;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EmployeeAuthenticationRequestModel {
    private String username;
    private String password;
}
