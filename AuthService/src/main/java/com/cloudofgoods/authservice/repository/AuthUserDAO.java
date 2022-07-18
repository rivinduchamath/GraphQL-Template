package com.cloudofgoods.authservice.repository;

import com.cloudofgoods.authservice.entity.AuthUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthUserDAO extends JpaRepository<AuthUser,Long> {
}
