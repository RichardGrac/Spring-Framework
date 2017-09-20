package com.udemy.backendninja.configuration;

import com.udemy.backendninja.component.RequestTimeEjercicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class EjercicioConfiguration extends WebMvcConfigurerAdapter{

    // Obtenemos el bean del Interceptor
    @Autowired
    @Qualifier("requestTimeEjercicio")
    private RequestTimeEjercicio requestTimeEjercicio;

    //Añadimos el interceptor del bean que ya obtuvimos
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(requestTimeEjercicio);
    }
}
