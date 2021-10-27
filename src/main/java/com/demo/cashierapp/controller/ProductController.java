package com.demo.cashierapp.controller;

import com.demo.cashierapp.api.service.product.ProductApiService;
import com.demo.cashierapp.model.apiService.product.*;
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

    @PutMapping
    public ProductDetailsResponseModel update(@RequestBody UpdateProductRequestModel updateProductRequestModel) {
        return productApiService.update(updateProductRequestModel);
    }

    @GetMapping
    public List<ProductDetailsResponseModel> getAll() {
        return productApiService.getAll();
    }

    @DeleteMapping("/delete/{barcode}")
    public void deleteByBarcode(@PathVariable String barcode) {
        productApiService.deleteByBarcode(barcode);
    }

    @GetMapping("/buy")
    public BuyProductResponseModel buyProduct(@RequestBody BuyProductRequestModel requestModel) {
        return productApiService.buyProduct(requestModel);
    }

    @PostMapping("/return")
    public void returnProduct(@RequestBody ReturnProductRequestModel requestModel) {
        productApiService.returnProduct(requestModel);
    }
}