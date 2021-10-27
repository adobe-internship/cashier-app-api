package com.demo.cashierapp.service.product.impl;

import com.demo.cashierapp.entity.Product;
import com.demo.cashierapp.entity.Supplier;
import com.demo.cashierapp.model.apiService.product.BuyProductRequestModel;
import com.demo.cashierapp.model.apiService.product.ReturnProductRequestModel;
import com.demo.cashierapp.model.service.product.CreateProductParams;
import com.demo.cashierapp.model.service.product.UpdateProductParams;
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

    @Override
    public Product update(UpdateProductParams updateProductParams) {
        final Product product = getProductByBarcode(updateProductParams.getBarcode());
        final Supplier supplier = supplierService.getSupplierByName(updateProductParams.getSupplier());
        product.setSupplier(supplier);
        product.setCostPrice(updateProductParams.getCostPrice());
        product.setSalePrice(updateProductParams.getSalePrice());
        return productRepository.save(product);
    }

    @Override
    public Product buyProduct(BuyProductRequestModel model) {
        final Product product = getProductByBarcode(model.getBarcode());
        int sub = product.getQuantity() - model.getQuantity();
        if (sub < 0) {
            throw new IllegalArgumentException("Requested quantity more than in the Store");
        }
        product.setQuantity(sub);
        return productRepository.save(product);
    }

    @Override
    public void returnProduct(ReturnProductRequestModel model) {
        final Product product = getProductByBarcode(model.getBarcode());
        int totalQuantity = product.getQuantity() + model.getQuantity();
        product.setQuantity(totalQuantity);
        productRepository.save(product);
    }

}
