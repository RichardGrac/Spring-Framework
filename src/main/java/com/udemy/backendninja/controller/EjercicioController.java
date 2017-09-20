package com.udemy.backendninja.controller;

import com.udemy.backendninja.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/ejercicio")
public class EjercicioController {

    public static String VISTA_MSJ = "mensaje";

    @Autowired
    @Qualifier("logService")
    private LogService logService;

    // Al entrar a: localhost:8080/ejercicio viene a este metodo que redireccionará al segundo:
    @GetMapping("")
    public RedirectView path1(){
        return new RedirectView("/ejercicio/path2");
    }

    // Aqui se trabaja con un bean (el cual es un Servicio) y llamamos a la Funcion .muestraLog
    // Seteamos al modelo el atributo "Mensaje" y returnamos su corresp. Vista
    @GetMapping("/path2")
    public String path2(Model model){
        logService.muestra_log();
        model.addAttribute("mensaje","Insertando caracteres desde el 2° Método");
        return VISTA_MSJ;
    }
}
