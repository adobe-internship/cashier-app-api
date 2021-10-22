package com.demo.cashierapp.controller;

import com.demo.cashierapp.api.service.employee.impl.EmployeeApiServiceImpl;
import com.demo.cashierapp.model.apiService.employee.CreateEmployeeRequestModel;
import com.demo.cashierapp.model.apiService.employee.EmployeeDetailsResponseModel;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/api/employee")
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeApiServiceImpl employeeApiService;

    @PostMapping
    public EmployeeDetailsResponseModel create(@RequestBody CreateEmployeeRequestModel createEmployeeRequestModel) {
        return employeeApiService.create(createEmployeeRequestModel);
    }

    @GetMapping
    public List<EmployeeDetailsResponseModel> getAll() {
        return employeeApiService.getAll();
    }
}
