package com.demo.cashierapp.mapper.productInfo;

import com.demo.cashierapp.model.apiService.productInfo.CreateProductInfoRequestModel;
import com.demo.cashierapp.model.service.productInfo.CreateProductInfoParams;

public interface MapperProductInfo {
    CreateProductInfoParams mapToCreateProductInfoParams(CreateProductInfoRequestModel createProductInfoRequestModel);

}
