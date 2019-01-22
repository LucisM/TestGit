package com.test.dao;

import com.test.entity.Collect;
import com.test.entity.CollectKey;

import java.util.List;

public interface CollectMapper {
    int deleteByPrimaryKey(CollectKey key);

    int insert(Collect record);

    int insertSelective(Collect record);

    Collect selectByPrimaryKey(CollectKey key);

    int updateByPrimaryKeySelective(Collect record);

    int updateByPrimaryKey(Collect record);
    int delete(String username);
    List<Collect> selectByUsername(String username);
}