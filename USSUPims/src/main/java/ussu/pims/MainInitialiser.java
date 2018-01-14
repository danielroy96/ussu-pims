/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ussu.pims;

import ussu.pims.Config.RootConfig;
import ussu.pims.Config.WebConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

/**
 *
 * @author danielroy
 */
public class MainInitialiser implements WebApplicationInitializer {

    /**
     * Runs on startup to register the servlet and add the "/" mapping.
     * 
     * @param sc the servlet context of the app
     * @throws ServletException
     */
    @Override
    public void onStartup(ServletContext sc) throws ServletException {
        
        AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
        rootContext.register(RootConfig.class);

        sc.addListener(new ContextLoaderListener(rootContext));

        AnnotationConfigWebApplicationContext mvcContext = new AnnotationConfigWebApplicationContext();
        mvcContext.register(WebConfig.class);

        ServletRegistration.Dynamic dispatcherServlet = sc.addServlet("appServlet", new DispatcherServlet(mvcContext));
        dispatcherServlet.setLoadOnStartup(1);
        dispatcherServlet.addMapping("/");
        dispatcherServlet.setInitParameter("throwExceptionIfNoHandlerFound", "true");
    }

}
