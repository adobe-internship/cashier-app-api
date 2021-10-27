package com.demo.cashierapp.api.service.response.builder.impl;


import com.demo.cashierapp.api.service.response.builder.SaleProductInfoResponseModelBuilder;
import com.demo.cashierapp.entity.SaleProductInfo;
import com.demo.cashierapp.model.apiService.saleProductInfo.SaleProductInfoDetailsResponseModel;
import com.demo.cashierapp.service.saleProductInfo.SaleProductInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SaleProductInfoResponseModelBuilderImpl implements SaleProductInfoResponseModelBuilder {

    private SaleProductInfoService saleProductInfoService;

    @Override
    public SaleProductInfoDetailsResponseModel build(Long id) {
        SaleProductInfo saleproductInfo = null;//saleProductInfoService.get;
        SaleProductInfoDetailsResponseModel model=new SaleProductInfoDetailsResponseModel();
        model.setProduct(saleproductInfo.getProductInfo().getProduct());
        model.setSale(saleproductInfo.getSale());
        return model;
    }
}
