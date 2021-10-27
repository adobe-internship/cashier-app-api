package com.demo.cashierapp.service.saleProductInfo.impl;

import com.demo.cashierapp.entity.*;
import com.demo.cashierapp.model.service.employee.CreateEmployeeParams;
import com.demo.cashierapp.model.service.saleProductInfo.CreateSaleProductInfoParams;
import com.demo.cashierapp.repository.ProductInfoRepository;
import com.demo.cashierapp.repository.SaleProductInfoRepository;
import com.demo.cashierapp.service.product.ProductService;
import com.demo.cashierapp.service.sale.SaleService;
import com.demo.cashierapp.service.saleProductInfo.SaleProductInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.parameters.P;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SaleProductInfoServiceImpl implements SaleProductInfoService {


    private final SaleProductInfoRepository saleProductInfoRepository;
    private final ProductService productService;
    private final SaleService saleService;

    @Override
    public SaleProductInfo create(CreateSaleProductInfoParams createSaleProductInfoParams) {

        final SaleProductInfo saleProductInfo= new SaleProductInfo();

        saleProductInfo.setSale(createSaleProductInfoParams.getSale());
        saleProductInfo.setProductInfo(createSaleProductInfoParams.getProductInfo());

        return saleProductInfo;
    }


    @Override
    public List<SaleProductInfo> getAll() {

        return saleProductInfoRepository.findAll();
    }

    @Override
    public SaleProductInfo getSaleById(Long id) {

        Sale saleById = saleService.getS

    }

}
