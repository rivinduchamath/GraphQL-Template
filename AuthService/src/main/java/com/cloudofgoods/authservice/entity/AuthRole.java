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
public class AuthRole {
    @Id
    private Long id;
    private String name;
    @OneToMany(mappedBy = "authRole")
    private Set<AuthRoleAuthPermission> authRoleAuthPermissions;

    @OneToMany(mappedBy = "authPermission", cascade = CascadeType.PERSIST)
    private Set<AuthUserAuthRole> authUserAuthRoles = new HashSet<>();

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

}
