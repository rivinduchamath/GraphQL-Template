package com.cloudofgoods.authservice.entity;

import com.cloudofgoods.authservice.entity.embeddable.AuthUserAuthRolePK;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AuthUserAuthRole {
    @EmbeddedId
    private AuthUserAuthRolePK authRolePK;
    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER )
 //   @MapsId("userId")
 @JoinColumn(name = "auth_user_id",insertable = false, updatable = false)
    private AuthUser authUser;
    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER )
  //@MapsId("roleId")
   @JoinColumn(name = "auth_role_id",insertable = false, updatable = false)
    private AuthRole authRole;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    public AuthUserAuthRole(Long userId,Long roleId, Date createdAt, Date updatedAt) {
        this.authRolePK = new AuthUserAuthRolePK(userId,roleId);
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public AuthRole getAuthRole() {
        return authRole;
    }

    public void setAuthRole(AuthRole authRole) {
        this.authRole = authRole;
    }

    public AuthUserAuthRole(AuthUserAuthRolePK authRolePK, Date createdAt, Date updatedAt) {
        this.authRolePK = authRolePK;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
    public AuthUserAuthRole(AuthUser authUser, AuthRole authRole, Date createdAt, Date updatedAt) {
        this.authUser = authUser;
        this.authRole = authRole;
        this.authRolePK = new AuthUserAuthRolePK(authRole.getId(), authUser.getId());
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
