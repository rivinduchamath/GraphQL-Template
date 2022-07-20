package com.cloudofgoods.authservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AuthUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false, unique = true)
    private String email;
    private String password;

    @JsonIgnore  // Marker annotation that indicates that the annotated method or field is to be ignored by
                 // introspection-based serialization and deserialization functionality.
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "authUser" )
    Collection<AuthUserAuthRole> authUserAuthRoles = new ArrayList<>();


    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    public AuthUser(Long id, String email, String password, Date createdAt, Date updatedAt) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
