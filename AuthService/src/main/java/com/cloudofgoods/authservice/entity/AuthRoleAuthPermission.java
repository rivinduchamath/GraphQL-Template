package com.cloudofgoods.authservice.entity;

import com.cloudofgoods.authservice.entity.embeddable.AuthRoleAuthPermissionPK;
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
public class AuthRoleAuthPermission {
    @EmbeddedId
    private AuthRoleAuthPermissionPK authPermissionPK;
    @ManyToOne( optional = false)
    @MapsId("authRole")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private AuthRole authRole;
    @ManyToOne( optional = false)
    @MapsId("authPermission")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private AuthPermission authPermission;


    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    public AuthRoleAuthPermission(Long authRoleId, Long authPermissionId, Date createdAt, Date updatedAt) {
        this.authPermissionPK = new AuthRoleAuthPermissionPK(authRoleId,authPermissionId);
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
    public AuthRoleAuthPermission(AuthRoleAuthPermissionPK authPermissionPK, Date createdAt, Date updatedAt) {
        this.authPermissionPK = authPermissionPK;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
