package com.tyf.baseproject.code.service.impl;

import com.tyf.baseproject.code.dao.MenuRepository;
import com.tyf.baseproject.code.dao.RoleRepository;
import com.tyf.baseproject.code.entity.Menu;
import com.tyf.baseproject.code.entity.Role;
import com.tyf.baseproject.code.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private MenuRepository menuRepository;

    @Override
    public List<Role> findAll() {
        List<Role> allRoles = new ArrayList<>();
        List<Role> roles = roleRepository.findAll();
        roles.forEach(role -> {

            List<Menu> menus = menuRepository.findByRoleId(role.getId());
            role.setMenus(menus);
            allRoles.add(role);

        });
        return allRoles;
    }

    @Override
    public List<Role> findByMenuId(Integer id) {
        return roleRepository.findByMenuId(id);
    }
}
