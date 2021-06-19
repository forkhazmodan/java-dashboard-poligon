package com.chmax.polygon.service.impl;

import com.chmax.polygon.repository.RoleRepository;
import com.chmax.polygon.service.RoleService;

public class RoleServiceImpl implements RoleService {
    RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }
}
