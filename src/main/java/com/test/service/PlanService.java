package com.test.service;

import com.test.entity.Plan;

public interface PlanService {
    public boolean updatePlan(Plan plan);
    public boolean insertPlan(Plan plan);
    public Plan selectPlan(String Username);
}
