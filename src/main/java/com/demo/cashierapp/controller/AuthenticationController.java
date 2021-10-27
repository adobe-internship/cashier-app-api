package com.demo.cashierapp.controller;

import com.demo.cashierapp.api.service.authentication.AuthenticationApiService;
import com.demo.cashierapp.model.apiService.authentication.AuthenticatedEmployeeResponseModel;
import com.demo.cashierapp.model.apiService.authentication.EmployeeAuthenticationRequestModel;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/auth/login")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationApiService authenticationApiService;

    @PostMapping
    public AuthenticatedEmployeeResponseModel login(@RequestBody EmployeeAuthenticationRequestModel authenticationRequestModel) {
        return authenticationApiService.login(authenticationRequestModel);
    }
}
