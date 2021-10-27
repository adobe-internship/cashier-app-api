package com.demo.cashierapp.model.apiService.productInfo;

import com.demo.cashierapp.entity.Product;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CreateProductInfoRequestModel extends BaseProductInfo{

    @JsonProperty("product")
    private Product product;

    public CreateProductInfoRequestModel(Product product, int quantity) {
        super(product, quantity);
        this.product = product;
    }
}
