package com.demo.cashierapp.mapper.product;

import com.demo.cashierapp.model.apiService.product.CreateProductRequestModel;
import com.demo.cashierapp.model.service.product.CreateProductParams;

public interface MapperProduct {
    CreateProductParams mapToCreateProductParams(CreateProductRequestModel createProductRequestModel);
}
