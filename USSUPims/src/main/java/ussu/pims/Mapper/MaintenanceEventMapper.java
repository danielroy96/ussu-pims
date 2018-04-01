/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ussu.pims.Mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import ussu.pims.Model.MaintenanceEvent;

/**
 *
 * @author danielroy
 */
public class MaintenanceEventMapper implements RowMapper<MaintenanceEvent>{

    @Override
    public MaintenanceEvent mapRow(ResultSet resultSet, int i) throws SQLException {
        return new MaintenanceEvent(
                resultSet.getInt("id"),
                resultSet.getString("mnem"),
                resultSet.getString("display_text"),
                resultSet.getString("event_datetime"),
                resultSet.getString("event_user_fullname"),
                resultSet.getString("description")
        );
    }
    
}
