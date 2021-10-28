package com.demo.cashierapp.service.saleSummary.impl;

import com.demo.cashierapp.entity.Product;
import com.demo.cashierapp.entity.Sale;
import com.demo.cashierapp.entity.SaleSummary;
import com.demo.cashierapp.entity.SoldProducts;
import com.demo.cashierapp.repository.SaleSummaryRepository;
import com.demo.cashierapp.service.product.ProductService;
import com.demo.cashierapp.service.saleSummary.SaleSummaryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class SaleSummaryServiceImpl implements SaleSummaryService {
    private final SaleSummaryRepository saleSummaryRepository;
    private final ProductService productService;

    @Override
    public SaleSummary assign(Sale sale, SoldProducts soldProducts) {
        SaleSummary saleSummary = new SaleSummary();
        saleSummary.setSale(sale);
        saleSummary.setSoldProduct(soldProducts);
        return saleSummaryRepository.save(saleSummary);
    }

    @Override
    public List<SaleSummary> getAll() {
        return saleSummaryRepository.findAll();
    }

    @Override
    public SaleSummary getProductInfoByProductBarcode(String barcode) {
        Product productByBarcode = productService.getProductByBarcode(barcode);
        final Optional<SaleSummary> entity = saleSummaryRepository.findById(productByBarcode.getId());

        return entity.get();
    }


}
