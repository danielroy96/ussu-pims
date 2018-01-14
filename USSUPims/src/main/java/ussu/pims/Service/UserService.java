/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ussu.pims.Service;

import java.util.List;
import ussu.pims.Model.User;
import ussu.pims.DAO.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

/**
 *
 * @author danielroy
 */
@Service
public class UserService implements UserDetailsService{

    @Autowired
    UserDAO userDAO;
    
    /**
     * Default constructor required by spring
     */
    public UserService() {

    }
    
    /**
     * Loads a user by username. Required for the authentication provider
     * 
     * @param username
     * @return
     */
    @Override
    public User loadUserByUsername (String username) {
        User user = userDAO.getUserByUsername(username);
        return userDAO.getUserByUsername(username);
    }
    
    
    public List<User> searchUsers(String forename, String surname) {
        return userDAO.searchUsers(forename, surname);
        
    }

}
