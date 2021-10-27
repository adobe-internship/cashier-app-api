package com.demo.cashierapp.controller;

import com.demo.cashierapp.api.service.supplier.impl.SupplierApiServiceImpl;
import com.demo.cashierapp.model.apiService.supplier.CreateSupplierRequestModel;
import com.demo.cashierapp.model.apiService.supplier.SupplierDetailsResponseModel;
import com.demo.cashierapp.model.apiService.supplier.SupplierUpdateRequestModel;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/supplier")
@RequiredArgsConstructor
public class SupplierController {
    private final SupplierApiServiceImpl supplierApiService;

    @PostMapping
    public SupplierDetailsResponseModel create(@RequestBody CreateSupplierRequestModel createSupplierRequestModel) {
        return supplierApiService.create(createSupplierRequestModel);
    }

    @GetMapping
    public List<SupplierDetailsResponseModel> getAll() {
        return supplierApiService.getAll();
    }

    @PutMapping
    public SupplierDetailsResponseModel update(@RequestBody SupplierUpdateRequestModel supplierUpdateRequestModel) {
        return supplierApiService.update(supplierUpdateRequestModel);
    }

    @GetMapping("/{name}")
    public SupplierDetailsResponseModel getByName(@PathVariable String name) {
        return supplierApiService.getByName(name);
    }
}
