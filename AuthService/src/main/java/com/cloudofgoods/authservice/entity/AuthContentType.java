//package com.cloudofgoods.authservice.entity;
//
//
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import javax.persistence.*;
//
//import java.util.Date;
//import java.util.Set;
//
//@Entity
//@AllArgsConstructor
//@NoArgsConstructor
//@Data
//public class AuthContentType {
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Long id;
//    private String appLabel;
//    private String modelName;
//    @OneToMany(mappedBy="authContentType")
//    private Set<AuthPermission> authPermissionSet;
//
//    @Temporal(TemporalType.TIMESTAMP)
//    private Date createdAt;
//
//    @Temporal(TemporalType.TIMESTAMP)
//    private Date updatedAt;
//
//    public AuthContentType(Long id, String appLabel, String modelName, Date createdAt, Date updatedAt) {
//        this.id = id;
//        this.appLabel = appLabel;
//        this.modelName = modelName;
//        this.createdAt = createdAt;
//        this.updatedAt = updatedAt;
//    }
//}
