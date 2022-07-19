package com.cloudofgoods.authservice.entity;

import com.cloudofgoods.authservice.entity.embeddable.AuthUserAuthPermissionId;
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
    private AuthUserAuthPermissionId id;
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
