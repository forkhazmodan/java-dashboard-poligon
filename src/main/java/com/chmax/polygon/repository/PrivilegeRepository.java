package com.chmax.polygon.repository;

import com.chmax.polygon.enums.PrivilegeType;
import com.chmax.polygon.model.Privilege;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrivilegeRepository extends JpaRepository<Privilege, Long> {
    public Privilege findByName(PrivilegeType name);
}
