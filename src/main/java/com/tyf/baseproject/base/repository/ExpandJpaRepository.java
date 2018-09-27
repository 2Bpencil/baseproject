package com.tyf.baseproject.base.repository;

import org.springframework.cglib.core.Predicate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.expression.spel.ast.Operator;

import java.io.Serializable;
import java.util.List;
import java.util.Map;


@NoRepositoryBean
public interface ExpandJpaRepository<T , ID extends Serializable> extends JpaRepository<T,ID> {




}
