package com.cloudofgoods.graphql.repository;

import com.cloudofgoods.graphql.entity.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendorRepository extends JpaRepository<Vendor, Long> {
}
