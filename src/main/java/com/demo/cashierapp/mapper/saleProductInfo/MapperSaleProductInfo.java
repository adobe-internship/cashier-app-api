package com.demo.cashierapp.mapper.saleProductInfo;

import com.demo.cashierapp.model.apiService.saleProductInfo.CreateSaleProductInfoRequestModel;
import com.demo.cashierapp.model.service.saleProductInfo.CreateSaleProductInfoParams;

public interface MapperSaleProductInfo {

    CreateSaleProductInfoParams mapToCreateSaleProductInfoParams(CreateSaleProductInfoRequestModel createSaleProductInfoRequestModel);


}
