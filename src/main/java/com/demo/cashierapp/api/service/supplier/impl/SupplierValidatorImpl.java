package com.demo.cashierapp.api.service.supplier.impl;

import com.demo.cashierapp.api.service.supplier.SupplierValidator;
import com.demo.cashierapp.exception.ErrorSubtype;
import com.demo.cashierapp.model.apiService.supplier.CreateSupplierRequestModel;
import com.demo.cashierapp.service.supplier.SupplierService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;


@Component
@RequiredArgsConstructor
public class SupplierValidatorImpl implements SupplierValidator {

    private final SupplierService supplierService;

    @Override
    public List<ErrorSubtype> validate(CreateSupplierRequestModel requestModel) {
        final List<ErrorSubtype> errors = new LinkedList<>();
        if (StringUtils.isEmpty(requestModel.getName())) {
            errors.add(ErrorSubtype.MISSING_NAME);
        } else if (supplierService.nameExists(requestModel.getName())) {
            errors.add(ErrorSubtype.NAME_EXISTS);
        }
        if (StringUtils.isEmpty(requestModel.getContactName())) {
            errors.add(ErrorSubtype.MISSING_CONTACT_NAME);
        }
        if (StringUtils.isEmpty(requestModel.getAddress())) {
            errors.add(ErrorSubtype.MISSING_ADDRESS);
        }
        if (StringUtils.isEmpty(requestModel.getPhone())) {
            errors.add(ErrorSubtype.MISSING_PHONE);
        }

        return errors;
    }

    @Override
    public List<ErrorSubtype> validate(String name) {
        final List<ErrorSubtype> errors = new LinkedList<>();

        if (StringUtils.isEmpty(name)) {
            errors.add(ErrorSubtype.MISSING_NAME);
        } else if (!supplierService.nameExists(name)) {
            errors.add(ErrorSubtype.NAME_DOES_NOT_EXIST);
        }
        return errors;
    }
}
