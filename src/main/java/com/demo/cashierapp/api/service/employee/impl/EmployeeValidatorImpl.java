package com.demo.cashierapp.api.service.employee.impl;

import com.demo.cashierapp.api.service.employee.EmployeeValidator;
import com.demo.cashierapp.exception.ErrorSubtype;
import com.demo.cashierapp.model.apiService.employee.CreateEmployeeRequestModel;
import com.demo.cashierapp.model.apiService.employee.UpdateEmployeeRequestModel;
import com.demo.cashierapp.service.employee.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.regex.Pattern.compile;

@Component
@RequiredArgsConstructor

public class EmployeeValidatorImpl implements EmployeeValidator {
    private final EmployeeService employeeService;

    @Override
    public List<ErrorSubtype> validate(CreateEmployeeRequestModel requestModel) {
        final List<ErrorSubtype> errors = new LinkedList<>();
        if (StringUtils.isEmpty(requestModel.getUsername())) {
            errors.add(ErrorSubtype.MISSING_USERNAME);
        } else if (employeeService.usernameExists(requestModel.getUsername())) {
            errors.add(ErrorSubtype.USERNAME_EXISTS);
        }
        if (StringUtils.isEmpty(requestModel.getFirstName())) {
            errors.add(ErrorSubtype.MISSING_FIRST_NAME);
        }
        if (StringUtils.isEmpty(requestModel.getLastName())) {
            errors.add(ErrorSubtype.MISSING_LAST_NAME);
        }
        if (StringUtils.isEmpty(requestModel.getPassword())) {
            errors.add(ErrorSubtype.MISSING_PASSWORD);
        } else if (!isPasswordValid(requestModel.getPassword())) {
            errors.add(ErrorSubtype.PASSWORD_IS_INVALID);
        }
        if (requestModel.getRoles().isEmpty()) {
            errors.add(ErrorSubtype.MISSING_ROLE);
        }
        return errors;
    }

    @Override
    public List<ErrorSubtype> validate(UpdateEmployeeRequestModel requestModel) {
        final List<ErrorSubtype> errors = new LinkedList<>();
        if (StringUtils.isEmpty(requestModel.getUsername())) {
            errors.add(ErrorSubtype.MISSING_USERNAME);
        } else if (employeeService.usernameExists(requestModel.getUsername())) {
            errors.add(ErrorSubtype.USERNAME_EXISTS);
        }
        if (StringUtils.isEmpty(requestModel.getFirstName())) {
            errors.add(ErrorSubtype.MISSING_FIRST_NAME);
        }
        if (StringUtils.isEmpty(requestModel.getLastName())) {
            errors.add(ErrorSubtype.MISSING_LAST_NAME);
        }
        if (StringUtils.isEmpty(requestModel.getPassword())) {
            errors.add(ErrorSubtype.MISSING_PASSWORD);
        } else if (!isPasswordValid(requestModel.getPassword())) {
            errors.add(ErrorSubtype.PASSWORD_IS_INVALID);
        }
        if (requestModel.getRoles().isEmpty()) {
            errors.add(ErrorSubtype.MISSING_ROLE);
        }
        return errors;
    }

    @Override
    public List<ErrorSubtype> validate(String username) {
        final List<ErrorSubtype> errors = new LinkedList<>();

        if (StringUtils.isEmpty(username)) {
            errors.add(ErrorSubtype.MISSING_USERNAME);
        } else if (!employeeService.usernameExists(username)) {
            errors.add(ErrorSubtype.USERNAME_DOES_NOT_EXIST);
        }
        return errors;
    }

    private boolean isPasswordValid(String password) {
        final String passwordPattern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$";
        final Pattern pattern = compile(passwordPattern);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }

}
