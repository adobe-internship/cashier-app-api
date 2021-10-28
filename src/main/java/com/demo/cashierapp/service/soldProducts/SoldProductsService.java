package com.demo.cashierapp.service.soldProducts;

import com.demo.cashierapp.entity.SoldProducts;
import com.demo.cashierapp.model.service.soldProducts.CreateSoldProductsParams;

import java.util.List;

public interface SoldProductsService {
    SoldProducts create(CreateSoldProductsParams createSoldProductsParams);

    List<SoldProducts> getAll();

}
