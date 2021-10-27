package com.demo.cashierapp.repository;

import com.demo.cashierapp.entity.Product;
import com.demo.cashierapp.entity.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface SaleRepository extends JpaRepository<Sale, Long> {
    Optional<Product> findSaleByUUID(UUID uuid);
}
