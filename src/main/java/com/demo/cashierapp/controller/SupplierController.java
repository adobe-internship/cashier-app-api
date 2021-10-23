package com.demo.cashierapp.controller;

import com.demo.cashierapp.api.service.supplier.impl.SupplierApiServiceImpl;
import com.demo.cashierapp.model.apiService.supplier.CreateSupplierRequestModel;
import com.demo.cashierapp.model.apiService.supplier.SupplierDetailsResponseModel;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


    @CrossOrigin("http://localhost:3000")
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
}
