package com.demo.cashierapp.api.service.response.builder.impl;

import com.demo.cashierapp.api.service.response.builder.ProductInfoDetailsResponseModelBuilder;
import com.demo.cashierapp.entity.ProductInfo;
import com.demo.cashierapp.model.apiService.productInfo.ProductInfoDetailsResponseModel;
import com.demo.cashierapp.service.productInfo.ProductInfoService;
import org.springframework.security.core.parameters.P;

public class ProductInfoDetailsResponseModelBuilderImpl implements ProductInfoDetailsResponseModelBuilder {
    private ProductInfoService productInfoService;
    @Override
    public ProductInfoDetailsResponseModel build(String barcode) {
        ProductInfo productInfo = productInfoService.getProductInfoByProductBarcode(barcode);
        ProductInfoDetailsResponseModel model=new ProductInfoDetailsResponseModel();
        model.setProduct(productInfo.getProduct());
        model.setQuantity(productInfo.getQuantity());
        return model;
    }
}
