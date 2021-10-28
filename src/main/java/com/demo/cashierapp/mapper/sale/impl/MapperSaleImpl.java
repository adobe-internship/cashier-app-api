package com.demo.cashierapp.mapper.sale.impl;

import com.demo.cashierapp.mapper.sale.MapperSale;
import com.demo.cashierapp.model.apiService.sale.CreateSaleRequestModel;
import com.demo.cashierapp.model.service.sale.CreateSaleParams;
import org.springframework.stereotype.Component;

@Component
public class MapperSaleImpl implements MapperSale {
    @Override
    public CreateSaleParams mapToCreateSaleParams(CreateSaleRequestModel createSaleRequestModel) {
        return  new CreateSaleParams(
                createSaleRequestModel.getAmount(),
                createSaleRequestModel.getEmployeeUsername()
        );
    }
}
