package com.test.service.Impl;

import com.test.dao.AdminstratiorsMapper;
import com.test.dao.TestMapper;
import com.test.entity.Adminstratiors;
import com.test.entity.Test;
import com.test.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class testImpl implements TestService {
    @Resource
    private AdminstratiorsMapper adminstratiorsMapper;
    @Resource
    private TestMapper testMapper;
    @Override
    public List<Adminstratiors> showAccout() {
        List<Adminstratiors> ADmsg=adminstratiorsMapper.ShowAll();
        return ADmsg;
    }
    @Override
    public List<Test> showTest(){
        List<Test> Tmsg=testMapper.ShowAll();
        return  Tmsg;
    }

}
