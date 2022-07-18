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
////@Table(name = "customer_entity")
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//public class Customer {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @Size(max = 15)
//    private String zipCode;
//
//
//    @OneToOne(fetch = FetchType.LAZY, optional = false ,mappedBy = "customerEntity")
//    //@MapsId
//    @JoinColumn(insertable = false, updatable = false, nullable = false)
//    private User userEntity;
//
//    public Customer(String zipCode) {
//        this.zipCode = zipCode;
//    }
//
//
//
//    public void setCommonUser(User userEntity) {
//        this.userEntity = userEntity;
//    }
//}
