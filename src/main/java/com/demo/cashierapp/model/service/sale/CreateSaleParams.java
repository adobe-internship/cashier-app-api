package com.demo.cashierapp.model.service.sale;

import lombok.Getter;

import java.util.Date;
import java.util.UUID;

@Getter
public class CreateSaleParams {
    private final double amount;
    private final Date saleTime;
    private final UUID uuid;

    public CreateSaleParams(double amount, Date date, UUID uuid) {
        this.amount = amount;
        this.saleTime = date;
        this.uuid = uuid;
    }
}
