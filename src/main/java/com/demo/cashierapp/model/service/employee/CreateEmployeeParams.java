package com.demo.cashierapp.model.service.employee;

import lombok.Getter;

@Getter
public class CreateEmployeeParams {

    private final String username;
    private final String password;
    private final String firstName;
    private final String lastName;

    public CreateEmployeeParams(String username, String password, String firstName, String lastName) {
        if (username == null) {
            throw new IllegalArgumentException("The username should not be null");
        }
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
