package com.demo.cashierapp.api.service.supplier.impl;

import com.demo.cashierapp.api.service.response.builder.SupplierDetailsResponseModelBuilder;
import com.demo.cashierapp.api.service.supplier.SupplierApiService;
import com.demo.cashierapp.api.service.supplier.SupplierValidator;
import com.demo.cashierapp.entity.Supplier;
import com.demo.cashierapp.exception.ErrorSubtype;
import com.demo.cashierapp.exception.types.EmployeeValidationException;
import com.demo.cashierapp.exception.types.SupplierValidationException;
import com.demo.cashierapp.mapper.supplier.MapperSupplier;
import com.demo.cashierapp.model.apiService.supplier.CreateSupplierRequestModel;
import com.demo.cashierapp.model.apiService.supplier.SupplierDetailsResponseModel;
import com.demo.cashierapp.model.apiService.supplier.SupplierUpdateRequestModel;
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
    private final SupplierValidator supplierValidator;
//    private final AuthenticationService authenticationService;

    @Override
    public SupplierDetailsResponseModel create(CreateSupplierRequestModel createSupplierRequestModel) {
        List<ErrorSubtype> errorSubtypes = supplierValidator.validate(createSupplierRequestModel);
        if (!errorSubtypes.isEmpty()) {
            throw new SupplierValidationException("Supplier does not validated. For more information see Errors", errorSubtypes);
        }
        final Supplier savedSupplier= supplierService.create(
                mapperSupplier.mapToCreateSupplierParams(createSupplierRequestModel)
        );
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
        checkSupplierByName(name);
        return supplierDetailsBuilder.build(name);

    }
    @Override
    public void deleteByName(String name) {
        checkSupplierByName(name);
        supplierService.deleteByName(name);
    }


    @Override
    public SupplierDetailsResponseModel update(SupplierUpdateRequestModel supplierUpdateRequestModel) {
        return null;
    }

//    @Override
//    public SupplierDetailsResponseModel update(SupplierUpdateRequestModel supplierUpdateRequestModel) {
//
//        Supplier supplier =supplierService.update(
//                new SupplierUpdateParams(
//                        authenticationService.getAuthenticatedName(),
//                        supplierUpdateRequestModel.getConcatName(),
//                        supplierUpdateRequestModel.getAddress(),
//                        supplierUpdateRequestModel.getPhone())
//        );
//        return supplierDetailsBuilder.build(supplier.getName());
//    }


    private void checkSupplierByName(String name) {
        List<ErrorSubtype> errorSubtypes = supplierValidator.validate(name);
        if (!errorSubtypes.isEmpty()) {
            throw new EmployeeValidationException("Supplier does not validated. For more information see Errors", errorSubtypes);
        }
    }
}
