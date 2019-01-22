package com.test.dao;

import com.test.entity.Adminstratiors;

import java.util.List;
public interface AdminstratiorsMapper {
    int deleteByPrimaryKey(Integer adminid);

    int insert(Adminstratiors record);

    int insertSelective(Adminstratiors record);

    Adminstratiors selectByPrimaryKey(Integer adminid);

    int updateByPrimaryKeySelective(Adminstratiors record);

    int updateByPrimaryKey(Adminstratiors record);
    public List<Adminstratiors> ShowAll();
}