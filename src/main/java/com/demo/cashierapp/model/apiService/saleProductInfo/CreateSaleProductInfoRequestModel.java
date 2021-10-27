package com.demo.cashierapp.model.apiService.saleProductInfo;

import com.demo.cashierapp.entity.Product;
import com.demo.cashierapp.entity.ProductInfo;
import com.demo.cashierapp.entity.Sale;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CreateSaleProductInfoRequestModel extends BaseSaleProductInfo {
    public CreateSaleProductInfoRequestModel(Sale sale, ProductInfo productInfo) {
        super(sale, productInfo);
    }
}
