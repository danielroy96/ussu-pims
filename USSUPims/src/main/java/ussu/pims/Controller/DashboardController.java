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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    protected String helloUser(Model model, Principal principal) throws Exception {
        String username = principal.getName();
        User user = userService.loadUserByUsername(username);
        model.addAttribute("userForename", user.getForename());
        model.addAttribute("userRole", user.getAuthorities().toString());
        return "index";
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    protected String userDashboardAction(Model model, Principal principal) throws Exception {
        return "user";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    protected String addDashboardAction(Model model, Principal principal) throws Exception {
        return "add";
    }

    @RequestMapping(value = "/event", method = RequestMethod.GET)
    protected String eventDashboardAction(Model model, Principal principal) throws Exception {
        return "events";
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    protected String searchDashboardAction(Model model, Principal principal) throws Exception {
        return "search";
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    protected String testDashboardAction(Model model, Principal principal) throws Exception {
        User user = userService.loadUserByUsername(principal.getName());
        model.addAttribute("userFullName", user.getTitle() + " " + user.getForename() + " " + user.getSurname());
        model.addAttribute("userID", user.getId());
        return "test";
    }

    /*@RequestMapping(value="/user-details/{user}", method = RequestMethod.GET)
    protected String userDetailsUpdate(@PathVariable("user") String userID, Model model) throws Exception {
        User user = userService.getUser(Integer.parseInt(userID));
        model.addAttribute("userFullName", user.getTitle() + " " + user.getForename() + " " + user.getSurname());
        return "user-details";
    }*/
    @RequestMapping(value = "/user-details", method = RequestMethod.GET)
    protected String userDetailsUpdate(@RequestParam(value = "user", required = false) String userID, @RequestParam(required = false) String created, Model model) throws Exception {
        if (userID != null) {
            User user = userService.getUser(Integer.parseInt(userID));
            model.addAttribute("created", created);
            model.addAttribute("user", user);
            model.addAttribute("userFullName", user.getTitle() + " " + user.getForename() + " " + user.getSurname());
        }
        return "user-details";
    }

//    @RequestMapping(value = "/user/{userID}", method = RequestMethod.GET)
//    protected String userDetails(@PathVariable String userID, Model model) throws Exception {
//        User user = userService.getUser(Integer.parseInt(userID));
//        model.addAttribute("user", user);
//        model.addAttribute("userFullName", user.getTitle() + " " + user.getForename() + " " + user.getSurname());
//        return "user-details";
//    }
}
