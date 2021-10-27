package com.demo.cashierapp.service.saleProductInfo;

import com.demo.cashierapp.entity.Product;
import com.demo.cashierapp.entity.SaleProductInfo;
import com.demo.cashierapp.model.service.product.CreateProductParams;
import com.demo.cashierapp.model.service.saleProductInfo.CreateSaleProductInfoParams;

import java.util.List;

public interface SaleProductInfoService {
    SaleProductInfo create(CreateSaleProductInfoParams createSaleProductInfoParams);

    List<SaleProductInfo> getAll();

}
