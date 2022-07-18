package com.cloudofgoods.authservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AuthUser {
    @Id
    private Long id;
    @Column(nullable = false, unique = true)
    private String email;
    private String password;

    @OneToMany(mappedBy = "authUser", cascade = CascadeType.PERSIST)
    Set<AuthUserAuthPermission> authPermissionSet = new HashSet<>();

    @OneToMany(mappedBy = "authUser", cascade = CascadeType.PERSIST)
    Set<AuthUserAuthRole> authUserAuthRoles = new HashSet<>();

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

}
