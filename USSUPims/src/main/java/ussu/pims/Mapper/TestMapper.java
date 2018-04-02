/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ussu.pims.Mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import ussu.pims.Model.Test;

/**
 *
 * @author danielroy
 */
public class TestMapper implements RowMapper<Test>{

    @Override
    public Test mapRow(ResultSet resultSet, int i) throws SQLException {
        return new Test(
                resultSet.getInt("test_id"),
                resultSet.getInt("id"),
                resultSet.getString("test_datetime"),
                resultSet.getString("test_user_fullname")
        );
    }
    
}
