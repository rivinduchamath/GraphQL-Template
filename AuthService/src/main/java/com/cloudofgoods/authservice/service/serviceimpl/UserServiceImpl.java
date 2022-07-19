package com.cloudofgoods.authservice.service.serviceimpl;

import com.cloudofgoods.authservice.entity.*;
import com.cloudofgoods.authservice.repository.*;
import com.cloudofgoods.authservice.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class UserServiceImpl implements UserService, UserDetailsService {
    // UserService to Implement Crud to Loosely Coupling
    // Implement UserDetailsService interface to Load Users From Database
    private final AuthUserDAO authUserDAO;
    private final AuthRoleDAO authRoleDAO;

    private final PasswordEncoder passwordEncoder;
    private final AuthPermissionDAO authPermissionDAO;
    private final AuthUserAuthRoleDAO authUserAuthRoleDAO;

    private final AuthContentTypeDAO authContentTypeDAO;
    @Override
    public List<AuthUser> getAuthUsers() {
        log.info("Get All Users");
        return authUserDAO.findAll();
    }

    @Override
    public List<AuthRole> getAuthRoles() {
        log.info("Get All Roles");
        return authRoleDAO.findAll();
    }

    @Override
    public AuthUser saveAuthUser(AuthUser user) {
        log.info("Inside the Save User " + user.getEmail());
        //  user.setPassword(passwordEncoder.encode(user.getPassword()));
        return authUserDAO.save(user);
    }

    @Override
    public AuthRole saveAuthRole(AuthRole role) {
        log.info("Inside the Save Role " + role.getName());
        return authRoleDAO.save(role);
    }

    @Override
    public void addRoleToUser(String userName, String roleName) {
        AuthUser user = authUserDAO.findAuthUserByEmail(userName);
        AuthRole role = authRoleDAO.findRoleByName(roleName);
        log.info("Add Role " + roleName + " to the User " + userName);
        AuthUserAuthRole authUserAuthRole = new AuthUserAuthRole(user.getId(), role.getId(), new Date(), new Date());
        authUserAuthRole.setAuthUser(user);
        authUserAuthRole.setAuthRole(role);
        authUserAuthRoleDAO.save(authUserAuthRole);
    }

    @Override
    public AuthPermission saveAuthPermission(AuthPermission xyz) {
        log.info("Inside the Save Role " + xyz.getName());
        return authPermissionDAO.save(xyz);
    }

    @Override
    public AuthContentType saveAuthContentType(AuthContentType authContentType) {
        log.info("Inside the Save Role " + authContentType.getModelName());
        return authContentTypeDAO.save(authContentType);
    }



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
}
