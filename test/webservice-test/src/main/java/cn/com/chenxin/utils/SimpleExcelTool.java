package cn.com.chenxin.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.util.CellRangeAddress;

/**
 * 简单Excel工具类
 * @author tiantain
 *
 */
public class SimpleExcelTool {
    public static HSSFWorkbook generateExcel(String title,String subTitle1,String subTitle2,String[] titles,
            List<String[]> values) {
        //创建Excel对象
        HSSFWorkbook workbook = new HSSFWorkbook();

        //创建sheet
        HSSFSheet sheet = workbook.createSheet();
        sheet.setDefaultColumnWidth(40);
        
        HSSFCellStyle cellStyleR = workbook.createCellStyle();
        cellStyleR.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        cellStyleR.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
        cellStyleR.setBorderBottom((short) 1);
        cellStyleR.setBorderLeft((short) 1);
        cellStyleR.setBorderRight((short) 1);
        cellStyleR.setBorderTop((short) 1);
        
        HSSFFont fontR = workbook.createFont();
        fontR.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        fontR.setFontName("宋体");
        fontR.setFontHeightInPoints((short) 28);
        cellStyleR.setFont(fontR);
        
        sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, titles.length-1));
        HSSFRow titleR = sheet.createRow(0);
        titleR.setHeightInPoints((short) 50);
        for (int i = 0; i < titles.length; i++) {
            HSSFCell cellR = titleR.createCell(i);
            cellR.setCellValue(title);
            cellR.setCellStyle(cellStyleR);
        }
        
        
        
     // 定义标题行
        HSSFRow subTitleRow = sheet.createRow(1);
        subTitleRow.setHeightInPoints(18);
        HSSFCellStyle cellStylesubTitle = workbook.createCellStyle();
        cellStylesubTitle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        cellStylesubTitle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
        cellStylesubTitle.setBorderBottom((short) 1);
        cellStylesubTitle.setBorderLeft((short) 1);
        cellStylesubTitle.setBorderRight((short) 1);
        cellStylesubTitle.setBorderTop((short) 1);
        
        cellStylesubTitle.setWrapText(false);
        
        //合并单元格(副标题)
        int firstCols = titles.length / 2;
        
        sheet.addMergedRegion(new CellRangeAddress(1, 1, 0, firstCols-1));
        sheet.addMergedRegion(new CellRangeAddress(1, 1, firstCols, titles.length-1));
        for (int i = 0; i < firstCols; i++) {
            HSSFCell subCell1 = subTitleRow.createCell(0);
            subCell1.setCellValue(subTitle1);
            subCell1.setCellStyle(cellStylesubTitle);
        }
        for (int i = firstCols; i < titles.length; i++) {
            HSSFCell subCell2 = subTitleRow.createCell(firstCols);
            subCell2.setCellValue(subTitle2);
            subCell2.setCellStyle(cellStylesubTitle);
        }
        
        
        
        // 定义标题行
        HSSFRow titleRow = sheet.createRow(2);
        titleRow.setHeightInPoints(18);
        HSSFCellStyle cellStyleTitle = workbook.createCellStyle();
        cellStyleTitle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        cellStyleTitle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
        cellStyleTitle.setBorderBottom((short) 1);
        cellStyleTitle.setBorderLeft((short) 1);
        cellStyleTitle.setBorderRight((short) 1);
        cellStyleTitle.setBorderTop((short) 1);
        
        HSSFFont font = workbook.createFont();
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        font.setFontName("宋体");
        font.setFontHeight((short) 200);
        cellStyleTitle.setFont(font);
        cellStyleTitle.setWrapText(false);
        for (int i = 0; i < titles.length; i++) {
            HSSFCell cell = titleRow.createCell(i);
            cell.setCellValue(titles[i]);
            cell.setCellStyle(cellStyleTitle);
            
        }
        
        HSSFCellStyle valueStyleValue = workbook.createCellStyle();
        valueStyleValue.setAlignment(HSSFCellStyle.ALIGN_LEFT);
        valueStyleValue.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
        valueStyleValue.setBorderBottom((short) 1);
        valueStyleValue.setBorderLeft((short) 1);
        valueStyleValue.setBorderRight((short) 1);
        valueStyleValue.setBorderTop((short) 1);
        for (int i=0;i<values.size();i++) {
            HSSFRow valueRow = sheet.createRow(i+3);
            valueRow.setHeightInPoints(18);
            String[] value = values.get(i);
            for (int j = 0; j < value.length; j++) {
                HSSFCell cell = valueRow.createCell(j);
                cell.setCellValue(value[j]);
                cell.setCellStyle(valueStyleValue);
            }
            
        }
        
        return workbook;
    }
  public static void main(String[] args) throws FileNotFoundException, IOException {
    String[] titles = {"姓名","身份证号","手机号","性别"};
    
    List<String[]> values = new ArrayList<String[]>();
    for (int i = 0; i < 10; i++) {
        String[] value = {"姓名"+i,"身份证"+i,"手机号"+i,"性别"+i};
        values.add(value);
    }
    HSSFWorkbook workbook = generateExcel("表格展示样例","单位名称：XXXX公司","监控时间：20161101-20161130",titles, values);
    workbook.write(new FileOutputStream(new File("D:/aa.xls")));
}

}

















