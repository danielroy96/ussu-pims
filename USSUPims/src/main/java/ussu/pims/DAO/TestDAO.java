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
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import ussu.pims.Mapper.TestMapper;
import ussu.pims.Model.Test;

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

    public Number testItem(final int itemID, final Float earthResistanceOhms, final Float insulationResistanceMOhms, final int testOperatorUserID) {
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
                preparedStatement.setInt(2, testOperatorUserID);
                if (earthResistanceOhms != null) {
                    preparedStatement.setFloat(3, earthResistanceOhms);
                } else {
                    preparedStatement.setNull(3, Types.FLOAT);
                }
                if (insulationResistanceMOhms != null) {
                    preparedStatement.setFloat(4, insulationResistanceMOhms);
                } else {
                    preparedStatement.setNull(4, Types.FLOAT);
                }
                return preparedStatement;
            }
        }, keyHolder
        );
        return keyHolder.getKey();
        /*String eventSQL = ""
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
        jdbcTemplate.update(eventSQL, itemID, testOperatorUserID, keyHolder.getKey());*/
    }

    /*public void testItem(final int itemID, final int testOperatorUserID) {
        final String testSQL = ""
                + "INSERT INTO pims.tests ("
                + "  item_id"
                + ", test_datetime"
                + ", test_user"
                + ") VALUES ("
                + "  ?"
                + ", NOW()"
                + ", ?"
                + ")";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(
                new PreparedStatementCreator() {
                    @Override
                    public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                        PreparedStatement preparedStatement = connection.prepareStatement(testSQL, new String[]{"id"});
                        preparedStatement.setInt(1, itemID);
                        preparedStatement.setInt(2, testOperatorUserID);
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
        jdbcTemplate.update(eventSQL, itemID, testOperatorUserID, keyHolder.getKey());
    }
     */
    public Test getLatestTest(int itemID) {
        String SQL = ""
                + "SELECT\n"
                + "  tl.id\n"
                + ", tl.item_id\n"
                + ", DATE_FORMAT(tl.test_datetime, '%H:%i %d/%m/%Y') test_datetime\n"
                + ", CONCAT(udc.title, ' ', udc.forename, ' ', udc.surname) test_user_fullname\n"
                + "FROM pims.tests_latest tl\n"
                + "JOIN pims.user_details_current udc ON tl.test_user = udc.user_id\n"
                + "WHERE tl.item_id = ?";
        return jdbcTemplate.query(SQL, new TestMapper(), itemID).get(0);
    }
}
