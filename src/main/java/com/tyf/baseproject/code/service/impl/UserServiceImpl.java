package com.tyf.baseproject.code.service.impl;

import com.tyf.baseproject.code.dao.RoleRepository;
import com.tyf.baseproject.code.dao.UserRepository;
import com.tyf.baseproject.code.entity.Role;
import com.tyf.baseproject.code.entity.User;
import com.tyf.baseproject.code.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService,UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(name);
        if (user != null) {
            List<Role> roles = roleRepository.findByUserId(user.getId());
            user.setRoles(roles);
            List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
            for (Role role : roles) {
                GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(role.getName());
                //1：此处将权限信息添加到 GrantedAuthority 对象中，在后面进行全权限验证时会使用GrantedAuthority 对象。
                grantedAuthorities.add(grantedAuthority);
            }
            return user;
        } else {throw new UsernameNotFoundException("admin: " + name + " do not exist!");

        }
    }
}
