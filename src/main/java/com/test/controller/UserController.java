package com.test.controller;

import com.alibaba.fastjson.JSONObject;
import com.test.entity.User;
import com.test.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;
    public void checkLogin(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException {
        System.out.print("进入服务器");
        request.setCharacterEncoding("utf-8");
        String name="";
        String password="";
        name=request.getParameter("name");
        password=request.getParameter("password");
        String result="";
        if(userService.checkLoging(name,password)!=null){
            result="success";
        }else {
            result="error";
        }
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("result",result);
        response.getWriter().print(jsonObject);
    }
}
