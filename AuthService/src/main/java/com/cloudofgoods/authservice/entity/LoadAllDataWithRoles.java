package com.cloudofgoods.authservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.io.Serializable;
import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class LoadAllDataWithRoles implements Serializable {
    private Long authUserId;
    private Long roleId;
    private Date createdAt;
    private Date updatedAt;
    private String name;
    private Date createRole;
    private Date updateRole;
 }
