package com.cloudofgoods.graphql.repository;

import com.cloudofgoods.graphql.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommonUserRepository  extends JpaRepository<User, Long> {
}
