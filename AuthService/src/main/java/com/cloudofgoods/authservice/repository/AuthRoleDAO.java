package com.cloudofgoods.authservice.repository;

import com.cloudofgoods.authservice.entity.AuthRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthRoleDAO extends JpaRepository<AuthRole,Long> {
    AuthRole findRoleByName(String roleName);
}
