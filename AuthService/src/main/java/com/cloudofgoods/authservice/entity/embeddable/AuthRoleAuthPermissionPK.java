package com.cloudofgoods.authservice.entity.embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@NoArgsConstructor
@Data
@AllArgsConstructor
public class AuthRoleAuthPermissionPK implements Serializable {
    @Column(name="auth_role_id")
    private Long authRole;
    @Column(name="auth_permission_id")
    private Long authPermission;
}
