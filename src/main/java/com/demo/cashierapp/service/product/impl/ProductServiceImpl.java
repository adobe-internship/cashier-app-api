package com.demo.cashierapp.service.product.impl;

import com.demo.cashierapp.entity.Employee;
import com.demo.cashierapp.entity.Product;
import com.demo.cashierapp.model.service.product.CreateProductParams;
import com.demo.cashierapp.repository.ProductRepository;
import com.demo.cashierapp.service.product.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public Product create(CreateProductParams createProductParams) {
        Product product = new Product();
        product.setSupplier(createProductParams.getSupplier());
        product.setBrand(createProductParams.getBrand());
        product.setBarcode(createProductParams.getBarcode());
        product.setProductName(createProductParams.getProductName());
        product.setProductDescription(createProductParams.getProductDescription());
        product.setQuantity(createProductParams.getQuantity());
        product.setUnitOfMeasurement(createProductParams.getUnitOfMeasurement());
        product.setCostPrice(createProductParams.getCostPrice());
        product.setSalePrice(createProductParams.getSalePrice());
        return productRepository.save(product);
    }

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductByBarcode(String barcode) {
        final Optional<Product> entity = productRepository.findProductByBarcode(barcode);
        if (entity.isEmpty()) {
            throw new IllegalArgumentException("Product does not exist");
        }
        return entity.get();
    }
}
