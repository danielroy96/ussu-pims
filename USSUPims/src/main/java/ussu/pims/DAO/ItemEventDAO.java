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
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import ussu.pims.Mapper.TestEventMapper;
import ussu.pims.Model.TestEvent;

/**
 *
 * @author danielroy
 */
@Repository
public class ItemEventDAO {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<TestEvent> getTestEvents(int itemID) {
        String SQL = ""
                + "SELECT"
                + "  ie.id"
                + ", ie.mnem"
                + ", ie.display_text"
                + ", DATE_FORMAT(ie.event_datetime, '%H:%i %d/%m/%Y') event_datetime"
                + ", CONCAT(udc.title, ' ', udc.forename, ' ', udc.surname) event_user_fullname"
                + ", t.earth_resistance_ohms "
                + ", t.insulation_resistance_mohms "
                + "FROM pims.item_events ie "
                + "JOIN pims.user_details_current udc ON udc.user_id = ie.event_user_id "
                + "JOIN pims.tests t ON ie.test_id = t.id "
                + "WHERE ie.test_id IS NOT NULL "
                + "AND ie.item_id = ? "
                + "ORDER BY ie.id DESC";
        return jdbcTemplate.query(SQL, new TestEventMapper(), itemID);
    }

    public Number logEvent(final String mnem, final String displayText, final int itemID, final int userID, final Integer testID, Integer maintenanceID) {
        final String SQL = ""
                + "INSERT INTO pims.item_events ("
                + "  mnem"
                + ", display_text"
                + ", item_id"
                + ", event_datetime"
                + ", event_user_id"
                + ", test_id"
                + ") VALUES ("
                + "  ?"
                + ", ?"
                + ", ?"
                + ", NOW()"
                + ", ?"
                + ", ?"
                + ")";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(
                new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement preparedStatement = connection.prepareStatement(SQL, new String[]{"id"});
                preparedStatement.setString(1, mnem);
                preparedStatement.setString(2, displayText);
                preparedStatement.setInt(3, itemID);
                preparedStatement.setInt(4, userID);
                if (testID != null) {
                    preparedStatement.setInt(5, testID);
                } else {
                    preparedStatement.setNull(5, Types.INTEGER);
                }
                return preparedStatement;
            }
        }, keyHolder
        );
        return keyHolder.getKey();
    }

}
