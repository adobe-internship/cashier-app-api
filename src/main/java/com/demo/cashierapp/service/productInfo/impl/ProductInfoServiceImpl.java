package com.demo.cashierapp.service.productInfo.impl;

import com.demo.cashierapp.entity.Product;
import com.demo.cashierapp.entity.ProductInfo;
import com.demo.cashierapp.model.service.productInfo.CreateProductInfoParams;
import com.demo.cashierapp.repository.ProductInfoRepository;
import com.demo.cashierapp.service.product.ProductService;
import com.demo.cashierapp.service.productInfo.ProductInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class ProductInfoServiceImpl implements ProductInfoService {
    private final ProductInfoRepository productInfoRepository;
    private final ProductService productService;


    @Override
    public ProductInfo create(CreateProductInfoParams createProductInfoParams) {
        final ProductInfo productInfo = new ProductInfo();
        final Product product = productService.getProductByBarcode(createProductInfoParams.getProduct().getBarcode());
        productInfo.setProduct(product);
        productInfo.setQuantity(createProductInfoParams.getQuantity());
        return productInfo;
    }


    @Override
    public List<ProductInfo> getAll() {
        return productInfoRepository.findAll();
    }

    @Override
    public ProductInfo getProductInfoByProductBarcode(String barcode) {
        Product productByBarcode = productService.getProductByBarcode(barcode);
        final Optional<ProductInfo> entity = productInfoRepository.findById(productByBarcode.getId());

        return entity.get();
    }


}
