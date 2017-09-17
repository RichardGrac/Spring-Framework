package com.udemy.backendninja.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/example")
public class ExampleController {

    public static final String EXAMPLE_VIEW = "example";

    //Primera forma: para cuando hacemos redirecciones sin datos o muy pocos datos
//    @RequestMapping(value = "/exampleString", method = RequestMethod.GET)
    @GetMapping("/exampleString")
    public String exampleString(Model model){
        // Habiendo un atributo th:text"${nombre_variable}" con nombre_variable = name en ambas partes (Controller y html)
        model.addAttribute("name", "Richard");
        return EXAMPLE_VIEW;
    }

    //Segunda forma: para cuando hay que insertar muchos datos a las plantillas
    @GetMapping("/exampleMAV")
//    @RequestMapping(value = "/exampleMAV", method = RequestMethod.GET)
    public ModelAndView exampleMAV(){
        ModelAndView mav = new ModelAndView(EXAMPLE_VIEW);
        mav.addObject("name","Mike");
        return mav;
    }
}
