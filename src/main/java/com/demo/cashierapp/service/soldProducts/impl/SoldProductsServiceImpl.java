package com.demo.cashierapp.service.soldProducts.impl;

import com.demo.cashierapp.entity.SoldProducts;
import com.demo.cashierapp.model.service.soldProducts.CreateSoldProductsParams;
import com.demo.cashierapp.repository.SoldProductsRepository;
import com.demo.cashierapp.service.product.ProductService;
import com.demo.cashierapp.service.soldProducts.SoldProductsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SoldProductsServiceImpl implements SoldProductsService {

    private final SoldProductsRepository soldProductsRepository;
    private final ProductService productService;

    @Override
    public SoldProducts create(CreateSoldProductsParams createSoldProductsParams) {
        final SoldProducts soldProducts = new SoldProducts();
        soldProducts.setProduct(productService.getProductByBarcode(createSoldProductsParams.getBarcode()));
        soldProducts.setQuantity(createSoldProductsParams.getQuantity());
        soldProducts.setSalePrice(createSoldProductsParams.getSalePrice());
        soldProducts.setCostPrice(createSoldProductsParams.getCostPrice());
        return soldProductsRepository.save(soldProducts);
    }


    @Override
    public List<SoldProducts> getAll() {

        return soldProductsRepository.findAll();
    }


}
