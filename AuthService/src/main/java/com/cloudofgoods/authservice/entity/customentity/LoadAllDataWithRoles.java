package com.cloudofgoods.authservice.entity.customentity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class LoadAllDataWithRoles implements Serializable {
    private BigInteger authUserId;
    private BigInteger roleId;
    private Date createdAt;
    private Date updatedAt;
    private String name;
    private Date createRole;
    private Date updateRole;
 }
