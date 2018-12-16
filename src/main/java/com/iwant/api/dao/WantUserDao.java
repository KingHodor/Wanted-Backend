package com.iwant.api.dao;

import com.iwant.api.model.WantUser;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

@Transactional
public interface WantUserDao extends CrudRepository<WantUser, Long>, JpaSpecificationExecutor {

    WantUser findByUserId(String userId);
}