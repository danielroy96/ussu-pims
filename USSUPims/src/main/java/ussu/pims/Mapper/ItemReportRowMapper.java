/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ussu.pims.Mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import ussu.pims.Model.ItemReportRow;

/**
 *
 * @author danielroy
 */
public class ItemReportRowMapper implements RowMapper<ItemReportRow> {

    @Override
    public ItemReportRow mapRow(ResultSet resultSet, int i) throws SQLException {
        ItemMapper itemMapper = new ItemMapper();
        TestMapper testMapper = new TestMapper();
        return new ItemReportRow(
                itemMapper.mapRow(resultSet, i),
                testMapper.mapRow(resultSet, i)
        );
    }

}
