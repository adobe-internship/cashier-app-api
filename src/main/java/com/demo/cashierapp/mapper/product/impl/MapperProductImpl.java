package com.demo.cashierapp.mapper.product.impl;

import com.demo.cashierapp.mapper.product.MapperProduct;
import com.demo.cashierapp.model.apiService.product.CreateProductRequestModel;
import com.demo.cashierapp.model.service.product.CreateProductParams;
import org.springframework.stereotype.Component;

@Component
public class MapperProductImpl implements MapperProduct {

    public CreateProductParams mapToCreateProductParams(CreateProductRequestModel createProductRequestModel) {
        return new CreateProductParams(
                null,
                createProductRequestModel.getBrand(),
                createProductRequestModel.getBarcode(),
                createProductRequestModel.getProductName(),
                createProductRequestModel.getProductDescription(),
                createProductRequestModel.getQuantity(),
                createProductRequestModel.getUnitOfMeasurement(),
                createProductRequestModel.getCostPrice(),
                createProductRequestModel.getSalePrice()
        );
    }
}
