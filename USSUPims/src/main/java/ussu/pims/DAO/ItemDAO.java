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
import org.springframework.dao.EmptyResultDataAccessException;
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
public class ItemDAO {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int getItemID(String barcode) {
        String SQL = ""
                + "SELECT"
                + "  idc.item_id "
                + "FROM pims.item_details_current idc "
                + "WHERE idc.barcode = ?";
        System.out.println(SQL);
        return jdbcTemplate.queryForObject(SQL, new Object[]{barcode}, Integer.class);
    }

    public Number addItem(String barcode, String description, int itemType, final int userID) {
        final String createItemRowSQL = ""
                + "INSERT INTO pims.items ("
                + "  created_by_user_id"
                + ", created_datetime"
                + ") VALUES ("
                + "  ?"
                + ", NOW()"
                + ")";
        String createItemDetailRowSQL = ""
                + "INSERT INTO pims.item_details ("
                + "  item_id"
                + ", start_datetime"
                + ", status_control"
                + ", status"
                + ", last_changed_by_user_id"
                + ", barcode"
                + ", description"
                + ", item_type"
                + ") VALUES ("
                + "  ?"
                + ", NOW()"
                + ", 'C'"
                + ", 'CURRENT'"
                + ", ?"
                + ", ?"
                + ", ?"
                + ", ?"
                + ")";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(
                new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement preparedStatement = connection.prepareStatement(createItemRowSQL, new String[]{"id"});
                preparedStatement.setInt(1, userID);
                return preparedStatement;
            }
        }, keyHolder
        );
        jdbcTemplate.update(createItemDetailRowSQL, keyHolder.getKey(), userID, barcode, description, itemType);
        return keyHolder.getKey();
    }

    public boolean checkItemBarcode(String barcode) {
        String SQL = ""
                + "SELECT"
                + "  'true'"
                + "FROM pims.item_details_current_extant idce "
                + "WHERE idce.barcode = ?";

        String exists;

        try {

            exists = jdbcTemplate.queryForObject(SQL, new Object[]{barcode}, String.class);
        } catch (EmptyResultDataAccessException e) {
            exists = "false";
        }

        return exists.equals("true");

    }

    public void updateItem(int itemID, String barcode, String description, int itemType, int userID) {
        String invalidateOldItemDetailRowSQL = "UPDATE pims.item_details_current idc SET idc.status_control = NULL, idc.end_datetime = NOW() WHERE idc.item_id = ?";
        String newItemDetailRowSQL = ""
                + "INSERT INTO pims.item_details ("
                + "  item_id"
                + ", start_datetime"
                + ", status_control"
                + ", status"
                + ", last_changed_by_user_id"
                + ", barcode"
                + ", description"
                + ", item_type"
                + ") VALUES ("
                + "  ?"
                + ", NOW()"
                + ", 'C'"
                + ", 'CURRENT'"
                + ", ?"
                + ", ?"
                + ", ?"
                + ", ?"
                + ")";
        jdbcTemplate.update(invalidateOldItemDetailRowSQL, itemID);
        jdbcTemplate.update(newItemDetailRowSQL, itemID, userID, barcode, description, itemType);
    }

    public void updateItemStatus(int itemID, String newItemStatus, int userID) {

    }

}
