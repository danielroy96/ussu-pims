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
import ussu.pims.Mapper.ItemTypeMapper;
import ussu.pims.Model.ItemType;
import ussu.pims.Service.UserService;

/**
 *
 * @author danielroy
 */
@Repository
public class ItemTypeDAO {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    @Autowired
    private UserService userService;

    public List<ItemType> quickSearch(String searchTerm) {
        String SQL = ""
                + "SELECT"
                + "  it.id"
                + ", it.name"
                + ", it.value"
                + ", it.weight"
                + ", it.requires_pat"
                + ", it.pat_interval_months"
                + ", CONCAT(udcc.title, ' ', udcc.forename, ' ', udcc.surname) created_by_user_fullname"
                + ", CONCAT(udcl.title, ' ', udcl.forename, ' ', udcl.surname) last_changed_by_user_fullname "
                + "FROM pims.item_types it "
                + "JOIN pims.user_details_current udcc ON it.created_by_user_id = udcc.user_id "
                + "JOIN pims.user_details_current udcl ON it.last_changed_by_user_id = udcl.user_id "
                + "WHERE UPPER(it.name) LIKE UPPER(CONCAT('%', ?,'%'))";
        return jdbcTemplate.query(SQL, new ItemTypeMapper(), searchTerm);
    }

    public ItemType addItemType(final String name, final Float value, final Float weight, final String requiresPAT, final Integer PATIntervalMonths, final int userID) {
        final String SQL = ""
                + "INSERT INTO pims.item_types ("
                + "  name"
                + ", value"
                + ", weight"
                + ", requires_pat"
                + ", pat_interval_months"
                + ", created_by_user_id"
                + ", last_changed_by_user_id"
                + ") VALUES ("
                + "  ?"
                + ", ?"
                + ", ?"
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
                PreparedStatement preparedStatement = connection.prepareStatement(SQL, new String[]{"id"});
                preparedStatement.setString(1, name);
                if (value != null) {
                    preparedStatement.setFloat(2,value);
                }
                else {
                    preparedStatement.setNull(2,Types.FLOAT);
                }
                if (weight != null) {
                    preparedStatement.setFloat(3, weight);
                } else {
                    preparedStatement.setNull(3, Types.FLOAT);
                }
                preparedStatement.setString(4,requiresPAT);
                if (PATIntervalMonths != null) {
                    preparedStatement.setInt(5, PATIntervalMonths);
                } else {
                    preparedStatement.setNull(5, Types.INTEGER);
                }
                preparedStatement.setInt(6, userID);
                preparedStatement.setInt(7, userID);
                return preparedStatement;
            }
        }, keyHolder
        );
        return new ItemType(keyHolder.getKey().intValue(), name, value, weight, requiresPAT, PATIntervalMonths, userService.getUser(userID).getUserFullname(), userService.getUser(userID).getUserFullname());
    }

    public void updateItemType(int itemTypeID, String name, float value, float weight, String requiresPAT, int PATIntervalMonths, int userID) {
        String SQL = ""
                + "UPDATE pims.item_types it SET"
                + "  it.name = ?"
                + ", it.value = ?"
                + ", it.weight = ?"
                + ", it.requires_pat = ?"
                + ", it.pat_interval_months = ?"
                + ", it.last_changed_by_user_id = ? "
                + "WHERE it.id = ?";
        jdbcTemplate.update(SQL, name, value, weight, requiresPAT, PATIntervalMonths, userID, itemTypeID);
    }
}
