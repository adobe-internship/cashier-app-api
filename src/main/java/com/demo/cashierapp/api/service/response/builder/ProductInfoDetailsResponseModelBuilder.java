package com.demo.cashierapp.api.service.response.builder;

import com.demo.cashierapp.model.apiService.productInfo.ProductInfoDetailsResponseModel;

public interface ProductInfoDetailsResponseModelBuilder {

    ProductInfoDetailsResponseModel build(String barcode);

}
