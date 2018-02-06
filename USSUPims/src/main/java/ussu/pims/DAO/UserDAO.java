/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ussu.pims.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import ussu.pims.Model.User;
import ussu.pims.Mapper.UserMapper;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
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

    @Autowired
    private PasswordEncoder passwordEncoder;

    /**
     * Default constructor required by Spring
     */
    public UserDAO() {

    }

    /**
     * Sets the datasource for the DAO
     *
     * @param dataSource the datasource for the database
     */
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    ;
    
    /**
     * Gets a user object
     * 
     * @param username
     * @return the user object
     */
    public User getUserByUsername(String username) {
        String SQL
                = "SELECT\n"
                + "  u.id user_id\n"
                + ", CONCAT(udc.title, ' ', udc.forename, ' ', udc.surname) created_by_user\n"
                + ", DATE_FORMAT(ud.start_datetime, '%H:%i %d/%m/%Y') start_datetime\n"
                + ", DATE_FORMAT(ud.end_datetime, '%H:%i %d/%m/%Y') end_datetime\n"
                + ", us.display_text user_status\n"
                + ", ud.username\n"
                + ", ud.password\n"
                + ", ud.forename\n"
                + ", ud.surname\n"
                + ", ud.title\n"
                + ", ut.type_mnem user_type\n"
                + ", CONCAT(udl.title, ' ', udl.forename, ' ', udl.surname) last_changed_by_user\n"
                + ", ud.user_role\n"
                + "FROM pims.users u\n"
                + "JOIN pims.user_details_current_extant ud ON u.id = ud.user_id \n"
                + "JOIN pims.users uc ON u.created_by_user_id = uc.id\n"
                + "JOIN pims.user_details udc ON uc.id = udc.user_id AND udc.status_control = 'C'\n"
                + "JOIN pims.user_statuses us ON ud.status = us.status_mnem\n"
                + "JOIN pims.user_types ut ON ud.user_type = ut.type_mnem\n"
                + "JOIN pims.user_details udl ON ud.last_changed_by_user_id = udl.user_id AND udl.status_control = 'C'\n"
                + "WHERE ud.username = ?\n";
        User user = jdbcTemplate.queryForObject(SQL, new Object[]{username}, new UserMapper());
        return user;
    }

    public User getUser(int userID) {
        String SQL
                = "SELECT\n"
                + "  u.id user_id\n"
                + ", CONCAT(udc.title, ' ', udc.forename, ' ', udc.surname) created_by_user\n"
                + ", DATE_FORMAT(ud.start_datetime, '%H:%i %d/%m/%Y') start_datetime\n"
                + ", DATE_FORMAT(ud.end_datetime, '%H:%i %d/%m/%Y') end_datetime\n"
                + ", us.display_text user_status\n"
                + ", ud.username\n"
                + ", ud.password\n"
                + ", ud.forename\n"
                + ", ud.surname\n"
                + ", ud.title\n"
                + ", ut.type_mnem user_type\n"
                + ", CONCAT(udl.title, ' ', udl.forename, ' ', udl.surname) last_changed_by_user\n"
                + ", ud.user_role\n"
                + "FROM pims.users u\n"
                + "JOIN pims.user_details ud ON u.id = ud.user_id AND ud.status_control = 'C'\n"
                + "JOIN pims.users uc ON u.created_by_user_id = uc.id\n"
                + "JOIN pims.user_details udc ON uc.id = udc.user_id AND udc.status_control = 'C'\n"
                + "JOIN pims.user_statuses us ON ud.status = us.status_mnem\n"
                + "JOIN pims.user_types ut ON ud.user_type = ut.type_mnem\n"
                + "JOIN pims.user_details udl ON ud.last_changed_by_user_id = udl.user_id AND udl.status_control = 'C'\n"
                + "WHERE u.id = ?\n";
        User user = jdbcTemplate.queryForObject(SQL, new Object[]{userID}, new UserMapper());
        return user;
    }

    public List<User> searchUsers(String forename, String surname) {
        String SQL
                = "SELECT\n"
                + "  u.id user_id\n"
                + ", CONCAT(udc.title, ' ', udc.forename, ' ', udc.surname) created_by_user\n"
                + ", DATE_FORMAT(ud.start_datetime, '%H:%i %d/%m/%Y') start_datetime\n"
                + ", DATE_FORMAT(ud.end_datetime, '%H:%i %d/%m/%Y') end_datetime\n"
                + ", us.display_text user_status\n"
                + ", ud.username\n"
                + ", ud.password\n"
                + ", ud.forename\n"
                + ", ud.surname\n"
                + ", ud.title\n"
                + ", ut.type_mnem user_type\n"
                + ", CONCAT(udl.title, ' ', udl.forename, ' ', udl.surname) last_changed_by_user\n"
                + ", ud.user_role\n"
                + "FROM pims.users u\n"
                + "JOIN pims.user_details ud ON u.id = ud.user_id AND ud.status_control = 'C'\n"
                + "JOIN pims.users uc ON u.created_by_user_id = uc.id\n"
                + "JOIN pims.user_details udc ON uc.id = udc.user_id AND udc.status_control = 'C'\n"
                + "JOIN pims.user_statuses us ON ud.status = us.status_mnem\n"
                + "JOIN pims.user_types ut ON ud.user_type = ut.type_mnem\n"
                + "JOIN pims.user_details udl ON ud.last_changed_by_user_id = udl.user_id AND udl.status_control = 'C'\n"
                + "WHERE ud.forename LIKE CONCAT('%', ?, '%')\n"
                + "AND ud.surname LIKE CONCAT('%', ?, '%')\n"
                + "AND ud.status != 'DELETED'"
                + "ORDER BY ud.username ASC";
        return jdbcTemplate.query(SQL, new UserMapper(), forename, surname);
    }

    public void resetPassword(int userID, int currentUserID, String newPassword) {
        String userDetailIDSQL = "SELECT ud.id FROM pims.user_details ud WHERE ud.user_id = ? AND ud.status_control = 'C'";
        int userDetailID = Integer.parseInt((String) jdbcTemplate.queryForObject(userDetailIDSQL, new Object[]{userID}, String.class));
        String invalidateOldDetailSQL = "UPDATE pims.user_details ud SET ud.status_control = NULL, ud.end_datetime = NOW() WHERE ud.id = ?";
        jdbcTemplate.update(invalidateOldDetailSQL, userDetailID);
        String newDetailRowSQL = ""
                + "INSERT INTO pims.user_details ("
                + "  user_id"
                + ", start_datetime"
                + ", status_control"
                + ", status"
                + ", username"
                + ", password"
                + ", forename"
                + ", surname"
                + ", title"
                + ", user_role"
                + ", user_type"
                + ", last_changed_by_user_id) "
                + "SELECT"
                + "  ud.user_id"
                + ", NOW()"
                + ", 'C'"
                + ", ud.status"
                + ", ud.username"
                + ", ?"
                + ", ud.forename"
                + ", ud.surname"
                + ", ud.title"
                + ", ud.user_role"
                + ", ud.user_type"
                + ", ? "
                + "FROM pims.user_details ud "
                + "WHERE ud.id = ?";
        jdbcTemplate.update(newDetailRowSQL, passwordEncoder.encode(newPassword), currentUserID, userDetailID);
    }

    public void updateUser(int currentUserID, int userID, String title, String forename, String surname, String userType, String userRole) {
        String userDetailIDSQL = "SELECT ud.id FROM pims.user_details ud WHERE ud.user_id = ? AND ud.status_control = 'C'";
        int userDetailID = Integer.parseInt((String) jdbcTemplate.queryForObject(userDetailIDSQL, new Object[]{userID}, String.class));
        String invalidateOldDetailSQL = "UPDATE pims.user_details ud SET ud.status_control = NULL, ud.end_datetime = NOW() WHERE ud.id = ?";
        jdbcTemplate.update(invalidateOldDetailSQL, userDetailID);
        String newDetailRowSQL = ""
                + "INSERT INTO pims.user_details ("
                + "  user_id"
                + ", start_datetime"
                + ", status_control"
                + ", status"
                + ", username"
                + ", password"
                + ", forename"
                + ", surname"
                + ", title"
                + ", user_role"
                + ", user_type"
                + ", last_changed_by_user_id) "
                + "SELECT"
                + "  ud.user_id"
                + ", NOW()"
                + ", 'C'"
                + ", ud.status"
                + ", ud.username"
                + ", ud.password"
                + ", ?"
                + ", ?"
                + ", ?"
                + ", ?"
                + ", ?"
                + ", ? "
                + "FROM pims.user_details ud "
                + "WHERE ud.id = ?";
        jdbcTemplate.update(newDetailRowSQL, forename, surname, title, userRole, userType, currentUserID, userDetailID);
    }

    public void deleteUser(int currentUserID, int userID) {
        String userDetailIDSQL = "SELECT ud.id FROM pims.user_details ud WHERE ud.user_id = ? AND ud.status_control = 'C'";
        int userDetailID = Integer.parseInt((String) jdbcTemplate.queryForObject(userDetailIDSQL, new Object[]{userID}, String.class));
        String invalidateOldDetailSQL = "UPDATE pims.user_details ud SET ud.status_control = NULL, ud.end_datetime = NOW() WHERE ud.id = ?";
        jdbcTemplate.update(invalidateOldDetailSQL, userDetailID);
        String newDetailRowSQL = ""
                + "INSERT INTO pims.user_details ("
                + "  user_id"
                + ", start_datetime"
                + ", status_control"
                + ", status"
                + ", username"
                + ", password"
                + ", forename"
                + ", surname"
                + ", title"
                + ", user_role"
                + ", user_type"
                + ", last_changed_by_user_id) "
                + "SELECT"
                + "  ud.user_id"
                + ", NOW()"
                + ", 'C'"
                + ", 'DELETED'"
                + ", ud.username"
                + ", ud.password"
                + ", ud.forename"
                + ", ud.surname"
                + ", ud.title"
                + ", ud.user_role"
                + ", ud.user_type"
                + ", ? "
                + "FROM pims.user_details ud "
                + "WHERE ud.id = ?";
        jdbcTemplate.update(newDetailRowSQL, currentUserID, userDetailID);
    }

    public Number createUser(final int currentUserID, String username, String password, String title, String forename, String surname, String userType, String userRole) {
        final String createUserRowSQL = "INSERT INTO pims.users ("
                + "  created_by_user_id) "
                + "VALUES ("
                + "  ?"
                + ");";
        String createUserDetailRowSQL = "INSERT INTO pims.user_details ("
                + "  user_id"
                + ", start_datetime"
                + ", status_control"
                + ", status"
                + ", username"
                + ", password"
                + ", forename"
                + ", surname"
                + ", title"
                + ", user_role"
                + ", user_type"
                + ", last_changed_by_user_id) "
                + "VALUES ("
                + "  ?"
                + ", NOW()"
                + ", 'C'"
                + ", 'CURRENT'"
                + ", ?"
                + ", ?"
                + ", ?"
                + ", ?"
                + ", ?"
                + ", ?"
                + ", ?"
                + ", ?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(
                new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement pst
                        = connection.prepareStatement(createUserRowSQL, new String[]{"id"});
                pst.setInt(1, currentUserID);
                return pst;
            }
        }, keyHolder);
        jdbcTemplate.update(createUserDetailRowSQL, keyHolder.getKey(), username, passwordEncoder.encode(password), forename, surname, title, userRole, userType, currentUserID);
        return keyHolder.getKey();
    }

}
