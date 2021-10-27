package com.demo.cashierapp.mapper.sale;

import com.demo.cashierapp.model.apiService.sale.CreateSaleRequestModel;
import com.demo.cashierapp.model.service.sale.CreateSaleParams;

public interface MapperSale {
    CreateSaleParams mapToCreateSaleParams(CreateSaleRequestModel createSaleRequestModel);
}
