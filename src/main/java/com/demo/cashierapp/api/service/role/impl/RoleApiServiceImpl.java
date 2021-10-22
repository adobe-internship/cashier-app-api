package com.demo.cashierapp.api.service.role.impl;

import com.demo.cashierapp.api.service.role.RoleApiService;
import com.demo.cashierapp.entity.Role;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class RoleApiServiceImpl implements RoleApiService {

    @Override
    public List<Role> getAll() {
        return Arrays.asList(Role.values());
    }
}
