package com.cloudofgoods.authservice.controller;

import com.cloudofgoods.authservice.dto.RoleToUserForm;
import com.cloudofgoods.authservice.entity.AuthPermission;
import com.cloudofgoods.authservice.entity.AuthRole;
import com.cloudofgoods.authservice.entity.AuthUser;
import com.cloudofgoods.authservice.entity.customentity.LoadAllDataWithRoles;
import com.cloudofgoods.authservice.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v5")
@Slf4j
public class AuthController {

    private final UserService userService;

    @GetMapping("/usersAll")
    // ResponseEntity represents an HTTP response, including headers, body, and status
    // ResponseEntity from spring-web dependency
    // Method include Get User Object
    public ResponseEntity<List<LoadAllDataWithRoles>> getUserWithRoles() {
        return ResponseEntity.ok().body(userService.getUserWithRoles());
    }


    @GetMapping("/users")
    // ResponseEntity represents an HTTP response, including headers, body, and status
    // ResponseEntity from spring-web dependency
    // Method include Get User Object
    public ResponseEntity<List<AuthUser>> getUser() {
        return ResponseEntity.ok().body(userService.getAuthUsers());
    }


    @GetMapping("/watch/roles")
    // ResponseEntity represents an HTTP response, including headers, body, and status
    // ResponseEntity from spring-web dependency
    // Method include Get Role Object
    public ResponseEntity<List<AuthRole>> getRoles() {
        return ResponseEntity.ok().body(userService.getAuthRoles());
    }


    @GetMapping("/permission")
    // ResponseEntity represents an HTTP response, including headers, body, and status
    // ResponseEntity from spring-web dependency
    // Method include Get Role Object
    public ResponseEntity<List<AuthPermission>> getAuthPermission() {
        return ResponseEntity.ok().body(userService.getAuthPermission());
    }


    @PostMapping("/user/save")
    public ResponseEntity<AuthUser> saveUser(@RequestBody AuthUser user) {
        // uniform resource identifier to address resources. When resources are named well, an API is intuitive and easy to use. c
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/user/save").toUriString());
        return ResponseEntity.created(uri).body(userService.saveAuthUser(user));
    }

    @PostMapping("/role/save")
    public ResponseEntity<AuthRole> saveRole(@RequestBody AuthRole role) {
        // uniform resource identifier to address resources. When resources are named well, an API is intuitive and easy to use. c
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/role/save").toUriString());
        return ResponseEntity.created(uri).body(userService.saveAuthRole(role));
    }

    @PostMapping("/role/addtouser")
    public ResponseEntity<?> addRoleToUser(@RequestBody RoleToUserForm roleToUserForm) {
        userService.addRoleToUser(roleToUserForm.getUserName(), roleToUserForm.getRoleName());
        // Separately add above because It's return type ?
        return ResponseEntity.ok().build();
    }


}
