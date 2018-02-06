/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ussu.pims.Service;

import java.security.Principal;
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
        return userDAO.getUserByUsername(username);
    }
    
    public int getUserID(Principal principal) {
        return loadUserByUsername(principal.getName()).getId();
    }
    
    public User getUser (int userID) {
        return userDAO.getUser(userID);
    }
    
    public void resetPassword(int userID, int currentUserID, String newPassword) {
        userDAO.resetPassword(userID, currentUserID, newPassword);
    }
    
    public List<User> searchUsers(String forename, String surname) {
        return userDAO.searchUsers(forename, surname);
        
    }
    
    public Number createUser(int currentUserID, String username, String password, String title, String forename, String surname, String userType, String userRole) {
        return userDAO.createUser(currentUserID,username, password, title, forename, surname, userType, userRole);
    }
    
    public void updateUser(int currentUserID, int userID, String title, String forename, String surname, String userType, String userRole) {
        userDAO.updateUser(currentUserID, userID, title, forename, surname, userType, userRole);
    }
    
    public void deleteUser(int currentUserID, int userID) {
        userDAO.deleteUser(currentUserID, userID);
    }

}
