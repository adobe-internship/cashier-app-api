package com.demo.cashierapp.model.apiService.sale;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BaseSale {
    private double amount;
    private Date saleDate;
    private UUID uuid;
}
