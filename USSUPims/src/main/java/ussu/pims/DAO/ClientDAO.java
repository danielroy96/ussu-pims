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
import ussu.pims.Mapper.ClientMapper;
import ussu.pims.Model.Client;

/**
 *
 * @author danielroy
 */
@Repository
public class ClientDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Client> quickSearch(String searchTerm) {
        String SQL = "" +
                "SELECT" +
                "  c.id" +
                ", c.name" +
                ", c.contact_name" +
                ", c.contact_email" +
                ", c.contact_phone " +
                "FROM pims.clients c " +
                "WHERE c.name LIKE CONCAT('%', ?, '%')";
        return jdbcTemplate.query(SQL, new ClientMapper(), searchTerm);
    }

    public int addClient(final String name, final String contactName, final String contactEmail, final String contactPhone) {
        final String SQL = ""
                + "INSERT INTO pims.clients ("
                + "  name"
                + ", contact_name"
                + ", contact_email"
                + ", contact_phone"
                + ") VALUES ("
                + "  ?"
                + ", ?"
                + ", ?"
                + ", ?"
                + ")";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(
                new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement preparedStatement = connection.prepareStatement(SQL, new String[]{"id"});
                preparedStatement.setString(1, name);
                if (contactName != null) {
                    preparedStatement.setString(2, contactName);
                } else {
                    preparedStatement.setNull(2, Types.VARCHAR);
                }
                if (contactEmail != null) {
                    preparedStatement.setString(3, contactEmail);
                } else {
                    preparedStatement.setNull(3, Types.VARCHAR);
                }
                if (contactPhone != null) {
                    preparedStatement.setString(4, contactPhone);
                } else {
                    preparedStatement.setNull(4, Types.VARCHAR);
                }
                return preparedStatement;
            }
        }, keyHolder
        );
        return keyHolder.getKey().intValue();
    }

}
