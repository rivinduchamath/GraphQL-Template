package com.cloudofgoods.authservice.entity;

import com.cloudofgoods.authservice.entity.embeddable.AuthUserAuthRoleId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AuthUserAuthRole {
    @EmbeddedId
    private AuthUserAuthRoleId id;
    @ManyToOne
    @MapsId("userId")
    private AuthUser authUser;
    @ManyToOne
    @MapsId("roleId")
    private AuthPermission authPermission;
    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

}
