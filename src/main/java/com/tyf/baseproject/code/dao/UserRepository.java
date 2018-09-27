package com.tyf.baseproject.code.dao;

import com.tyf.baseproject.base.repository.ExpandJpaRepository;
import com.tyf.baseproject.code.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends ExpandJpaRepository<User,Integer> {

    User findByUsername(String name);

}
