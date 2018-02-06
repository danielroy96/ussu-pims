/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ussu.pims.Mapper;

import ussu.pims.Model.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author danielroy
 */
public class UserMapper implements RowMapper<User> {
    
    /**
     * Maps a row of SQL query result to a user object
     * 
     * @param resultSet the results of the SQL query
     * @param row the row number
     * @return a user object
     * @throws SQLException
     */
    @Override
    public User mapRow(ResultSet resultSet, int row) throws SQLException {
        
        return new User(
                resultSet.getInt("user_id"),
                resultSet.getString("created_by_user"),
                resultSet.getString("start_datetime"),
                resultSet.getString("end_datetime"),
                resultSet.getString("user_status"),
                resultSet.getString("username"),
                resultSet.getString("password"),
                resultSet.getString("forename"),
                resultSet.getString("surname"),
                resultSet.getString("title"),
                resultSet.getString("user_type"),
                resultSet.getString("last_changed_by_user"),
                resultSet.getString("user_role")
        );
    }
    
}
