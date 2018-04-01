/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ussu.pims.Mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import ussu.pims.Model.ItemType;

/**
 *
 * @author danielroy
 */
public class ItemTypeMapper implements RowMapper<ItemType>{

    @Override
    public ItemType mapRow(ResultSet resultSet, int i) throws SQLException {
        return new ItemType(
                resultSet.getInt("id"),
                resultSet.getString("name"),
                resultSet.getFloat("value"),
                resultSet.getFloat("weight"),
                resultSet.getString("requires_pat"),
                resultSet.getInt("pat_interval_months"),
                resultSet.getString("created_by_user_fullname"),
                resultSet.getString("last_changed_by_user_fullname")
        );
    }
    
}
