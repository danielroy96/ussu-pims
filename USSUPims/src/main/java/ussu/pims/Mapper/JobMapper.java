/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ussu.pims.Mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import ussu.pims.Model.Job;

/**
 *
 * @author danielroy
 */
public class JobMapper implements RowMapper<Job>{

    @Override
    public Job mapRow(ResultSet resultSet, int i) throws SQLException {
        return new Job(
                resultSet.getInt("id"),
                resultSet.getString("name"),
                resultSet.getString("description"),
                resultSet.getString("job_start_datetime"),
                resultSet.getString("job_end_datetime"),
                resultSet.getString("venue"),
                resultSet.getInt("client_id"),
                resultSet.getString("client_name"),
                resultSet.getString("client_contact_name"),
                resultSet.getString("client_contact_email"),
                resultSet.getString("client_contact_phone")
        );
    }
    
}
