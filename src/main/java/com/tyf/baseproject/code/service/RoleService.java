package com.tyf.baseproject.code.service;

import com.tyf.baseproject.code.entity.Role;

import java.util.List;

public interface RoleService {

    List<Role> findAll();

    List<Role> findByMenuId(Integer id);

}
