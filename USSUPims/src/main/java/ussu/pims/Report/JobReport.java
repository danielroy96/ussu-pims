package ussu.pims.Report;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;
import ussu.pims.Model.ItemReportRow;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

public class JobReport extends AbstractXlsxView {
    @Override
    protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request, HttpServletResponse response) throws Exception {
        response.setHeader("Content-Disposition", "attachment;filename=\"job.xlsx\"");
        List<ItemReportRow> itemReportRowList = (List<ItemReportRow>) model.get("itemReportRowList");
        Sheet sheet = workbook.createSheet("Job Data");
        Row header = sheet.createRow(0);
        header.createCell(0).setCellValue("Barcode");
        header.createCell(1).setCellValue("Item Type Name");
        header.createCell(2).setCellValue("Value");
        header.createCell(3).setCellValue("Weight");
        header.createCell(4).setCellValue("PAT Test Required");
        header.createCell(5).setCellValue("PAT Test Interval (months)");
        header.createCell(6).setCellValue("PAT Test Date");
        header.createCell(7).setCellValue("PAT Test User");

        int rowNum = 1;
        for (ItemReportRow itemReportRow : itemReportRowList) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(itemReportRow.getItem().getBarcode());
            row.createCell(1).setCellValue(itemReportRow.getItem().getItemTypeName());
            row.createCell(2).setCellValue(itemReportRow.getItem().getValue());
            row.createCell(3).setCellValue(itemReportRow.getItem().getWeight());
            row.createCell(4).setCellValue(itemReportRow.getItem().isRequiresPat());
            row.createCell(5).setCellValue(itemReportRow.getItem().getPatIntervalMonths());
            row.createCell(6).setCellValue(itemReportRow.getTest().getTestDatetime());
            row.createCell(7).setCellValue(itemReportRow.getTest().getTestUserFullname());
        }
    }
}
