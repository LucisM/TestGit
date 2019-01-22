package com.test.controller;

import com.alibaba.fastjson.JSONException;
import com.sun.deploy.net.HttpResponse;
import com.test.entity.Collect;
import com.test.entity.Plan;
import com.test.service.PlanService;
import net.sf.json.JSON;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.List;

@Controller
@RequestMapping("/planController")
public class PlanController {
    @Resource
    private PlanService planService;
    @RequestMapping("update")
    public void update(HttpServletRequest request, HttpServletResponse response)throws IOException{
        request.setCharacterEncoding("utf-8");
        String result;
        Plan plan=new Plan();
        System.out.println("开始回去数据");
        plan.setGoal(request.getParameter("goal"));
        plan.setUsername(request.getParameter("username"));
        plan.setDays(Integer.valueOf(request.getParameter("days")));
        plan.setRemindDays(Integer.valueOf(request.getParameter("remind_days")));
        plan.setWordsFinished(Integer.valueOf(request.getParameter("words_finished")));
        plan.setWordsNumber(Integer.valueOf(request.getParameter("words_number")));
        plan.setRemindDaywords(Integer.valueOf(request.getParameter("remind_dayWords")));
        System.out.println("结束获取数据");
        System.out.println("获取的用户名+"+request.getParameter("username"));
        Plan plans=planService.selectPlan(request.getParameter("username"));
        System.out.println(plans.getUsername());
        if(plans==null){
            if(planService.insertPlan(plan)){
                result="success";
            }else {
                result="error";
            }
        }else {
            if(planService.updatePlan(plan)){
            result="success";
        }else {
            result="error";
        }
        }
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("result",result);
        response.getWriter().print(jsonObject);
    }
    @RequestMapping("getPlan")
    public void select(HttpServletRequest request, HttpServletResponse response)throws IOException{
        request.setCharacterEncoding("utf-8");
        Plan plan=planService.selectPlan(request.getParameter("username"));
        try {
            JSONObject jsonObject=JSONObject.fromObject(plan);
            if(plan!=null){
            jsonObject.put("result","success");

            }else {
                jsonObject.put("result","error");
            }
            response.getWriter().print(jsonObject);
        }catch (JSONException e){
            e.printStackTrace();
        }
    }
}
