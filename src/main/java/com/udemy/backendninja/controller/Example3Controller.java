package com.udemy.backendninja.controller;

import com.udemy.backendninja.model.Person;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/example3")
public class Example3Controller {

    private static final Log LOGGER = LogFactory.getLog(Example3Controller.class);

    public static final String FORM_VIEW = "form";
    public static final String RESULT_VIEW = "result";

    // 1° Forma de redireccionar
//    @GetMapping("") // Puede ser con "/" o sin ella "" (quedando: localhost:8080/example3/ o localhost:8080/example3)
//    public String redirect(){
//        return "redirect:/example3/showform";
//    }

    // 2° Forma de redireccionar
    @GetMapping("/")    // Quedando "localhost:8080/example3/"
    public RedirectView redirect(){
        return new RedirectView("/example3/showform");
    }

    //En el buscador me voy a "/showform" y me returna form.html, luego al llenar los campos y dar al button "Send"
    //Hace un Post el cual regresará un ModelAndView (Una vista) con el objeto que leimos anteriormente ("person")
    //en  result.html podemos trabajar con esos valores con th:text="$..."

    @GetMapping("/showform") // Solicitamos un recurso
    public String showForm(Model model){
        LOGGER.info("INFO TRACE");
        LOGGER.warn("WARNING TRACE");
        LOGGER.error("ERROR TRACE");
        LOGGER.debug("DEBUG TRACE");
        model.addAttribute("person", new Person()); //Agregamos un modelo/objeto de tipo "Person"
//        int i = 6/0; // Provocamos al error500
        return FORM_VIEW;
    }

    @PostMapping("/addperson")
    public ModelAndView addPerson(@ModelAttribute("person") Person person){
        LOGGER.info("METHOD: 'addPerson' --PARAM: '" + person + "'");
        ModelAndView mav = new ModelAndView(RESULT_VIEW);
        mav.addObject("person", person); // Añadimos un modelo "person" el cual es person
        LOGGER.info("TEMPLATE: '" + RESULT_VIEW + "' --DATA: '" + person + "'");
        return mav;
    }
}
