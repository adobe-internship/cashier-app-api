package com.demo.cashierapp.api.service.response.builder;

import com.demo.cashierapp.model.apiService.authentication.AuthenticatedEmployeeResponseModel;

public interface EmployeeAuthenticationResponseModelBuilder {
    AuthenticatedEmployeeResponseModel build(String username);
}
