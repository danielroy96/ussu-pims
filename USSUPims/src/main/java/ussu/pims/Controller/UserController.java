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
import org.springframework.stereotype.Controller;
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

    @RequestMapping(value = "/user/search/f={forename}/s={surname}", method = RequestMethod.GET)
    public List<User> searchUsers(@PathVariable("forename") String forename, @PathVariable("surname") String surname) {
        return userService.searchUsers(forename, surname);
    }
    
    @RequestMapping(value="/user/quicksearch", method = RequestMethod.GET)
    public List<User> quickSearchUsers(@RequestParam String searchTerm) {
        return userService.quickSearchUsers(searchTerm);
    }

    @RequestMapping(value = "user/{userID}/resetpassword/password={newPassword}", method = RequestMethod.GET)
    public ResponseEntity<Object> resetPassword(@PathVariable("userID") String userID, @PathVariable("newPassword") String newPassword, Principal principal) throws Exception {
        userService.resetPassword(Integer.parseInt(userID), userService.getUserID(principal), newPassword);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //public ResponseEntity<Object> createUser (@PathVariable String username)
    /**
     * Creates a new user
     *
     * @param username
     * @param password
     * @param title
     * @param forename
     * @param surname
     * @param userType
     * @param userRole
     * @param principal
     * @return 200
     * @throws Exception
     */
    @RequestMapping(value = "user", method = RequestMethod.PUT)
    public Number createUser(@RequestParam String username, @RequestParam String password, @RequestParam String title, @RequestParam String forename, @RequestParam String surname, @RequestParam String userType, @RequestParam String userRole, Principal principal) throws Exception {
        return userService.createUser(userService.getUserID(principal), username, password, title, forename, surname, userType, userRole);
    }

    @RequestMapping(value = "user/{userID}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateUser(@PathVariable String userID, @RequestParam String title, @RequestParam String forename, @RequestParam String surname, @RequestParam String userType, @RequestParam String userRole, Principal principal) {
        userService.updateUser(userService.getUserID(principal), Integer.parseInt(userID), title, forename, surname, userType, userRole);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value="user/{userID}", method=RequestMethod.DELETE)
    public ResponseEntity<Object> deleteUser(@PathVariable String userID, Principal principal) {
        userService.deleteUser(userService.getUserID(principal), Integer.parseInt(userID));
        return new ResponseEntity<>(HttpStatus.OK);
    }
    /**
     * Removes a user
     *
     * @param username
     * @return 200
     * @throws Exception
     *
     * @RequestMapping(value="/user/remove/{username}",
     * method=RequestMethod.POST) public ResponseEntity<Object> removeUser
     * (@PathVariable("username") String username) throws Exception {
     * userService.removeUser(username); return new
     * ResponseEntity<>(HttpStatus.OK); }
     *
     *
     */
}
