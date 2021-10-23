package com.demo.cashierapp.controller;

import com.demo.cashierapp.api.service.product.ProductApiService;
import com.demo.cashierapp.model.apiService.product.CreateProductRequestModel;
import com.demo.cashierapp.model.apiService.product.ProductDetailsResponseModel;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductApiService productApiService;

    @PostMapping
    public ProductDetailsResponseModel save(@RequestBody CreateProductRequestModel createProductRequestModel) {
        return productApiService.create(createProductRequestModel);
    }

    @GetMapping
    public List<ProductDetailsResponseModel> getAll() {
        return productApiService.getAll();
    }

    @DeleteMapping("/delete/{barcode}")
    public void deleteByBarcode(@PathVariable String barcode) {
        productApiService.deleteByBarcode(barcode);
    }
}