package com.demo.cashierapp.model.apiService.sale;

import com.demo.cashierapp.entity.Employee;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class CreateSaleRequestModel extends BaseSale {
    private Employee employee;

    public CreateSaleRequestModel(double amount, Date saleDate, UUID uuid, Employee employee) {
        super(amount, saleDate, uuid);
        this.employee = employee;
    }
}
