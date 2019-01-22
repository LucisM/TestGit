package com.test.dao;

import com.test.entity.Word;

import java.util.List;

public interface WordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Word record);

    int insertSelective(Word record);

    Word selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Word record);

    int updateByPrimaryKey(Word record);
    List<Word> getAllWords();
}