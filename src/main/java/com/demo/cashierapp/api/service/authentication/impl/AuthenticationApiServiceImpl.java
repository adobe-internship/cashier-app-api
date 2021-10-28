package com.demo.cashierapp.api.service.authentication.impl;

import com.demo.cashierapp.api.service.authentication.AuthenticationApiService;
import com.demo.cashierapp.api.service.employee.EmployeeValidator;
import com.demo.cashierapp.entity.Employee;
import com.demo.cashierapp.entity.EmployeeRole;
import com.demo.cashierapp.exception.ErrorSubtype;
import com.demo.cashierapp.exception.types.EmployeeValidationExceptionRequest;
import com.demo.cashierapp.model.apiService.authentication.AuthenticatedEmployeeResponseModel;
import com.demo.cashierapp.model.apiService.authentication.EmployeeAuthenticationRequestModel;
import com.demo.cashierapp.security.jwt.SecurityConst;
import com.demo.cashierapp.service.employee.EmployeeService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class AuthenticationApiServiceImpl implements AuthenticationApiService {
    private final EmployeeService employeeService;
    private final EmployeeValidator employeeValidator;

    @Override
    public AuthenticatedEmployeeResponseModel login(EmployeeAuthenticationRequestModel requestModel) {
        final List<ErrorSubtype> errorSubtypes = employeeValidator.validate(requestModel.getUsername());
        if (!errorSubtypes.isEmpty()) {
            throw new EmployeeValidationExceptionRequest("Validation Error", errorSubtypes);
        }

        final Employee employee = employeeService.getEmployeeByUsername(requestModel.getUsername());
        final boolean checkPassword = BCrypt.checkpw(requestModel.getPassword(), employee.getPassword());
        if (!checkPassword) {
            errorSubtypes.add(ErrorSubtype.INVALID_USERNAME_OR_PASSWORD);
            throw new EmployeeValidationExceptionRequest("Validation Error", errorSubtypes);
        }
        final List<EmployeeRole> roles = employee.getRoles();
        String token = Jwts.builder()
                .claim("authorities", roles.stream().map(role -> role.getRole().name()).collect(Collectors.toList()))
                .claim("username", employee.getUsername())
                .claim("firstName", employee.getFirstName())
                .claim("lastName", employee.getLastName())
                .signWith(SecurityConst.KEY)
                .compact();
        final AuthenticatedEmployeeResponseModel responseModel = new AuthenticatedEmployeeResponseModel();
        responseModel.setToken(token);
        return responseModel;
    }
}
