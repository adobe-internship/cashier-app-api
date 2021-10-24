package com.demo.cashierapp.service.product.impl;

import com.demo.cashierapp.entity.Product;
import com.demo.cashierapp.entity.Supplier;
import com.demo.cashierapp.model.service.product.CreateProductParams;
import com.demo.cashierapp.repository.ProductRepository;
import com.demo.cashierapp.service.product.ProductService;
import com.demo.cashierapp.service.supplier.SupplierService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final SupplierService supplierService;

    @Override
    public Product create(CreateProductParams createProductParams) {
        final Product product = new Product();
        if (productExists(createProductParams.getBarcode())) {
            final Product existingProduct = getProductByBarcode(createProductParams.getBarcode());
            product.setId(existingProduct.getId());
            product.setQuantity(createProductParams.getQuantity() + existingProduct.getQuantity());
        } else {
            product.setQuantity(createProductParams.getQuantity());
        }
        final Supplier supplier = supplierService.getSupplierByName(createProductParams.getSupplier());
        product.setSupplier(supplier);
        product.setBrand(createProductParams.getBrand());
        product.setBarcode(createProductParams.getBarcode());
        product.setProductName(createProductParams.getProductName());
        product.setProductDescription(createProductParams.getProductDescription());
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

    @Override
    public void deleteProductByBarcode(String barcode) {
        final Product product = this.getProductByBarcode(barcode);
        productRepository.deleteById(product.getId());
    }

    @Override
    public boolean productExists(String barcode) {
        return productRepository.findProductByBarcode(barcode).isPresent();
    }
}
