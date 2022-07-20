package com.cloudofgoods.authservice.repository;

import com.cloudofgoods.authservice.entity.LoadAllDataWithRoles;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomDAO  {
    List<LoadAllDataWithRoles> getOrdersInfo();
}
