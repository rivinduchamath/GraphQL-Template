package com.cloudofgoods.authservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
@NoArgsConstructor
@Data
@AllArgsConstructor
public class AuthUserAuthPermissionId implements Serializable {

    private Long authPermissionId;
    private Long authUserId;
    //Getters omitted for brevity

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass())
            return false;

        AuthUserAuthPermissionId that = (AuthUserAuthPermissionId) o;
        return Objects.equals(authPermissionId, that.authPermissionId) &&
                Objects.equals(authUserId, that.authUserId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(authPermissionId, authUserId);
    }

}
