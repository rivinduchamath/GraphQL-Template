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
public class AuthUserAuthRolePK implements Serializable {
    @Column(name = "auth_role_id")
    private Long roleId;
    @Column(name = "auth_user_id")
    private Long userId;
}
