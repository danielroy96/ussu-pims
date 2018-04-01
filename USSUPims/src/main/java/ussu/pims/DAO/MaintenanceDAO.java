/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ussu.pims.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

/**
 *
 * @author danielroy
 */
@Repository
public class MaintenanceDAO {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    public int maintainItem(final int itemID, final String description, final int userID) {
        final String SQL = ""
                + "INSERT INTO pims.maintenance ("
                + "  item_id"
                + ", description"
                + ", maintenance_user_id"
                + ") VALUES ("
                + "  ?"
                + ", ?"
                + ", ?"
                + ")";
                KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(
                new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement preparedStatement = connection.prepareStatement(SQL, new String[]{"id"});
                preparedStatement.setInt(1, itemID);
                preparedStatement.setString(2, description);
                preparedStatement.setInt(3, userID);
                return preparedStatement;
            }
        }, keyHolder
        );
        return keyHolder.getKey().intValue();
    }
    
}
