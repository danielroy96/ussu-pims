/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ussu.pims.Controller;

import java.security.Principal;
import java.util.List;
import ussu.pims.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ussu.pims.Model.User;

/**
 *
 * @author danielroy
 */
@Controller
@RestController
public class UserController {

    @Autowired
    private UserService userService;
    
    @RequestMapping(value="/user/search/f={forename}/s={surname}", method=RequestMethod.GET)
    public List<User> searchUsers (@PathVariable("forename") String forename, @PathVariable("surname") String surname) {
        return userService.searchUsers(forename, surname);
    }
    
    /**
     * Creates a new user
     * 
     * @param username
     * @param password
     * @return 200
     * @throws Exception
     
    @RequestMapping(value="/user/create/{username}/{password}", method = RequestMethod.POST)
    public ResponseEntity<Object> createUser(@PathVariable("username") String username, @PathVariable("password") String password) throws Exception {
        userService.createUser(username, password);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    * 
    * */
    
    /**
     * Removes a user
     * @param username
     * @return 200
     * @throws Exception
     
    @RequestMapping(value="/user/remove/{username}", method=RequestMethod.POST)
    public ResponseEntity<Object> removeUser (@PathVariable("username") String username) throws Exception {
        userService.removeUser(username);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    * 
    * */

}
