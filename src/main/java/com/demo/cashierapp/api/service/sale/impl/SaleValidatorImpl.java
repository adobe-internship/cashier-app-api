package com.demo.cashierapp.api.service.sale.impl;

import com.demo.cashierapp.api.service.sale.SaleValidator;
import com.demo.cashierapp.exception.ErrorSubtype;
import com.demo.cashierapp.model.apiService.sale.CreateSaleRequestModel;
import com.demo.cashierapp.service.sale.SaleService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;


@Component
@RequiredArgsConstructor
public class SaleValidatorImpl implements SaleValidator {

    private final SaleService saleService;


    @Override
    public List<ErrorSubtype> validate(CreateSaleRequestModel requestModel) {

        final List<ErrorSubtype> errors = new LinkedList<>();
        if (StringUtils.isEmpty(requestModel.getEmployeeUsername())) {
            errors.add(ErrorSubtype.MISSING_EMPLOYEE_NAME);
        }
        if (requestModel.getAmount().compareTo(BigDecimal.ZERO) < 0) {
            errors.add(ErrorSubtype.NEGATIVE_AMOUNT);
        }
        if (requestModel.getSoldProducts().isEmpty()) {
            errors.add(ErrorSubtype.MISSING_SOLD_PRODUCTS);
        }
        return errors;

    }
}
