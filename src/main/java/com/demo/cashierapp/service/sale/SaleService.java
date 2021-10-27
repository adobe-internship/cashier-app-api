package com.demo.cashierapp.service.sale;


import com.demo.cashierapp.entity.Sale;
import com.demo.cashierapp.model.service.sale.CreateSaleParams;

import java.util.List;
import java.util.UUID;

public interface SaleService {
    Sale create(CreateSaleParams createSaleParams);

    List<Sale> getAll();

    Sale getSaleByUUID(UUID uuid);


}
