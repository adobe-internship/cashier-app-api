package com.demo.cashierapp.api.service.response.builder.impl;

import com.demo.cashierapp.api.service.response.builder.ProductInfoDetailsResponseModelBuilder;
import com.demo.cashierapp.entity.Product;
import com.demo.cashierapp.entity.ProductInfo;
import com.demo.cashierapp.model.apiService.product.ProductDetailsResponseModel;
import com.demo.cashierapp.model.apiService.productInfo.ProductInfoDetailsResponseModel;
import com.demo.cashierapp.service.productInfo.ProductInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductInfoDetailsResponseModelBuilderImpl implements ProductInfoDetailsResponseModelBuilder {
    private ProductInfoService productInfoService;

    @Override
    public ProductInfoDetailsResponseModel build(String barcode) {
        ProductInfo productInfo = productInfoService.getProductInfoByProductBarcode(barcode);
        ProductInfoDetailsResponseModel model=new ProductInfoDetailsResponseModel();
        model.setQuantity(productInfo.getQuantity());
        model.setProduct(productInfo.getProduct());
        return model;
    }
}
