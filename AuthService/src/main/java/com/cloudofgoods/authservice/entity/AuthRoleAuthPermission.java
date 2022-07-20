package com.cloudofgoods.authservice.entity;

import com.cloudofgoods.authservice.entity.embeddable.AuthRoleAuthPermissionPK;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
    //@ManyToOne( optional = false)
   // @MapsId("authRole")
    @JsonIgnore
    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE})
    @JoinColumn(name="auth_role_id",referencedColumnName = "id", insertable = false, updatable = false)
    private AuthRole authRole;
    //@ManyToOne( optional = false)
    //@MapsId("authPermission")
    @JsonIgnore
    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE})
    @JoinColumn(name="auth_permission_id",referencedColumnName = "id", insertable = false, updatable = false)
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
