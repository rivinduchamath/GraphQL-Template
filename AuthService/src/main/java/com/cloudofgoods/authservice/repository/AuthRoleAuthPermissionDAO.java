package com.cloudofgoods.authservice.repository;

import com.cloudofgoods.authservice.entity.AuthRoleAuthPermission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthRoleAuthPermissionDAO extends JpaRepository<AuthRoleAuthPermission,Long> {
}
