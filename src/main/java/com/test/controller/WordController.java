package com.test.controller;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.test.entity.Word;
import com.test.service.WordService;
import net.sf.json.JSON;
import net.sf.json.JSONArray;
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
@RequestMapping("/wordController")
public class WordController {
    @Resource
    private WordService wordService;
    @RequestMapping("getAllWord.json")
    public void doPOST(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException{
        List<Word> words=wordService.getAllWord();
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String a=request.getParameter("table");
        try {
            JSONArray jsonArray=JSONArray.fromObject(words);
            JSONObject jsonObject=new JSONObject();
            String data=jsonArray.toString();
            jsonObject.put("words",data);
            response.getWriter().print(jsonObject);
        }catch (JSONException e){
            e.printStackTrace();
        }
    }
}
