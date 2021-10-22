package com.demo.cashierapp.repository;

import com.demo.cashierapp.entity.EmployeeRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRoleRepository extends JpaRepository<EmployeeRole, Long> {
    List<EmployeeRole> findAllByEmployee_Username(String username);
}
