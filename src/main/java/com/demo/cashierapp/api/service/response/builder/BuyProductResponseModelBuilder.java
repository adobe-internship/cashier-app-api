package com.demo.cashierapp.api.service.response.builder;

import com.demo.cashierapp.entity.Product;
import com.demo.cashierapp.model.apiService.product.BuyProductResponseModel;


public interface BuyProductResponseModelBuilder {
    BuyProductResponseModel build(Product product);
}
