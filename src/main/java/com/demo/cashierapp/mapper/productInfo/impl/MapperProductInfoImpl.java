package com.demo.cashierapp.mapper.productInfo.impl;

import com.demo.cashierapp.mapper.productInfo.MapperProductInfo;
import com.demo.cashierapp.model.apiService.productInfo.CreateProductInfoRequestModel;
import com.demo.cashierapp.model.service.productInfo.CreateProductInfoParams;
import org.springframework.stereotype.Component;

@Component
public class MapperProductInfoImpl implements MapperProductInfo {
    @Override
    public CreateProductInfoParams mapToCreateProductInfoParams(CreateProductInfoRequestModel createProductInfoRequestModel) {
        return new CreateProductInfoParams(
                createProductInfoRequestModel.getProduct(),
                createProductInfoRequestModel.getQuantity()
        );
    }

}
