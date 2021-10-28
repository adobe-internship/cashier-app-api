package com.demo.cashierapp.repository;


import com.demo.cashierapp.entity.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Long> {
  Optional<Sale> findSaleByUuid(String uuid);
}
