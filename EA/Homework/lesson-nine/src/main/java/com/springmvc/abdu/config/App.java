package com.springmvc.abdu.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.context.support.GenericWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class App implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext container) throws ServletException{

        // Create the 'root' Spring application context
        AnnotationConfigWebApplicationContext annotationConfigWebApplicationContext = new AnnotationConfigWebApplicationContext();
        annotationConfigWebApplicationContext.register(WebConfig.class);
        container.addListener(new ContextLoaderListener(annotationConfigWebApplicationContext));

        // Create the dispatcher servlet
        ServletRegistration.Dynamic appServlet = container.addServlet("mvc", new DispatcherServlet(new GenericWebApplicationContext()));
        appServlet.setLoadOnStartup(1);
        appServlet.addMapping("/");
    }


}
