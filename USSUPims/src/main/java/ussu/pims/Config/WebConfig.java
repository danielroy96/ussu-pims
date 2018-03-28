/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ussu.pims.Config;

import java.util.Arrays;
import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 *
 * @author danielroy
 */
@Configuration
@EnableWebMvc
@ComponentScan({"ussu.pims.Controller"})
@Import({AppProperties.class, SecurityConfig.class})
public class WebConfig extends WebMvcConfigurerAdapter {

    /**
     * Default constructor required by Spring
     */
    public WebConfig() {
        
    }

    /**
     * Configures the content types for MIME types to be served
     * 
     * @param configurer the ContentNegotiationConfigurer for our app
     */
    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        configurer.defaultContentType(MediaType.APPLICATION_JSON).
                mediaType("html", MediaType.TEXT_HTML).
                mediaType("xml", MediaType.APPLICATION_XML).
                mediaType("json", MediaType.APPLICATION_JSON);
    }

    /**
     * Adds the Jackson JSON converter we're using to the application
     * 
     * @param converters the list of HTTP message converters we're using to
     * send object via JSON
     */
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {

        converters.add(new MappingJackson2HttpMessageConverter());
        super.configureMessageConverters(converters);
    }

    /**
     * Sets up the locations of different resource types relative to the
     * class path.
     * 
     * @param registry the resource handler registry for the app
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        
        registry.addResourceHandler("/css/**").addResourceLocations("classpath:/css/");
        registry.addResourceHandler("/img/**").addResourceLocations("classpath:/img/");
        registry.addResourceHandler("/js/**").addResourceLocations("classpath:/js/");
        registry.addResourceHandler("font/**").addResourceLocations("classpath:/font/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("/webjars/");
        
    }

    /**
     * Configures the default servlet handling
     * 
     * @param configurer the default servlet handler
     */
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    /**
     * Defines the locations and types of our views
     * 
     * @return the view resolver
     * @throws Exception
     */
    @Bean
    public ContentNegotiatingViewResolver contentViewResolver() throws Exception {

        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/jsp/");
        viewResolver.setSuffix(".jsp");
        ContentNegotiatingViewResolver contentViewResolver = new ContentNegotiatingViewResolver();
        contentViewResolver.setViewResolvers(Arrays.<ViewResolver>asList(viewResolver));
        return contentViewResolver;
        
    }

    /**
     * Registers the view controllers with the view controller registry
     * 
     * @param registry the view controller registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/").setViewName("redirect:index");
        
    }
}
