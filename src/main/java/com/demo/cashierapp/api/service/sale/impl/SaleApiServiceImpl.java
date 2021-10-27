package com.demo.cashierapp.api.service.sale.impl;

import com.demo.cashierapp.api.service.response.builder.SaleDetailsResponseModelBuilder;
import com.demo.cashierapp.api.service.sale.SaleApiService;
import com.demo.cashierapp.entity.Sale;
import com.demo.cashierapp.mapper.sale.MapperSale;
import com.demo.cashierapp.model.apiService.sale.CreateSaleRequestModel;
import com.demo.cashierapp.model.apiService.sale.SaleDetailsResponseModel;
import com.demo.cashierapp.model.service.sale.CreateSaleParams;
import com.demo.cashierapp.service.productInfo.ProductInfoService;
import com.demo.cashierapp.service.sale.SaleService;
import com.demo.cashierapp.service.saleProductInfo.SaleProductInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class SaleApiServiceImpl implements SaleApiService {
    private final SaleService saleService;
    private final ProductInfoService productInfoService;
    private final SaleProductInfoService saleProductInfoService;
    private final MapperSale mapperSale;
    private final SaleDetailsResponseModelBuilder saleDetailsResponseModelBuilder;

    @Override
    public SaleDetailsResponseModel create(CreateSaleRequestModel createSaleRequestModel) {
        CreateSaleParams createSaleParams = mapperSale.mapToCreateSaleParams(createSaleRequestModel);
        final Sale savedSale = saleService.create(createSaleParams);
        return saleDetailsResponseModelBuilder.build(savedSale.getUuid());
    }

    @Override
    public List<SaleDetailsResponseModel> getAll() {

        final List<Sale> sales = saleService.getAll();
        return sales.stream()
                .map(sale -> saleDetailsResponseModelBuilder.build(sale.getUuid()))
                .collect(Collectors.toList());

    }
}
