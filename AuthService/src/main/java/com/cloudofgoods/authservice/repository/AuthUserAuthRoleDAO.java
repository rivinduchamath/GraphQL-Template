package com.cloudofgoods.authservice.repository;

import com.cloudofgoods.authservice.entity.AuthUserAuthRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthUserAuthRoleDAO extends JpaRepository<AuthUserAuthRole,Long> {
}
