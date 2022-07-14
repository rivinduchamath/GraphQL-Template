package com.cloudofgoods.graphql.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonUserEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String userName;
    private String userMobileNumber;
    @OneToOne(mappedBy = "commonUser", cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = true)
//    @JoinColumn(name = "vendorData")
    private Vendor vendorProfileData;
    @OneToOne(mappedBy = "commonUser", cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = true)
//    @JoinColumn(name = "customerData")
    private Customer customerProfileData;


    public CommonUserEntity(String userName, String userMobileNumber) {
        this.userName = userName;
        this.userMobileNumber = userMobileNumber;
    }
}
