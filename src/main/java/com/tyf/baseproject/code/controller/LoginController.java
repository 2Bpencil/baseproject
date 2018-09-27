package com.tyf.baseproject.code.controller;

import com.tyf.baseproject.code.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class LoginController {
    private final static Logger logger = LoggerFactory.getLogger(LoginController.class);

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String showHome(Model model) {
        String name = SecurityContextHolder.getContext().getAuthentication().getName();

        logger.info("当前登陆用户：" + name);
        model.addAttribute("name",name);
        return "index";
    }






}
