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
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import ussu.pims.Mapper.JobItemMapper;
import ussu.pims.Mapper.JobMapper;
import ussu.pims.Model.Job;
import ussu.pims.Model.JobItem;

/**
 *
 * @author danielroy
 */
@Repository
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
                + ", STR_TO_DATE(?, '%H:%k %d/%m/%Y')"
                + ", STR_TO_DATE(?, '%H:%k %d/%m/%Y')"
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

    public Job getJob(int jobId) {
        String SQL = ""
                + "SELECT"
                + "  j.id"
                + ", j.name"
                + ", j.description"
                + ", j.job_start_datetime"
                + ", j.job_end_datetime"
                + ", j.venue"
                + ", c.id client_id"
                + ", c.name client_name"
                + ", c.contact_name client_contact_name"
                + ", c.contact_email client_contact_email"
                + ", c.contact_phone client_contact_phone "
                + "FROM pims.jobs j "
                + "LEFT OUTER JOIN pims.clients c ON j.client_id = c.id "
                + "WHERE j.id = ?";
        return jdbcTemplate.query(SQL, new JobMapper(), jobId).get(0);
    }
    
    public List<JobItem> getJobItems(int jobId) {
        String SQL = ""
                + "SELECT"
                + "  ij.id job_item_id"
                + ", ij.item_id item_id"
                + ", ij.job_id job_id"
                + ", ij.status job_item_status"
                + ", DATE_FORMAT(ij.added_datetime, '%H:%i %d/%m/%Y') job_item_added_datetime"
                + ", DATE_FORMAT(ij.returned_datetime, '%H:%i %d/%m/%Y') job_item_returned_datetime"
                + ", DATE_FORMAT(ij.removed_datetime, '%H:%i %d/%m/%Y') job_item_removed_datetime"
                + ", i.id id"
                + ", i.created_by_user_id created_by_user_id"
                + ", CONCAT(udcc.title, ' ', udcc.forename, ' ', udcc.surname) created_by_user_fullname"
                + ", DATE_FORMAT(i.created_datetime, '%H:%i %d/%m/%Y') created_datetime"
                + ", DATE_FORMAT(idce.start_datetime, '%H:%i %d/%m/%Y') last_changed_datetime"
                + ", idce.last_changed_by_user_id last_changed_by_user_id"
                + ", CONCAT(udcl.title, ' ', udcl.forename, ' ', udcl.surname) last_changed_by_user_fullname"
                + ", idce.barcode barcode"
                + ", idce.description description"
                + ", it.id item_type_id"
                + ", it.name item_type_name"
                + ", it.value value"
                + ", it.weight weight"
                + ", it.requires_pat requires_pat"
                + ", it.pat_interval_months pat_interval_months "
                + "FROM pims.item_on_job ij "
                + "JOIN pims.items i ON ij.item_id = i.id "
                + "JOIN pims.item_details_current_extant idce ON i.id = idce.item_id "
                + "JOIN pims.item_types it ON idce.item_type = it.id "
                + "JOIN pims.user_details_current udcc ON udcc.user_id = i.created_by_user_id "
                + "JOIN pims.user_details_current udcl ON udcl.user_id = idce.last_changed_by_user_id "
                + "WHERE ij.job_id = ?";
        return jdbcTemplate.query(SQL, new JobItemMapper(), jobId);
    }
    
}
