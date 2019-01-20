package ussu.pims.Mapper;

import org.springframework.jdbc.core.RowMapper;
import ussu.pims.Model.LeaderboardDataPoint;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LeaderboardDataPointMapper implements RowMapper<LeaderboardDataPoint> {

    public LeaderboardDataPoint mapRow(ResultSet resultSet, int i) throws SQLException {
        return new LeaderboardDataPoint(
                String.valueOf(i+1),
                resultSet.getString("user"),
                resultSet.getString("test_count")
        );
    }
}
