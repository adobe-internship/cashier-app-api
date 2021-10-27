package com.demo.cashierapp.service.sale.impl;

import com.demo.cashierapp.entity.Sale;
import com.demo.cashierapp.model.service.sale.CreateSaleParams;
import com.demo.cashierapp.repository.SaleRepository;
import com.demo.cashierapp.service.sale.SaleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SaleServiceImpl implements SaleService {
    private final SaleRepository saleRepository;
    @Override
    public Sale create(CreateSaleParams createSaleParams) {
        Sale newSale = new Sale();
        newSale.setAmount(createSaleParams.getAmount());
        newSale.setSaleTime(createSaleParams.getSaleTime());
        newSale.setUuid(createSaleParams.getUuid());
        return saleRepository.save(newSale);
    }

    @Override
    public List<Sale> getAll() {
        return saleRepository.findAll();
    }

}
