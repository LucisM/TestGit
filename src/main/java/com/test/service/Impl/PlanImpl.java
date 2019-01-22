package com.test.service.Impl;

import com.test.dao.PlanMapper;
import com.test.entity.Plan;
import com.test.service.PlanService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PlanImpl implements PlanService {
    @Resource
    private PlanMapper planMapper;
    @Override
    public boolean updatePlan(Plan plan) {
        int a=planMapper.updateByPrimaryKey(plan);
        if(a==0){
            return false;
        }else {
            return true;
        }
    }

    @Override
    public boolean insertPlan(Plan plan) {
       int result= planMapper.insert(plan);
        if(result==0){
            return false;
        }else {
            return true;
        }
    }

    @Override
    public Plan selectPlan(String username) {
        Plan plan=planMapper.selectByPrimaryKey(username);
        return plan;
    }
}
