/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ussu.pims.DAO;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 *
 * @author danielroy
 */
@Repository
public class ItemTypeDAO {
   
    @Autowired
    private DataSource dataSource;
    
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    public void addItemType(String name, float value, float weight, String requiresPAT, int PATIntervalMonths, int userID) {
        String SQL = ""
                + "INSERT INTO pims.item_types ("
                + "  name"
                + ", value"
                + ", weight"
                + ", requires_pat"
                + ", pat_interval_months"
                + ", created_by_user_id"
                + ", last_changed_by_user_id"
                + ") VALUES ("
                + "  ?"
                + ", ?"
                + ", ?"
                + ", ?"
                + ", ?"
                + ", ?"
                + ", ?"
                + ")";
        jdbcTemplate.update(SQL, name, value, weight, requiresPAT, PATIntervalMonths, userID, userID);
    }
    
    public void updateItemType(int itemTypeID, String name, float value, float weight, String requiresPAT, int PATIntervalMonths, int userID) {
        String SQL = ""
                + "UPDATE pims.item_types it SET"
                + "  it.name = ?"
                + ", it.value = ?"
                + ", it.weight = ?"
                + ", it.requires_pat = ?"
                + ", it.pat_interval_months = ?"
                + ", it.last_changed_by_user_id = ? "
                + "WHERE it.id = ?";
        jdbcTemplate.update(SQL, name, value, weight, requiresPAT, PATIntervalMonths, userID, itemTypeID);
    }
}
