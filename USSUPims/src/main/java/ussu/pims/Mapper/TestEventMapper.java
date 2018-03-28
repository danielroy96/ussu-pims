/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ussu.pims.Mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import ussu.pims.Model.TestEvent;

/**
 *
 * @author danielroy
 */
public class TestEventMapper implements RowMapper<TestEvent> {

    @Override
    public TestEvent mapRow(ResultSet resultSet, int i) throws SQLException {
        
        return new TestEvent(
                resultSet.getInt("id"),
                resultSet.getString("mnem"),
                resultSet.getString("display_text"),
                resultSet.getString("event_datetime"),
                resultSet.getString("event_user_fullname"),
                resultSet.getFloat("earth_resistance_ohms"),
                resultSet.getFloat("insulation_resistance_mohms")
        );
        
    }
    
}
