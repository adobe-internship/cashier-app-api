package com.demo.cashierapp.controller;

import com.demo.cashierapp.api.service.sale.SaleApiService;
import com.demo.cashierapp.model.apiService.sale.CreateSaleRequestModel;
import com.demo.cashierapp.model.apiService.sale.SaleDetailsResponseModel;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/api/sale")
@RequiredArgsConstructor
public class SaleController {
    private final SaleApiService saleApiService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody CreateSaleRequestModel createSaleRequestModel) {
        saleApiService.create(createSaleRequestModel);
        return new ResponseEntity<>(new Object(), HttpStatus.OK);
    }
    @GetMapping
    public List<SaleDetailsResponseModel> getAll() {
        return saleApiService.getAll();
    }
}
