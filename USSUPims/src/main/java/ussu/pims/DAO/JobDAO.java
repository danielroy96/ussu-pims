/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ussu.pims.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

/**
 *
 * @author danielroy
 */
public class JobDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int addJob(final String name, final String description, final Integer clientId, final String jobStartDatetime, final String jobEndDatetime, final String venue) {
        final String SQL = ""
                + "INSERT INTO pims.jobs ("
                + "  name"
                + ", description"
                + ", client_id"
                + ", job_start_datetime"
                + ", job_end_datetime"
                + ", venue"
                + ") VALUES ("
                + "  ?"
                + ", ?"
                + ", ?"
                + ", ?"
                + ", ?"
                + ", ?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(
                new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement preparedStatement = connection.prepareStatement(SQL, new String[]{"id"});
                preparedStatement.setString(1, name);
                if (description != null) {
                    preparedStatement.setString(2, description);
                } else {
                    preparedStatement.setNull(2, Types.VARCHAR);
                }
                if (clientId != null) {
                    preparedStatement.setInt(3, clientId);
                } else {
                    preparedStatement.setNull(3, Types.INTEGER);
                }
                if (jobStartDatetime != null) {
                    preparedStatement.setString(4, jobStartDatetime);
                } else {
                    preparedStatement.setNull(4, Types.DATE);
                }
                if (jobEndDatetime != null) {
                    preparedStatement.setString(5, jobEndDatetime);
                } else {
                    preparedStatement.setNull(5, Types.DATE);
                }
                if (venue != null) {
                    preparedStatement.setString(6, venue);
                } else {
                    preparedStatement.setNull(6, Types.VARCHAR);
                }
                return preparedStatement;
            }
        }, keyHolder
        );
        return keyHolder.getKey().intValue();
    }

}
