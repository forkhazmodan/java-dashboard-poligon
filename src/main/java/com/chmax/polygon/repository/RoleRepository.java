package com.chmax.polygon.repository;

import com.chmax.polygon.enums.RoleEnum;
import com.chmax.polygon.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    public Role findByName(RoleEnum name);
}
