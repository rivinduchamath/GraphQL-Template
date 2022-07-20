package com.cloudofgoods.authservice.repository;

import com.cloudofgoods.authservice.entity.AuthUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuthUserDAO extends JpaRepository<AuthUser,Long> {
    AuthUser findAuthUserByEmail(String userName);

}
