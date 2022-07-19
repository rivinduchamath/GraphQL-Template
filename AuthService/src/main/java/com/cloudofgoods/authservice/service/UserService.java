package com.cloudofgoods.authservice.service;

import com.cloudofgoods.authservice.entity.AuthRole;
import com.cloudofgoods.authservice.entity.AuthUser;

import java.util.List;

public interface UserService {
    List<AuthUser> getAuthUsers();

    List<AuthRole>  getAuthRoles();

    AuthUser saveAuthUser(AuthUser user);

    AuthRole saveAuthRole(AuthRole role);

    void addRoleToUser(String email, String roleName);
}
