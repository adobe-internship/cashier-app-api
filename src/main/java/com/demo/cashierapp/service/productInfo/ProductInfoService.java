package com.demo.cashierapp.service.productInfo;

import com.demo.cashierapp.entity.ProductInfo;
import com.demo.cashierapp.model.service.productInfo.CreateProductInfoParams;

import java.util.List;

public interface ProductInfoService {

    ProductInfo create(CreateProductInfoParams createProductInfoParams);

    List<ProductInfo> getAll();

    ProductInfo getProductInfoByProductBarcode(String barcode);

}
