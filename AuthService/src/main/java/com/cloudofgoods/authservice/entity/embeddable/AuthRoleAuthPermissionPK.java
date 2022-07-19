package com.cloudofgoods.authservice.entity.embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@NoArgsConstructor
@Data
@AllArgsConstructor
public class AuthRoleAuthPermissionPK implements Serializable {
    private Long authRole;
    private Long authPermission;
}
