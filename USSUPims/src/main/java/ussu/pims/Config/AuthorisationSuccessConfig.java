/*
 * Advanced Challenges in Web Technologies Coursework
 * University of Surrey - Group 5
 * Semester 1 - 2017
 */
package ussu.pims.Config;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

/**
 *
 * @author danielroy
 */
public class AuthorisationSuccessConfig extends SavedRequestAwareAuthenticationSuccessHandler {
    
    private RedirectStrategy redirectStrategy;
    
    /**
     * Default constructor
     */
    public AuthorisationSuccessConfig () {
        redirectStrategy = new DefaultRedirectStrategy();
    }
    
    /**
     * Handles what the application does when a login is successful
     * 
     * @param request the HTTP request
     * @param response the response to send to the browser
     * @param authentication the authentication object
     * @throws IOException
     */
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {
        
        String role = authentication.getAuthorities().toString();
        String url = "";
        
        if(role.equalsIgnoreCase("[ROLE_USER]")) {
            url = "/index";
        } else if(role.equalsIgnoreCase("[ROLE_ADMIN]")) {
            url = "/index";
        }
        
        redirectStrategy.sendRedirect(request, response, url);
        
    }
    
}
