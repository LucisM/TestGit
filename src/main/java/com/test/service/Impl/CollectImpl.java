package com.test.service.Impl;

import com.test.dao.CollectMapper;
import com.test.entity.Collect;
import com.test.service.CollectService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CollectImpl implements CollectService {
    @Resource
    private CollectMapper collectMapper;

    @Override
    public boolean insertCollect(Collect collect) {
        int result=collectMapper.insert(collect);
        if(result!=0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean deleteCollect(String username) {
        int result=collectMapper.delete(username);
        if(result!=0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public List<Collect> selectCollect(String username) {
        List<Collect> collects=collectMapper.selectByUsername(username);
        return  collects;
    }
}
