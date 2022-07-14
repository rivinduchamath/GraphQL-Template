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
    private Long commonUserId;
    private String userName;
    private String userMobileNumber;
    @OneToOne(mappedBy = "commonUser", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "vendorData")
    private Vendor vendorProfileData;


}
