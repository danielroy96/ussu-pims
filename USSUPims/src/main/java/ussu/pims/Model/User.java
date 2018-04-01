/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ussu.pims.Model;

import java.util.ArrayList;
import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 *
 * @author danielroy
 */
public class User implements UserDetails {
    
    private int id;
    private String created_by_user;
    private String start_datetime;
    private String end_datetime;
    private String status;
    private String username;
    private String password;
    private String forename;
    private String surname;
    private String title;
    private String type;
    private String last_changed_by_user;
    private String role;
    private ArrayList<SimpleGrantedAuthority> authorities;
    
    /**
     * Constructor to build a new user object
     * 
     * @param id
     * @param username
     * @param password
     * @param role
     */
    public User (int id, String created_by_user, String start_datetime, String end_datetime, String status, String username, String password, String forename, String surname, String title, String type, String last_changed_by_user, String role) {
        this.authorities = new ArrayList<SimpleGrantedAuthority>();
        this.id = id;
        this.created_by_user = created_by_user;
        this.start_datetime = start_datetime;
        this.end_datetime = end_datetime;
        this.status = status;
        this.username = username;
        this.password = password;
        this.forename = forename;
        this.surname = surname;
        this.title = title;
        this.type = type;
        this.last_changed_by_user = last_changed_by_user;
        this.role = role;
        authorities.add(new SimpleGrantedAuthority(role));//"ROLE_USER"
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCreated_by_user() {
        return created_by_user;
    }

    public void setCreated_by_user(String created_by_user) {
        this.created_by_user = created_by_user;
    }

    public String getStart_datetime() {
        return start_datetime;
    }

    public void setStart_datetime(String start_datetime) {
        this.start_datetime = start_datetime;
    }

    public String getEnd_datetime() {
        return end_datetime;
    }

    public void setEnd_datetime(String end_datetime) {
        this.end_datetime = end_datetime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getForename() {
        return forename;
    }

    public void setForename(String forename) {
        this.forename = forename;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getLast_changed_by_user() {
        return last_changed_by_user;
    }

    public void setLast_changed_by_user(String last_changed_by_user) {
        this.last_changed_by_user = last_changed_by_user;
    }
    
    public String getUserFullname() {
        return title + " " + forename + " " + surname;
    }

    /**
     *
     * @return
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    /**
     *
     * @return
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     *
     * @return
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     *
     * @return
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     *
     * @return
     */
    @Override
    public boolean isEnabled() {
        return true;
    }
}
