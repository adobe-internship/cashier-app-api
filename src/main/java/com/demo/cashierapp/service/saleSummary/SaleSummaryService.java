package com.demo.cashierapp.service.saleSummary;

import com.demo.cashierapp.entity.Sale;
import com.demo.cashierapp.entity.SaleSummary;
import com.demo.cashierapp.entity.SoldProducts;

import java.util.List;

public interface SaleSummaryService {

    SaleSummary assign(Sale sale, SoldProducts soldProducts);

    List<SaleSummary> getAll();

    SaleSummary getProductInfoByProductBarcode(String barcode);

}
