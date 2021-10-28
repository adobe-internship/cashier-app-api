package com.demo.cashierapp.service.sale;


import com.demo.cashierapp.entity.Sale;
import com.demo.cashierapp.model.service.sale.CreateSaleParams;

import java.util.List;

public interface SaleService {
    Sale create(CreateSaleParams createSaleParams);

    List<Sale> getAll();

    Sale getSaleByUUID(String uuid);


}
