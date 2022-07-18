package com.cloudofgoods.authservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.io.Serializable;
@Embeddable
@NoArgsConstructor
@Data
@AllArgsConstructor
public class AuthUserAuthRoleId implements Serializable {
    private Long roleId;
    private Long userId;
}
