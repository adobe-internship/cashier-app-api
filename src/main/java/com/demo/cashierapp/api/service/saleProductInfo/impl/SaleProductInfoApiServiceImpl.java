package com.demo.cashierapp.api.service.saleProductInfo.impl;

import com.demo.cashierapp.api.service.response.builder.SaleProductInfoResponseModelBuilder;
import com.demo.cashierapp.api.service.saleProductInfo.SaleProductInfoApiService;
import com.demo.cashierapp.entity.SaleProductInfo;
import com.demo.cashierapp.mapper.saleProductInfo.MapperSaleProductInfo;
import com.demo.cashierapp.model.apiService.saleProductInfo.CreateSaleProductInfoRequestModel;
import com.demo.cashierapp.model.apiService.saleProductInfo.SaleProductInfoDetailsResponseModel;

import com.demo.cashierapp.service.saleProductInfo.SaleProductInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class SaleProductInfoApiServiceImpl  implements SaleProductInfoApiService {
    private MapperSaleProductInfo mapperSaleProductInfo;
    private SaleProductInfoService saleProductInfoService;
    private SaleProductInfoResponseModelBuilder saleProductInfoResponseModelBuilder;
    private SaleProductInfoService productInfoService;


    @Override
    public SaleProductInfoDetailsResponseModel create(CreateSaleProductInfoRequestModel createSaleProductInfoRequestModel) {

        final SaleProductInfo savedSaleProductInfo = saleProductInfoService.create(mapperSaleProductInfo.mapToCreateSaleProductInfoParams(createSaleProductInfoRequestModel));
        return saleProductInfoResponseModelBuilder.build(savedSaleProductInfo.getId());
    }

    @Override
    public List<SaleProductInfoDetailsResponseModel> getAll() {
        List<SaleProductInfo> productInfos = productInfoService.getAll();
        return productInfos.
                stream()
                .map(productInfo -> saleProductInfoResponseModelBuilder.build(productInfo.getId()))
                .collect(Collectors.toList());
    }

}