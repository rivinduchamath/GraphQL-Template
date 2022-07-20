package com.cloudofgoods.authservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AuthPermission {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(unique = true)
    private String code;
//    @ManyToOne(fetch = FetchType.LAZY, optional = false)
//    @JoinColumn(nullable = false)
//    private AuthContentType authContentType;

    @OneToMany(mappedBy = "authPermission", cascade = CascadeType.PERSIST)
    private Set<AuthUserAuthPermission> authUsers = new HashSet<>();

    @OneToMany(mappedBy="authPermission")
    private Set<AuthRoleAuthPermission> authRoleAuthPermissions;


    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    public AuthPermission(Long id, String name, String code,
                          //AuthContentType authContentType,
                          Date createdAt, Date updatedAt) {
        this.id = id;
        this.name = name;
        this.code = code;
//        this.authContentType = authContentType;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
