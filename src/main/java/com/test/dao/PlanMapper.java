package com.test.dao;

import com.test.entity.Plan;

public interface PlanMapper {
    int deleteByPrimaryKey(String username);

    int insert(Plan record);

    int insertSelective(Plan record);

    Plan selectByPrimaryKey(String username);

    int updateByPrimaryKeySelective(Plan record);

    int updateByPrimaryKey(Plan record);
}