package com.demo.cashierapp.mapper.soldProducts.impl;

import com.demo.cashierapp.mapper.soldProducts.MapperSoldProducts;
import com.demo.cashierapp.model.apiService.soldProducts.CreateSoldProductsRequestModel;
import com.demo.cashierapp.model.service.soldProducts.CreateSoldProductsParams;
import org.springframework.stereotype.Component;

@Component
public class MapperSoldProductsImpl implements MapperSoldProducts {

    @Override
    public CreateSoldProductsParams mapToCreateSoldProductsParams(CreateSoldProductsRequestModel createSoldProductsRequestModel) {
        return new CreateSoldProductsParams(
                createSoldProductsRequestModel.getBarcode(),
                createSoldProductsRequestModel.getQuantity(),
                createSoldProductsRequestModel.getCostPrice(),
                createSoldProductsRequestModel.getSalePrice()
        );
    }
}
