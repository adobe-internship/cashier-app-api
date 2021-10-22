package com.demo.cashierapp.service.product;

import com.demo.cashierapp.entity.Product;
import com.demo.cashierapp.model.service.product.CreateProductParams;

import java.util.List;

public interface ProductService {
    Product create(CreateProductParams createProductParams);

    List<Product> getAll();

    Product getProductByBarcode(String barcode);
}
