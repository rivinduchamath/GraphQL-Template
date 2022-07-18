package com.cloudofgoods.authservice.repository;

import com.cloudofgoods.authservice.entity.AuthUserAuthPermission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthUserAuthPermissionDAO extends JpaRepository<AuthUserAuthPermission,Long> {
}
