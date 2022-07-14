package com.cloudofgoods.graphql.repository;

import com.cloudofgoods.graphql.entity.CommonUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommonUserRepository  extends JpaRepository<CommonUserEntity, Long> {
}
