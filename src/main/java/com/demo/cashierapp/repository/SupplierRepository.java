package com.demo.cashierapp.repository;

import com.demo.cashierapp.entity.Employee;
import com.demo.cashierapp.entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SupplierRepository extends JpaRepository<Supplier, Long> {
    Optional<Supplier> findSupplierByName(String name);

    Supplier deleteUserByName(String name);
}
