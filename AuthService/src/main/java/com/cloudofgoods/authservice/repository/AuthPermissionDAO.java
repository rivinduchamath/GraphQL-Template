package com.cloudofgoods.authservice.repository;

import com.cloudofgoods.authservice.entity.AuthPermission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthPermissionDAO extends JpaRepository<AuthPermission,Long>

    {
        AuthPermission findAuthPermissionByCode(String authPermissionCode);
    }
