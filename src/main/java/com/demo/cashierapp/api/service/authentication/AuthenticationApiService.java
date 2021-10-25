package com.demo.cashierapp.api.service.authentication;

import com.demo.cashierapp.model.apiService.authentication.AuthenticatedEmployeeResponseModel;
import com.demo.cashierapp.model.apiService.authentication.EmployeeAuthenticationRequestModel;

public interface AuthenticationApiService {
    AuthenticatedEmployeeResponseModel login(EmployeeAuthenticationRequestModel requestModel);

}
