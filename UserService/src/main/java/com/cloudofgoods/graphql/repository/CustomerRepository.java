package com.cloudofgoods.graphql.repository;

import com.cloudofgoods.graphql.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
