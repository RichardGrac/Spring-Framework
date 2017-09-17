package com.udemy.backendninja.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/say")
public class HelloWorldController {

    @GetMapping("/hello")   //localhost:8080/say/hello devolverla la plantilla "helloworld.html"
    public String helloWorld(){
        return "helloworld";
    }
}
