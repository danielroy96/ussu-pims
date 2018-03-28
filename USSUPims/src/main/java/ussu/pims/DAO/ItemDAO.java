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
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import ussu.pims.Mapper.ItemMapper;
import ussu.pims.Model.Item;

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

    public Item getItem(String barcode) {
        String SQL = ""
                + "SELECT"
                + "  i.id id"
                + ", i.created_by_user_id created_by_user_id"
                + ", CONCAT(udcc.title, ' ', udcc.forename, ' ', udcc.surname) created_by_user_fullname "
                + ", DATE_FORMAT(i.created_datetime, '%H:%i %d/%m/%Y') created_datetime"
                + ", DATE_FORMAT(idce.start_datetime, '%H:%i %d/%m/%Y') last_changed_datetime"
                + ", idce.last_changed_by_user_id last_changed_by_user_id"
                + ", CONCAT(udcl.title, ' ', udcl.forename, ' ', udcl.surname) last_changed_by_user_fullname"
                + ", idce.barcode barcode"
                + ", idce.description description"
                + ", it.id item_type_id"
                + ", it.name item_type_name"
                + ", it.value value"
                + ", it.weight weight"
                + ", it.requires_pat requires_pat"
                + ", it.pat_interval_months pat_interval_months "
                + "FROM pims.items i "
                + "JOIN pims.item_details_current_extant idce ON i.id = idce.item_id "
                + "JOIN pims.item_types it ON idce.item_type = it.id "
                + "JOIN pims.user_details_current udcc ON udcc.user_id = i.created_by_user_id "
                + "JOIN pims.user_details_current udcl ON udcl.user_id = idce.last_changed_by_user_id "
                + "WHERE idce.barcode = ?";
        return jdbcTemplate.query(SQL, new ItemMapper(), barcode).get(0);
    }

    public List<Item> quickSearch(String searchTerm) {
        String SQL = ""
                + "SELECT"
                + "  i.id id"
                + ", i.created_by_user_id created_by_user_id"
                + ", CONCAT(udcc.title, ' ', udcc.forename, ' ', udcc.surname) created_by_user_fullname "
                + ", DATE_FORMAT(i.created_datetime, '%H:%i %d/%m/%Y') created_datetime"
                + ", DATE_FORMAT(idce.start_datetime, '%H:%i %d/%m/%Y') last_changed_datetime"
                + ", idce.last_changed_by_user_id last_changed_by_user_id"
                + ", CONCAT(udcl.title, ' ', udcl.forename, ' ', udcl.surname) last_changed_by_user_fullname"
                + ", idce.barcode barcode"
                + ", idce.description description"
                + ", it.id item_type_id"
                + ", it.name item_type_name"
                + ", it.value value"
                + ", it.weight weight"
                + ", it.requires_pat requires_pat"
                + ", it.pat_interval_months pat_interval_months "
                + "FROM pims.items i "
                + "JOIN pims.item_details_current_extant idce ON i.id = idce.item_id "
                + "JOIN pims.item_types it ON idce.item_type = it.id "
                + "JOIN pims.user_details_current udcc ON udcc.user_id = i.created_by_user_id "
                + "JOIN pims.user_details_current udcl ON udcl.user_id = idce.last_changed_by_user_id "
                + "WHERE UPPER(CONCAT(it.name, idce.barcode)) LIKE REPLACE(UPPER(CONCAT('%', ?, '%')), ' ', '%')";
        return jdbcTemplate.query(SQL, new ItemMapper(), searchTerm);
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
