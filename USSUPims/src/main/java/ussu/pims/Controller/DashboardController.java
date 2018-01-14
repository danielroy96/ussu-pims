/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ussu.pims.Controller;

import java.security.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ussu.pims.Model.User;
import ussu.pims.Service.UserService;

/**
 *
 * @author danielroy
 */
@Controller
public class DashboardController {
    
    @Autowired
    private UserService userService;
    
    
        /**
     * Maps requests for /index to the index view
     * 
     * @param model the model
     * @return the index view name
     * @throws Exception
     */
    @RequestMapping( value = "/index", method = RequestMethod.GET)
    protected String helloUser(Model model, Principal principal) throws Exception {
        String username = principal.getName();
        User user = userService.loadUserByUsername(username);
        model.addAttribute("userForename", userService.loadUserByUsername(username).getForename());
        model.addAttribute("userRole", user.getAuthorities().toString());
        return "index";
    }
    
    @RequestMapping(value="/user", method = RequestMethod.GET)
    protected String userDashboardAction(Model model, Principal principal) throws Exception {
        return "user";
    }
    
}
