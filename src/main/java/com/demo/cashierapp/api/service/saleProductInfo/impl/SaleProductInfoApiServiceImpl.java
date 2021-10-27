package com.demo.cashierapp.api.service.saleProductInfo.impl;

import com.demo.cashierapp.api.service.saleProductInfo.SaleProductInfoApiService;
import com.demo.cashierapp.entity.ProductInfo;
import com.demo.cashierapp.entity.SaleProductInfo;
import com.demo.cashierapp.mapper.saleProductInfo.MapperSaleProductInfo;
import com.demo.cashierapp.model.apiService.saleProductInfo.CreateSaleProductInfoRequestModel;
import com.demo.cashierapp.model.apiService.saleProductInfo.SaleProductInfoDetailsResponseModel;
import com.demo.cashierapp.model.service.productInfo.CreateProductInfoParams;
import com.demo.cashierapp.model.service.saleProductInfo.CreateSaleProductInfoParams;
import com.demo.cashierapp.service.saleProductInfo.SaleProductInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class SaleProductInfoApiServiceImpl  implements SaleProductInfoApiService {
    private MapperSaleProductInfo mapperSaleProductInfo;
    private SaleProductInfoService saleProductInfoService;
    private SaleProductInfoDetailsResponseModel saleProductInfoDetailsResponseModel;


    @Override
    public SaleProductInfoDetailsResponseModel create(CreateSaleProductInfoRequestModel createSaleProductInfoRequestModel) {
        final CreateSaleProductInfoParams saleProductInfoParams = mapperSaleProductInfo.mapToCreateSaleProductInfoParams(createSaleProductInfoRequestModel);
        final SaleProductInfo savedSaleProductInfo = saleProductInfoService.create(saleProductInfoParams);

        return saleProductInfoDetailsResponseModel.build(saleProductInfoParams);
    }


    @Override
    public List<SaleProductInfoDetailsResponseModel> getAll() {
        return null;
    }
}
