package com.cloudofgoods.authservice.entity;

import com.cloudofgoods.authservice.entity.embeddable.AuthRoleAuthPermissionPK;
import com.cloudofgoods.authservice.entity.embeddable.AuthUserAuthPermissionPK;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Objects;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AuthUserAuthPermission {

    @EmbeddedId
    private AuthUserAuthPermissionPK authPermissionPK;
    @ManyToOne
    @MapsId("authUserId")
    private AuthUser authUser;
    @ManyToOne
    @MapsId("authPermissionId")
    private AuthPermission authPermission;
    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    public AuthUserAuthPermission(Long authUserId, Long authPermissionId, Date createdAt, Date updatedAt) {
        this.authPermissionPK = new AuthUserAuthPermissionPK(authUserId,authPermissionId);
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public AuthUserAuthPermission(AuthUserAuthPermissionPK authPermissionPK, Date createdAt, Date updatedAt) {
        this.authPermissionPK = authPermissionPK;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass())
            return false;

        AuthUserAuthPermission that = (AuthUserAuthPermission) o;
        return Objects.equals(authUser, that.authUser) &&
                Objects.equals(authPermission, that.authPermission);
    }

    @Override
    public int hashCode() {
        return Objects.hash(authUser, authPermission);
    }
}
