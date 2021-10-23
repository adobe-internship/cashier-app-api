package com.demo.cashierapp.api.service.response.builder;

import com.demo.cashierapp.model.apiService.product.ProductDetailsResponseModel;

public interface ProductDetailsResponseModelBuilder {
    ProductDetailsResponseModel build(String barcode);
}
