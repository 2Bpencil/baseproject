package com.tyf.baseproject.code.controller;

import com.tyf.baseproject.code.entity.User;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@RestController
@RequestMapping("/demo")

public class DemoController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @RequestMapping(value = "getSomething",method = RequestMethod.GET)
    public String getSomething(){
        return "hello springboot";
    }
    @RequestMapping(value = "getSomething2",method = RequestMethod.GET)
    public void getSomething2(HttpServletRequest request, HttpServletResponse response){
        String str = request.getParameter("param");
        try {
            //这句话的意思，是让浏览器用utf8来解析返回的数据
            response.setHeader("Content-type", "text/html;charset=UTF-8");
            //这句话的意思，是告诉servlet用UTF-8转码，而不是用默认的ISO8859
            response.setCharacterEncoding("utf-8");
            response.getWriter().print("param参数："+str);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    @RequestMapping(value = "getSomething3",method = RequestMethod.GET)
    public String getSomething3(){
        String sql = "select * from user";
        List<User> list = jdbcTemplate.query(sql,new BeanPropertyRowMapper<User>(User.class));
        String json = JSONArray.fromObject(list).toString();
        return json;
    }

}
