package com.test.service.Impl;

import com.test.dao.TestMapper;
import com.test.service.SearchService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
@Service
public class SearchImpl implements SearchService {
    @Resource
    TestMapper testMapper;
    @Override
    public boolean loginCheck(String name, String password) {
        String  result=testMapper.selectByName(name,password);
        if(result!=null){
            return true;
        }else {
            return false;
        }
    }
}
