/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ussu.pims.Mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import ussu.pims.Model.Item;

/**
 *
 * @author danielroy
 */
public class ItemMapper implements RowMapper<Item> {

    @Override
    public Item mapRow(ResultSet resultSet, int i) throws SQLException {
        return new Item (
                resultSet.getInt("id"),
                resultSet.getInt("created_by_user_id"),
                resultSet.getString("created_by_user_fullname"),
                resultSet.getString("created_datetime"),
                resultSet.getString("last_changed_datetime"),
                resultSet.getInt("last_changed_by_user_id"),
                resultSet.getString("last_changed_by_user_fullname"),
                resultSet.getString("barcode"),
                resultSet.getString("description"),
                resultSet.getInt("item_type_id"),
                resultSet.getString("item_type_name"),
                resultSet.getFloat("value"),
                resultSet.getFloat("weight"),
                resultSet.getBoolean("requires_pat"),
                resultSet.getInt("pat_interval_months")
        );
    }
    
}
