package com.demo.cashierapp.api.service.sale.impl;

import com.demo.cashierapp.api.service.response.builder.SaleDetailsResponseModelBuilder;
import com.demo.cashierapp.api.service.sale.SaleApiService;
import com.demo.cashierapp.entity.Sale;
import com.demo.cashierapp.entity.SaleSummary;
import com.demo.cashierapp.entity.SoldProducts;
import com.demo.cashierapp.mapper.sale.MapperSale;
import com.demo.cashierapp.mapper.soldProducts.MapperSoldProducts;
import com.demo.cashierapp.model.apiService.sale.CreateSaleRequestModel;
import com.demo.cashierapp.model.apiService.sale.SaleDetailsResponseModel;
import com.demo.cashierapp.model.service.soldProducts.CreateSoldProductsParams;
import com.demo.cashierapp.service.saleSummary.SaleSummaryService;
import com.demo.cashierapp.service.sale.SaleService;
import com.demo.cashierapp.service.soldProducts.SoldProductsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class SaleApiServiceImpl implements SaleApiService {
    private final SaleService saleService;
    private final SaleSummaryService saleSummaryService;
    private final SoldProductsService soldProductsService;
    private final MapperSale mapperSale;
    private final MapperSoldProducts mapperSoldProducts;
    private final SaleDetailsResponseModelBuilder saleDetailsResponseModelBuilder;

    @Override
    public SaleDetailsResponseModel create(CreateSaleRequestModel createSaleRequestModel) {
        final Sale savedSale = saleService.create(mapperSale.mapToCreateSaleParams(createSaleRequestModel));
        final List<CreateSoldProductsParams> soldProductsParams = createSaleRequestModel.getSoldProducts()
                .stream()
                .map(mapperSoldProducts::mapToCreateSoldProductsParams)
                .collect(Collectors.toList());
        List<SaleSummary> saleSummaryList = new LinkedList<>();
        for(CreateSoldProductsParams params : soldProductsParams) {
            final SoldProducts savedSoledProduct = soldProductsService.create(params);
            saleSummaryList.add(saleSummaryService.assign(savedSale, savedSoledProduct));
        }
        savedSale.setSaleSummaryList(saleSummaryList);
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