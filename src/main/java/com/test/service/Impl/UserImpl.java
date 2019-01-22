package com.test.service.Impl;

import com.test.dao.UserMapper;
import com.test.entity.User;
import com.test.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserImpl implements UserService {
    @Resource
    private UserMapper userMapper;
    @Override
    public String checkLoging(String username, String password) {
        String result=userMapper.selectByName(username,password);
        return result;
    }

    @Override
    public String Insert(User user) {
        return null;
    }
}
