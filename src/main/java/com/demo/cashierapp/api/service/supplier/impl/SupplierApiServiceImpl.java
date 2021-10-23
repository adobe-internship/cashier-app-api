package com.demo.cashierapp.api.service.supplier.impl;

import com.demo.cashierapp.api.service.response.builder.SupplierDetailsResponseModelBuilder;
import com.demo.cashierapp.api.service.supplier.SupplierApiService;
import com.demo.cashierapp.entity.Supplier;
import com.demo.cashierapp.mapper.supplier.MapperSupplier;
import com.demo.cashierapp.model.apiService.supplier.CreateSupplierRequestModel;
import com.demo.cashierapp.model.apiService.supplier.SupplierDetailsResponseModel;
import com.demo.cashierapp.model.apiService.supplier.UpdateSupplierRequestModel;
import com.demo.cashierapp.service.supplier.SupplierService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class SupplierApiServiceImpl implements SupplierApiService {

    private final SupplierService supplierService;
    private final MapperSupplier mapperSupplier;
    private final SupplierDetailsResponseModelBuilder supplierDetailsBuilder;

    @Override
    public SupplierDetailsResponseModel create(CreateSupplierRequestModel createSupplierRequestModel) {
        final Supplier savedSupplier = supplierService.create(
                mapperSupplier.mapToCreateSupplierParams(createSupplierRequestModel));

        return supplierDetailsBuilder.build(savedSupplier.getName());
    }

    @Override
    public List<SupplierDetailsResponseModel> getAll() {
        final List<Supplier> suppliers = supplierService.getAll();
        return suppliers.stream()
                .map(supplier -> supplierDetailsBuilder.build(supplier.getName()))
                .collect(Collectors.toList());
    }

    @Override
    public SupplierDetailsResponseModel getByName(String name) {
        return null;
    }

    @Override
    public void deleteByName(String name) {
        supplierService.deleteByName(name);
    }

    @Override
    public SupplierDetailsResponseModel update(UpdateSupplierRequestModel updateSupplierRequestModel) {
        return null;
    }
}
