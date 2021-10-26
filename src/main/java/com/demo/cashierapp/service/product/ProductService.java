package com.demo.cashierapp.service.product;

import com.demo.cashierapp.entity.Product;
import com.demo.cashierapp.model.apiService.product.BuyProductRequestModel;
import com.demo.cashierapp.model.apiService.product.ReturnProductRequestModel;
import com.demo.cashierapp.model.service.product.CreateProductParams;
import com.demo.cashierapp.model.service.product.UpdateProductParams;

import java.util.List;

public interface ProductService {
    Product create(CreateProductParams createProductParams);

    List<Product> getAll();

    Product getProductByBarcode(String barcode);

    void deleteProductByBarcode(String barcode);

    boolean productExists(String barcode);

    Product update(UpdateProductParams updateProductParams);

    Product buyProduct(BuyProductRequestModel model);
    void returnProduct(ReturnProductRequestModel model);
}
