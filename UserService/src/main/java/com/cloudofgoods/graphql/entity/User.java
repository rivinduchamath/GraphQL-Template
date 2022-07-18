package com.cloudofgoods.graphql.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
//@Table(name = "user_entity")
public class CommonUserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userName;
    private String userMobileNumber;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Vendor vendorProfileData;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Customer customerEntity;


    public CommonUserEntity(String userName, String userMobileNumber) {
        this.userName = userName;
        this.userMobileNumber = userMobileNumber;
    }
}
