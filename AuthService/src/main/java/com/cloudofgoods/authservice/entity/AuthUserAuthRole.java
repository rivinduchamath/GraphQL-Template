package com.cloudofgoods.authservice.entity;

import com.cloudofgoods.authservice.entity.embeddable.AuthUserAuthRolePK;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;

import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AuthUserAuthRole {
    @EmbeddedId
    private AuthUserAuthRolePK authRolePK;
    @ManyToOne
    @MapsId("userId")
    //@JoinColumn( referencedColumnName = "id", insertable = false, updatable = false)
    private AuthUser authUser;
    @ManyToOne
    @MapsId("roleId")
   // @JoinColumn( referencedColumnName = "id", insertable = false, updatable = false)

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

    public AuthUserAuthRole(AuthUserAuthRolePK authRolePK, Date createdAt, Date updatedAt) {
        this.authRolePK = authRolePK;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
    public AuthUserAuthRole(AuthUser authUser, AuthRole authRole, Date createdAt, Date updatedAt) {
        this.authUser = authUser;
        this.authRole = authRole;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
