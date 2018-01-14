/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ussu.pims.DAO;

import java.util.List;
import ussu.pims.Model.User;
import ussu.pims.Mapper.UserMapper;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 *
 * @author danielroy
 */
@Repository
public class UserDAO {
    
    @Autowired
    private DataSource dataSource;
    
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    /**
     * Default constructor required by Spring
     */
    public UserDAO () {
        
    }
    
    /**
     * Sets the datasource for the DAO
     * 
     * @param dataSource the datasource for the database
     */
    public void setDataSource (DataSource dataSource){
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    };
    
    /**
     * Gets a user object
     * 
     * @param username
     * @return the user object
     */
    public User getUserByUsername (String username) {
        String SQL = 
"SELECT\n" +
"  u.id user_id\n" +
", CONCAT(udc.title, ' ', udc.forename, ' ', udc.surname) created_by_user\n" +
", ud.start_datetime\n" +
", ud.end_datetime\n" +
", us.display_text user_status\n" +
", ud.username\n" +
", ud.password\n" +
", ud.forename\n" +
", ud.surname\n" +
", ud.title\n" +
", ut.display_text user_type\n" +
", CONCAT(udl.title, ' ', udl.forename, ' ', udl.surname) last_changed_by_user\n" +
", ud.user_role\n" +
"FROM pims.users u\n" +
"JOIN pims.user_details ud ON u.id = ud.user_id AND ud.status_control = 'C'\n" +
"JOIN pims.users uc ON u.created_by_user_id = uc.id\n" +
"JOIN pims.user_details udc ON uc.id = udc.user_id AND udc.status_control = 'C'\n" +
"JOIN pims.user_statuses us ON ud.status = us.status_mnem\n" +
"JOIN pims.user_types ut ON ud.user_type = ut.type_mnem\n" +
"JOIN pims.user_details udl ON ud.last_changed_by_user_id = udl.user_id AND udl.status_control = 'C'\n" +
"WHERE ud.username = ?\n";
        User user = jdbcTemplate.queryForObject(SQL, new Object[] {username}, new UserMapper());
        return user;
    }
   
    public List<User> searchUsers (String forename, String surname) {
        String SQL = 
"SELECT\n" +
"  u.id user_id\n" +
", CONCAT(udc.title, ' ', udc.forename, ' ', udc.surname) created_by_user\n" +
", ud.start_datetime\n" +
", ud.end_datetime\n" +
", us.display_text user_status\n" +
", ud.username\n" +
", ud.password\n" +
", ud.forename\n" +
", ud.surname\n" +
", ud.title\n" +
", ut.display_text user_type\n" +
", CONCAT(udl.title, ' ', udl.forename, ' ', udl.surname) last_changed_by_user\n" +
", ud.user_role\n" +
"FROM pims.users u\n" +
"JOIN pims.user_details ud ON u.id = ud.user_id AND ud.status_control = 'C'\n" +
"JOIN pims.users uc ON u.created_by_user_id = uc.id\n" +
"JOIN pims.user_details udc ON uc.id = udc.user_id AND udc.status_control = 'C'\n" +
"JOIN pims.user_statuses us ON ud.status = us.status_mnem\n" +
"JOIN pims.user_types ut ON ud.user_type = ut.type_mnem\n" +
"JOIN pims.user_details udl ON ud.last_changed_by_user_id = udl.user_id AND udl.status_control = 'C'\n" +
"WHERE ud.forename LIKE CONCAT('%', ?, '%')\n" +
"AND ud.surname LIKE CONCAT('%', ?, '%')";
        return jdbcTemplate.query(SQL, new UserMapper(), forename, surname);
    }
    
}
