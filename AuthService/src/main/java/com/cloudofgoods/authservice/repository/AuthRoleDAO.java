package com.cloudofgoods.authservice.repository;

import com.cloudofgoods.authservice.entity.AuthRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AuthRoleDAO extends JpaRepository<AuthRole,Long> {
    AuthRole findRoleByName(String roleName);

    @Query(value = "from AuthRole")
    List<AuthRole> findAlla();
}
