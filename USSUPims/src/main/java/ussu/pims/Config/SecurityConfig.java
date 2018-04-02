/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ussu.pims.Config;

import ussu.pims.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 * @author danielroy
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    
    @Autowired
    private UserService userService;
    
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    /**
     * Configures the paths which need authentication and permitted roles
     * throughout the application.
     * 
     * @param http the HttpSecurity object for the application
     * @throws Exception
     */
    @Override
    protected void configure (HttpSecurity http) throws Exception {
        
        http
            .authorizeRequests()
                .antMatchers("/index").hasAnyRole("USER", "ADMIN")
                .antMatchers("/admin").hasRole("ADMIN")
                .antMatchers("/message").hasRole("USER")
                .antMatchers("/messages/**").hasRole("USER")
                .antMatchers("/topic/**").hasRole("USER")
                .antMatchers("/createmessage/**").hasRole("USER")
                .antMatchers("/currentuser/**").hasRole("USER")
                .antMatchers("/user/**").hasRole("ADMIN")
                .antMatchers("/user-details/**").hasRole("ADMIN")
                .antMatchers("/test/**").hasAnyRole("USER", "ADMIN")
                .antMatchers("/item/**").hasAnyRole("USER", "ADMIN")
                .antMatchers("/add/**").hasAnyRole("USER", "ADMIN")
                .antMatchers("/search/**").hasAnyRole("USER", "ADMIN")
                .antMatchers("/job/**").hasAnyRole("USER", "ADMIN")
                .antMatchers("/report/**").hasAnyRole("USER", "ADMIN")
                .antMatchers("/client/**").hasAnyRole("USER", "ADMIN")
                .antMatchers("webjars/**").permitAll()
                .antMatchers("resources/**").permitAll()
                .and()
            .formLogin()
                .successHandler(new AuthorisationSuccessConfig())
                .loginPage("/login")
                .permitAll()
                .and()
            .logout()
                .permitAll()
                .and()
            .csrf().disable();
        
    }
    
    /**
     * This sets up paths to ignore security rules for, as they contain static
     * resources we want to be accessible (especially on the login screen)
     * 
     * @param web the WebSecurity object for the app
     * @throws Exception
     */
    @Override
    public void configure (WebSecurity web) throws Exception {
        web.ignoring().antMatchers("webjars/**");
        web.ignoring().antMatchers("css/**");
    }
    
    /**
     * Joins our custom user details service to the Spring authentication
     * manager.
     * 
     * @param authenticationManagerBuilder the AuthenticationManagerBuilder
     *        for the app
     * @throws Exception
     */
    @Autowired
    public void configureGlobal (AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder.userDetailsService(userService);
        authenticationManagerBuilder.authenticationProvider(authenticationProvider());
    }
    
    /**
     * Provides an authentication provider to spring for our custom user
     * details service and authentication provider.
     * 
     * @return returns the authentication provider for our user details service
     */
    @Bean
    public DaoAuthenticationProvider authenticationProvider () {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userService);
        authenticationProvider.setPasswordEncoder(passwordEncoder);
        return authenticationProvider;
    }
    
    @Bean
    public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
}
    
}
