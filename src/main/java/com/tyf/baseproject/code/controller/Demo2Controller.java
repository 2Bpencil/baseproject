package com.tyf.baseproject.code.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/demo2")
public class Demo2Controller {

    @RequestMapping(value = "index",method = RequestMethod.GET)
    public String toHome(){
        return "index";
    }

    @RequestMapping(value = "login",method = RequestMethod.GET)
    public String toLogin(){
        return "index";
    }

    @RequestMapping(value = "default",method = RequestMethod.GET)
    public String toDefault(){
        return "default";
    }
    @RequestMapping(value = "demoList",method = RequestMethod.GET)
    public ModelAndView toDemoList(){
        ModelAndView view = new ModelAndView("demoList");
        List<Map<String,Object>> list = new ArrayList<>();
        Map<String,Object> map = new HashMap<>();
        map.put("name","tyf");
        map.put("age","28");
        Map<String,Object> map2 = new HashMap<>();
        map2.put("name","ly");
        map2.put("age","28");
        list.add(map);
        list.add(map2);
        view.addObject("demoList",list);
        return view;
    }




}
