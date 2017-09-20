package com.udemy.backendninja.component;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/* Esta clase junto con EjercicioConfiguration nos devolverán el tiempo que tardó en cargar la página  */
@Component("requestTimeEjercicio")
public class RequestTimeEjercicio extends HandlerInterceptorAdapter{

    public static final Log LOG = LogFactory.getLog(RequestTimeEjercicio.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        request.setAttribute("tiempoInicial", System.currentTimeMillis());
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        long startTime = (long) request.getAttribute("tiempoInicial");
        LOG.info("--REQUEST URL: '" + request.getRequestURL() + "' -- TOTAL TIME: '"
                + (System.currentTimeMillis()-startTime) + "' ms.");
    }
}
