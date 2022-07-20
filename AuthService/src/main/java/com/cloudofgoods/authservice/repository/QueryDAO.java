package com.cloudofgoods.authservice.repository;

import com.cloudofgoods.authservice.entity.customentity.LoadAllDataWithRoles;

import java.util.List;

public interface QueryDAO  {
    List<LoadAllDataWithRoles> getOrdersInfo();
}
