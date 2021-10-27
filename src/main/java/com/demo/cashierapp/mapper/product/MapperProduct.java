package com.demo.cashierapp.mapper.product;

import com.demo.cashierapp.model.apiService.product.CreateProductRequestModel;
import com.demo.cashierapp.model.apiService.product.UpdateProductRequestModel;
import com.demo.cashierapp.model.service.product.CreateProductParams;
import com.demo.cashierapp.model.service.product.UpdateProductParams;

public interface MapperProduct {
    CreateProductParams mapToCreateProductParams(CreateProductRequestModel createProductRequestModel);

    UpdateProductParams mapToCreateProductParams(UpdateProductRequestModel updateProductRequestModel);
}
