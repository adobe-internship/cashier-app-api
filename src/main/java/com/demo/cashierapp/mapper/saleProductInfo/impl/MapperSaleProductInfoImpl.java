package com.demo.cashierapp.mapper.saleProductInfo.impl;

import com.demo.cashierapp.mapper.saleProductInfo.MapperSaleProductInfo;
import com.demo.cashierapp.model.apiService.saleProductInfo.CreateSaleProductInfoRequestModel;
import com.demo.cashierapp.model.service.productInfo.CreateProductInfoParams;
import com.demo.cashierapp.model.service.saleProductInfo.CreateSaleProductInfoParams;
import org.springframework.stereotype.Component;

@Component
public class MapperSaleProductInfoImpl implements MapperSaleProductInfo {
    @Override
    public CreateSaleProductInfoParams mapToCreateSaleProductInfoParams(CreateSaleProductInfoRequestModel createSaleProductInfoRequestModel) {
        return new CreateSaleProductInfoParams(
                createSaleProductInfoRequestModel.getSale(),
                createSaleProductInfoRequestModel.getProductInfo()
        );
    }
}
