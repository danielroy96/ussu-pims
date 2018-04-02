/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ussu.pims.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ussu.pims.Model.ItemReportRow;
import ussu.pims.Report.ItemReport;
import ussu.pims.Service.ReportService;

/**
 *
 * @author danielroy
 */
@Controller
public class ReportController {

    @Autowired
    private ReportService reportService;

    @RequestMapping(value = "/report/all", method = RequestMethod.GET)
    public ModelAndView getExcel() {
        List<ItemReportRow> itemReportRowList = reportService.getAllItems();
        return new ModelAndView(new ItemReport(), "itemReportRowList", itemReportRowList);
    }

}
