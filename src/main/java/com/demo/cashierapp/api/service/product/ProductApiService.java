package com.demo.cashierapp.api.service.product;

import com.demo.cashierapp.model.apiService.product.CreateProductRequestModel;
import com.demo.cashierapp.model.apiService.product.ProductDetailsResponseModel;

import java.util.List;

public interface ProductApiService {
    ProductDetailsResponseModel create(CreateProductRequestModel createProductRequestModel);

    List<ProductDetailsResponseModel> getAll();

    ProductDetailsResponseModel getProductByBarcode(String barcode);
}
