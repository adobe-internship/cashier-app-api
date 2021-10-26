package com.demo.cashierapp.api.service.response.builder.impl;

import com.demo.cashierapp.api.service.response.builder.BuyProductResponseModelBuilder;
import com.demo.cashierapp.entity.Product;
import com.demo.cashierapp.model.apiService.product.BuyProductResponseModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BuyProductResponseModelBuilderImpl implements BuyProductResponseModelBuilder {
    @Override
    public BuyProductResponseModel build(Product product) {
        BuyProductResponseModel model = new BuyProductResponseModel();
        model.setBrand(product.getBrand());
        model.setBarcode(product.getBarcode());
        model.setProductName(product.getProductName());
        model.setProductDescription(product.getProductDescription());
        model.setQuantity(product.getQuantity());
        model.setUnitOfMeasurement(product.getUnitOfMeasurement());
        model.setSalePrice(product.getSalePrice());
        return model;
    }
}
