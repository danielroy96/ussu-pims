/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ussu.pims.Report;

import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.*;
import org.springframework.web.servlet.view.document.AbstractXlsxView;
import ussu.pims.Model.ItemReportRow;

/**
 *
 * @author danielroy
 */
public class ItemReport extends AbstractXlsxView {

    @Override
    protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest hsr, HttpServletResponse response) throws Exception {
        response.setHeader("Content-Disposition", "attachment;filename=\"item.xlsx\"");
        List<ItemReportRow> itemReportRowList = (List<ItemReportRow>) model.get("itemReportRowList");
        Sheet sheet = workbook.createSheet("Item Data");
        Row header = sheet.createRow(0);
        header.createCell(0).setCellValue("Barcode");
        header.createCell(1).setCellValue("Item Type Name");
        header.createCell(2).setCellValue("Value");
        header.createCell(3).setCellValue("Weight");
        header.createCell(4).setCellValue("PAT Test Required");
        header.createCell(5).setCellValue("PAT Test Interval (months)");
        header.createCell(6).setCellValue("PAT Test Date");
        header.createCell(7).setCellValue("PAT Test User");
        header.createCell(8).setCellValue("PAT Test in date");

        int rowNum = 1;
        for (ItemReportRow itemReportRow : itemReportRowList) {
            Row row = sheet.createRow(rowNum++);
            CellStyle expiredStyle = workbook.createCellStyle();
            expiredStyle.setFillForegroundColor(IndexedColors.RED.getIndex());
            expiredStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            CellStyle inDateStyle = workbook.createCellStyle();
            inDateStyle.setFillForegroundColor(IndexedColors.GREEN.getIndex());
            expiredStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

            row.createCell(0).setCellValue(itemReportRow.getItem().getBarcode());
            row.createCell(1).setCellValue(itemReportRow.getItem().getItemTypeName());
            row.createCell(2).setCellValue(itemReportRow.getItem().getValue());
            row.createCell(3).setCellValue(itemReportRow.getItem().getWeight());
            row.createCell(4).setCellValue(itemReportRow.getItem().isRequiresPat());
            row.createCell(5).setCellValue(itemReportRow.getItem().getPatIntervalMonths());
            Cell cell6 = row.createCell(6);
            cell6.setCellValue(itemReportRow.getTest().getTestDatetime());
            if (itemReportRow.getItem().isPatInDate() && itemReportRow.getItem().isRequiresPat()) {
                cell6.setCellStyle(inDateStyle);
            } else if (!itemReportRow.getItem().isPatInDate() && itemReportRow.getItem().isRequiresPat()) {
                cell6.setCellStyle(expiredStyle);
            }
            row.createCell(7).setCellValue(itemReportRow.getTest().getTestUserFullname());
            row.createCell(8).setCellValue(itemReportRow.getItem().isPatInDate());
        }
    }

}
