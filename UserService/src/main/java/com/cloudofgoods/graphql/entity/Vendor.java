//package com.cloudofgoods.graphql.entity;
//
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import javax.persistence.*;
//import javax.validation.constraints.Size;
//
//@Entity
////@Table(name = "vendor_entity")
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//public class Vendor {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @Size(max = 15)
//    private String nikName;
//
//
//    @OneToOne(fetch = FetchType.LAZY, optional = false ,
//            mappedBy = "vendorProfileData")
//    //@MapsId
//    @JoinColumn(insertable = false, updatable = false, nullable = false)
//    private User userEntity;
//
//    public Vendor(String nikName) {
//        this.nikName = nikName;
//    }
//
//}
