package com.iwant.api.dao;

import com.iwant.api.model.WantActivity;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface WantActivityDao extends CrudRepository<WantActivity, Long>, JpaSpecificationExecutor {
    List<WantActivity> findByUserId(String userId);
}