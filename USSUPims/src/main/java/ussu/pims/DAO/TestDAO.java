/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ussu.pims.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.sql.DataSource;
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
public class TestDAO {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void testItem(final int itemID, final Float earthResistanceOhms, final Float insulationResistanceMOhms, final int userID) {
        final String testSQL = ""
                + "INSERT INTO pims.tests ("
                + "  item_id"
                + ", test_datetime"
                + ", test_user"
                + ", earth_resistance_ohms"
                + ", insulation_resistance_mohms"
                + ") VALUES ("
                + "  ?"
                + ", NOW()"
                + ", ?"
                + ", ?"
                + ", ?"
                + ")";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(
                new PreparedStatementCreator() {
                    @Override
                    public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                        PreparedStatement preparedStatement = connection.prepareStatement(testSQL, new String[]{"id"});
                        preparedStatement.setInt(1, itemID);
                        preparedStatement.setInt(2, userID);
                        preparedStatement.setFloat(3, earthResistanceOhms);
                        preparedStatement.setFloat(4, insulationResistanceMOhms);
                        return preparedStatement;
                    }
            }, keyHolder
        );
        String eventSQL = ""
                + "INSERT INTO pims.item_events ("
                + "  mnem"
                + ", display_text"
                + ", item_id"
                + ", event_datetime"
                + ", event_user_id"
                + ", test_id"
                + ") VALUES ("
                + "  'TEST'"
                + ", 'Item PAT tested'"
                + ", ?"
                + ", NOW()"
                + ", ?"
                + ", ?"
                + ")";
        jdbcTemplate.update(eventSQL, itemID, userID, keyHolder.getKey());
    }

}
