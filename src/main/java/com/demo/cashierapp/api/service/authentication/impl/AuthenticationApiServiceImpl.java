package com.demo.cashierapp.api.service.authentication.impl;

import com.demo.cashierapp.api.service.authentication.AuthenticationApiService;
import com.demo.cashierapp.api.service.employee.EmployeeValidator;
import com.demo.cashierapp.api.service.response.builder.EmployeeDetailsResponseModelBuilder;
import com.demo.cashierapp.entity.Employee;
import com.demo.cashierapp.exception.ErrorSubtype;
import com.demo.cashierapp.exception.types.EmployeeValidationException;
import com.demo.cashierapp.model.apiService.authentication.AuthenticatedEmployeeResponseModel;
import com.demo.cashierapp.model.apiService.authentication.EmployeeAuthenticationRequestModel;
import com.demo.cashierapp.service.employee.EmployeeService;
import com.demo.cashierapp.service.role.EmployeeRoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCrypt;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.List;

@Component
@RequiredArgsConstructor
public class AuthenticationApiServiceImpl implements AuthenticationApiService {
    private final EmployeeService employeeService;
    private final EmployeeValidator employeeValidator;
    private final EmployeeRoleService employeeRoleService;
    private final EmployeeDetailsResponseModelBuilder responseBuilder;

    @Override
    public AuthenticatedEmployeeResponseModel login(EmployeeAuthenticationRequestModel requestModel) {
        final List<ErrorSubtype> errorSubtypes = employeeValidator.validate(requestModel.getUsername());
        if (!errorSubtypes.isEmpty()) {
            throw new EmployeeValidationException("Employee does not validated. For more information see Errors", errorSubtypes);
        }

        final Employee employee = employeeService.getEmployeeByUsername(requestModel.getUsername());
        final boolean checkPassword = BCrypt.checkpw(requestModel.getPassword(), employee.getPassword());
        if (!checkPassword) {
            errorSubtypes.add(ErrorSubtype.INCORRECT_PASSWORD);
            throw new EmployeeValidationException("Employee does not validated. For more information see Errors", errorSubtypes);
        }

        Key key = Keys.hmacShaKeyFor("-Z6-BFxF3LHYb6NZ5jn4zJGHZ0T-EMnC5-hz-4gknvs".getBytes());
        String token = Jwts.builder()
                .claim("roles", employeeRoleService.getAllRolesByUsername(employee.getUsername()))
                .claim("username", employee.getUsername())
                .signWith(key).compact();

        final AuthenticatedEmployeeResponseModel responseModel = new AuthenticatedEmployeeResponseModel();
        responseModel.setToken(token);
        responseModel.setEmployeeModel(responseBuilder.build(employee.getUsername()));
        return responseModel;
    }
}
