package com.udemy.backendninja.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/error")
public class Example4Controller {

    public static final String ERROR404 = "404";
    public static final String ERROR500 = "500";

    @GetMapping("/404")
    public String showError404(){
        return ERROR404;
    }

    @GetMapping("/500")
    public String showError500(){
        return ERROR500;
    }

}
