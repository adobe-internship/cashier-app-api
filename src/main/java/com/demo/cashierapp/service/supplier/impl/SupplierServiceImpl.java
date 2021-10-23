package com.demo.cashierapp.service.supplier.impl;

import com.demo.cashierapp.entity.Supplier;
import com.demo.cashierapp.model.service.supplier.CreateSupplierParams;
import com.demo.cashierapp.repository.SupplierRepository;
import com.demo.cashierapp.service.supplier.SupplierService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SupplierServiceImpl implements SupplierService {

    private final SupplierRepository supplierRepository;
    @Override
    public Supplier create(CreateSupplierParams createSupplierParams) {

        Supplier newSupplier = new Supplier();
        newSupplier.setName(createSupplierParams.getName());
        newSupplier.setContactName(createSupplierParams.getContact_name());
        newSupplier.setAddress(createSupplierParams.getAddress());
        newSupplier.setPhone(createSupplierParams.getPhone());
        return supplierRepository.save(newSupplier);
    }

    @Override
    public List<Supplier> getAll() {
        return supplierRepository.findAll();
    }

    @Override
    public Supplier getSupplierByName(String name) {
        final Optional<Supplier> entity = supplierRepository.findSupplierByName(name);
        if (entity.isEmpty()) {
            throw new IllegalArgumentException("Supplier does not exist");
        }
        return entity.get();
    }

    @Override
    public boolean nameExists(String name) {
        Optional<Supplier> supplierOptional = supplierRepository.findSupplierByName(name);
        return supplierOptional.isPresent();
    }

    @Override
    public void deleteByName(String name) {
        supplierRepository.deleteUserByName(name);
    }
}
