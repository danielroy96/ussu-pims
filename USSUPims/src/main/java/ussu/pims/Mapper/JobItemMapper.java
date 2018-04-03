/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ussu.pims.Mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import ussu.pims.Model.JobItem;

/**
 *
 * @author danielroy
 */
public class JobItemMapper implements RowMapper<JobItem>{

    @Override
    public JobItem mapRow(ResultSet resultSet, int i) throws SQLException {
        ItemMapper itemMapper = new ItemMapper();
        return new JobItem(
                resultSet.getInt("job_item_id"),
                resultSet.getInt("item_id"),
                resultSet.getInt("job_id"),
                resultSet.getString("job_item_status"),
                resultSet.getString("job_item_added_datetime"),
                resultSet.getString("job_item_returned_datetime"),
                resultSet.getString("job_item_removed_datetime"),
                itemMapper.mapRow(resultSet, i)
        );
    }
    
}
