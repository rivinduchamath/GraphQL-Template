package com.cloudofgoods.graphql.entity;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "vendor_profiles")
public class Vendor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "phoneNumber")
    @Size(max = 15)
    private String phoneNumber;


    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @MapsId
    @JoinColumn(name = "vendorId", referencedColumnName = "commonUserId", insertable = false, updatable = false, nullable = false)
    private CommonUserEntity commonUser;
}
