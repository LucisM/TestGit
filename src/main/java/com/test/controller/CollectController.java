package com.test.controller;

import com.test.entity.Collect;
import com.test.entity.Word;
import com.test.service.CollectService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.json.JSONException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.List;

@Controller
@RequestMapping("/CollectController")
public class CollectController {
    @Resource
    private CollectService collectService;
    @RequestMapping("insert")
    public void insert(HttpServletRequest request, HttpServletResponse response)throws IOException {
        request.setCharacterEncoding("utf-8");
        System.out.println("开始获取数据");
        org.json.JSONArray jsonArray=new org.json.JSONArray(request.getParameter("collects"));
        System.out.println("结束获取数据");
        String result="null";
        try {
            for(int i=0;i<jsonArray.length();i++){
                org.json.JSONObject jsonObject=jsonArray.getJSONObject(i);
                Collect collect=new Collect();
                collect.setUsername(jsonObject.getString("username"));
                collect.setWord(jsonObject.getString("word"));
                collect.setMeaning(jsonObject.getString("meaning"));
                if(collectService.insertCollect(collect)){
                    result="success";
                }else {
                    result="error";
                }
            }
            JSONObject jsonObject=new JSONObject();
            jsonObject.put("result",result);
            response.getWriter().print(jsonObject);
        }catch (JSONException e){
            e.printStackTrace();
        }
    }
    @RequestMapping("getCollects")
    public void doPOST(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException{
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        List<Collect> collects=collectService.selectCollect(request.getParameter("username"));
//        if(collects!=null){
//            collectService.deleteCollect(request.getParameter("username"));
//        }
        try {
            JSONArray jsonArray= net.sf.json.JSONArray.fromObject(collects);
            JSONObject jsonObject=new JSONObject();
            String data=URLDecoder.decode(jsonArray.toString(),"UTF-8");
            jsonObject.put("collect",data);
            response.getWriter().print(jsonObject);
        }catch (com.alibaba.fastjson.JSONException e){
            e.printStackTrace();
        }
    }
}
