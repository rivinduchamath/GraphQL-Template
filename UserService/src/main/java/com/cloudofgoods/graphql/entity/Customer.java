package com.cloudofgoods.graphql.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "customer_profiles")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "zip_Code")
    @Size(max = 15)
    private String zipCode;


    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @MapsId
    @JoinColumn(name = "customer_Id", insertable = false, updatable = false, nullable = false)
    private CommonUserEntity commonUser;

    public Customer(String zipCode) {
        this.zipCode = zipCode;
    }



    public void setCommonUser(CommonUserEntity commonUser) {
        this.commonUser = commonUser;
    }
}
