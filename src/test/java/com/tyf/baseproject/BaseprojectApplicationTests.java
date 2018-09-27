package com.tyf.baseproject;

import com.tyf.baseproject.code.dao.RoleRepository;
import com.tyf.baseproject.code.dao.UserRepository;
import com.tyf.baseproject.code.entity.Role;
import com.tyf.baseproject.code.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BaseprojectApplicationTests {


    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private UserRepository userRepository;

    @Test
    public void contextLoads() {

        /*List<Role> roles = roleRepository.findByUserId(2);

        System.out.print(roles.size());*/

        String pwd = "123456";
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        // 加密
        String encodedPassword = passwordEncoder.encode(pwd);
        System.out.println("【加密后的密码为：】" + encodedPassword);


    }

}
