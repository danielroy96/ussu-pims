/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ussu.pims.Config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;


/**
 *
 * @author danielroy
 */
@Configuration
public class ErrorHandler {

    @Bean
    public HandlerExceptionResolver handlerExceptionResolver() {
        HandlerExceptionResolver myResolver = new HandlerExceptionResolver() {

            @Override
            public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception exception) {
                //return your 404 page
                ModelAndView mav = new ModelAndView("error");
                mav.addObject("error", exception);
                return mav;
            }
        };
        return myResolver;
    }
}
