package com.demo.cashierapp.controller;

import com.demo.cashierapp.api.service.role.RoleApiService;
import com.demo.cashierapp.entity.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/api/role")
@RequiredArgsConstructor
public class RoleController {
    private final RoleApiService roleApiService;

    @GetMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public List<Role> getAll() {
        return roleApiService.getAll();
    }
}
