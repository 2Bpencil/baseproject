package com.tyf.baseproject.code.dao;

import com.tyf.baseproject.base.repository.ExpandJpaRepository;
import com.tyf.baseproject.code.entity.Menu;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface MenuRepository extends ExpandJpaRepository<Menu,Integer> {

    @Query(value = "select r.* from menu m left join r_role_menu rm on m.id = rm.menu_id left join role r on r.id = rm.role_id where r.id = ?1 ", nativeQuery = true)
    List<Menu> findByRoleId(Integer roleId);


}
