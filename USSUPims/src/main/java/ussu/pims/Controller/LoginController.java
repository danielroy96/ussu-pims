/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ussu.pims.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author danielroy
 */
@Controller
public class LoginController {
    
    /**
     * Directs requests for /login to the login view and adds objects to the
     * model to display to the client in exceptional circumstances
     * 
     * @param error whether there was a login error
     * @param logout whether the client has been directed from the logout action
     * @return the model
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login(@RequestParam(value = "error", required = false) String error, @RequestParam(value = "logout", required = false) String logout) {
        
        ModelAndView model = new ModelAndView();
        
        if (error != null) {
            model.addObject("error", "Incorret username/password");
        }

        if (logout != null) {
            model.addObject("logout", "Logout successful");
        }
        
        model.setViewName("login");

        return model;

    }
    
}
