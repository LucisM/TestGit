package com.test.service;

import com.test.entity.User;

public interface UserService {
    public String checkLoging(String username,String password);
    public String Insert(User user);
}
