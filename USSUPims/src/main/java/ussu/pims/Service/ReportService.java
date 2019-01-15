/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ussu.pims.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ussu.pims.DAO.ReportDAO;
import ussu.pims.Model.ItemReportRow;

/**
 *
 * @author danielroy
 */
@Service
public class ReportService {
    
    @Autowired
    private ReportDAO reportDAO;
    
    public List<ItemReportRow> getAllItems() {
        return reportDAO.getAllItems();
    }

    public List<ItemReportRow> getJobItems(int jobId) {
        return reportDAO.getJobItems(jobId);
    }
}
