package com.test.controller;

import com.alibaba.fastjson.JSONObject;
import com.test.entity.Adminstratiors;
import com.test.entity.Test;
import com.test.service.SearchService;
import com.test.service.TestService;
import org.apache.ibatis.io.ResolverUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/tester")
public class test {
    @Resource
    private TestService testService;
    @Resource
    private SearchService searchService;
    @RequestMapping("sqlTest")
    public String sqlTest(Model model){
        List<Test> TMSG=testService.showTest();
        model.addAttribute("test",TMSG);
        return  "show";
    }
    @RequestMapping("login.json")
    public void doPOST(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException{
        System.out.print("进入服务器");
        request.setCharacterEncoding("utf-8");
        String name="";
        String password="";
        name=request.getParameter("name");
        password=request.getParameter("password");
        String result="";
        if(searchService.loginCheck(name,password)){
            result="success";
        }else {
            result="error";
        }
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("result",result);
        response.getWriter().print(jsonObject);
    }
}
