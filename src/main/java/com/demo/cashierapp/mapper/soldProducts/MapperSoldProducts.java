package com.demo.cashierapp.mapper.soldProducts;

import com.demo.cashierapp.model.apiService.soldProducts.CreateSoldProductsRequestModel;
import com.demo.cashierapp.model.service.soldProducts.CreateSoldProductsParams;

public interface MapperSoldProducts {

    CreateSoldProductsParams mapToCreateSoldProductsParams(CreateSoldProductsRequestModel createSoldProductsRequestModel);


}
