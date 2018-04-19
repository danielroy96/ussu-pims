/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ussu.pims.DAO;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ussu.pims.Mapper.ItemReportRowMapper;
import ussu.pims.Model.ItemReportRow;

/**
 *
 * @author danielroy
 */
@Repository
public class ReportDAO {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    public List<ItemReportRow> getAllItems() {
        String SQL = ""
                + "SELECT"
                + "  i.id"
                + ", i.created_by_user_id created_by_user_id"
                + ", CONCAT(udcc.title, ' ', udcc.forename, ' ', udcc.surname) created_by_user_fullname "
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
                + ", tl.id test_id "
                + ", DATE_FORMAT(tl.test_datetime, '%H:%i %d/%m/%Y') test_datetime"
                + ", CONCAT(udctl.title, ' ', udctl.forename, ' ', udctl.surname) test_user_fullname "
                + ", tl.test_datetime last_pat_test_datetime "
                + ", CASE " +
                "      WHEN idceid.id IS NULL THEN FALSE " +
                "      ELSE TRUE " +
                "    END pat_in_date "
                + "FROM pims.items i "
                + "JOIN pims.item_details_current_extant idce ON i.id = idce.item_id "
                + "JOIN pims.item_types it ON idce.item_type = it.id "
                + "JOIN pims.user_details_current udcc ON udcc.user_id = i.created_by_user_id "
                + "JOIN pims.user_details_current udcl ON udcl.user_id = idce.last_changed_by_user_id "
                + "LEFT OUTER JOIN pims.tests_latest tl ON tl.item_id = i.id "
                + "LEFT OUTER JOIN pims.user_details_current udctl ON udctl.user_id = tl.test_user "
                + "LEFT OUTER JOIN pims.item_details_current_extant_in_date idceid ON idceid.id = idce.id ";
        return jdbcTemplate.query(SQL, new ItemReportRowMapper());
    }

//    public List<ItemReportRow> getJobItems(int jobId) {
//
//    }
    
}
