package com.cloudofgoods.graphql.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "vendor_profiles")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vendor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nik_Name")
    @Size(max = 15)
    private String nikName;


    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @MapsId
    @JoinColumn(name = "vendor_Id",  insertable = false, updatable = false, nullable = false)
    private CommonUserEntity commonUser;

    public Vendor(String nikName) {
        this.nikName = nikName;
    }


}
