package com.cloudofgoods.authservice.entity;

import com.cloudofgoods.authservice.entity.embeddable.AuthUserAuthRoleId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;

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
    //@JoinColumn( referencedColumnName = "id", insertable = false, updatable = false)
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private AuthUser authUser;
    @ManyToOne
    @MapsId("roleId")
   // @JoinColumn( referencedColumnName = "id", insertable = false, updatable = false)
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private AuthRole authRole;
    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    public AuthUserAuthRole(AuthUserAuthRoleId id, Date createdAt, Date updatedAt) {
        this.id = id;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
    public AuthUserAuthRole(Long userId,Long roleId, Date createdAt, Date updatedAt) {
        this.id = new AuthUserAuthRoleId(userId,roleId);
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
