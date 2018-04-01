/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ussu.pims.Mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import ussu.pims.Model.ChartDataPoint;

/**
 *
 * @author danielroy
 */
public class ChartDataPointMapper implements RowMapper<ChartDataPoint> {

    @Override
    public ChartDataPoint mapRow(ResultSet resultSet, int i) throws SQLException {
        return new ChartDataPoint(
                resultSet.getString("label"),
                resultSet.getInt("value"),
                resultSet.getInt("my_value")
        );
    }
    
}
