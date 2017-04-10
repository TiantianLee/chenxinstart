package cn.com.chenxin.utils.excel;

import java.util.Iterator;
import java.util.Map;

import org.apache.commons.lang.math.NumberUtils;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFName;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.Region;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.util.AreaReference;
import org.apache.poi.ss.util.CellReference;

/**
 * Excel处理工具类
 * 
 * @author LIYANG
 *
 * @since
 */
public class ExcelTools {
    /**
     * Logger for this class
     */
    private static final Logger LOGGER = Logger.getLogger(ExcelTools.class);

    /**
     * 拷贝指定行
     * 
     * @param sourceWorkbook
     *            源workbook对象
     * @param pSourceSheetName
     *            源sheet名称
     * @param targetWorkbook
     *            目标workbook对象
     * @param pTargetSheetName
     *            目标sheet名称
     * @param pStartRow
     *            开始行
     * @param pEndRow
     *            结束行
     * @param pPosition
     *            指定偏移位置
     */
    public static void copyRows(HSSFWorkbook sourceWorkbook, String pSourceSheetName, HSSFWorkbook targetWorkbook, String pTargetSheetName,
            int pStartRow, int pEndRow, int pPosition) {
        HSSFRow sourceRow = null;
        HSSFRow targetRow = null;
        HSSFCell sourceCell = null;
        HSSFCell targetCell = null;
        HSSFSheet sourceSheet = null;
        HSSFSheet targetSheet = null;
        Region region = null;
        int cType;
        int i;
        short j;
        int targetRowFrom;
        int targetRowTo;
        if ((pStartRow == -1) || (pEndRow == -1)) {
            return;
        }
        sourceSheet = sourceWorkbook.getSheet(pSourceSheetName);
        targetSheet = targetWorkbook.getSheet(pTargetSheetName);
        // 取消目标文件从pPosition后的单元格的和并
        for (i = 0; i < targetSheet.getNumMergedRegions(); i++) {
            region = targetSheet.getMergedRegionAt(i);
            if ((region.getRowFrom() >= pPosition)) {
                targetSheet.removeMergedRegion(i);
            }
        }
        // 拷贝合并的单元格
        for (i = 0; i < sourceSheet.getNumMergedRegions(); i++) {
            region = sourceSheet.getMergedRegionAt(i);
            if ((region.getRowFrom() >= pStartRow) && (region.getRowTo() <= pEndRow)) {
                targetRowFrom = region.getRowFrom() - pStartRow + pPosition;
                targetRowTo = region.getRowTo() - pStartRow + pPosition;
                region.setRowFrom(targetRowFrom);
                region.setRowTo(targetRowTo);
                targetSheet.addMergedRegion(region);
            }
        }
        // 设置列宽
        for (i = pStartRow; i <= pEndRow; i++) {
            sourceRow = sourceSheet.getRow(i);
            if (sourceRow != null) {
                for (j = sourceRow.getFirstCellNum(); j < sourceRow.getLastCellNum(); j++) {
                    targetSheet.setColumnWidth(j, sourceSheet.getColumnWidth(j));
                }
                break;
            }
        }
        // 拷贝行并填充数据
        for (; i <= pEndRow; i++) {
            sourceRow = sourceSheet.getRow(i);
            if (sourceRow == null) {
                continue;
            }
            targetRow = targetSheet.createRow(i - pStartRow + pPosition);
            // 设置行高
            targetRow.setHeight(sourceRow.getHeight());
            for (j = sourceRow.getFirstCellNum(); j < sourceRow.getLastCellNum(); j++) {
                sourceCell = sourceRow.getCell(j);
                if (sourceCell == null) {
                    continue;
                }
                targetCell = targetRow.createCell(j);
                // 防止出现乱码
                // targetCell.setEncoding(sourceCell.getEncoding());
                CellStyle tmpStyle = targetWorkbook.createCellStyle();
                tmpStyle.cloneStyleFrom(sourceCell.getCellStyle());
                targetCell.setCellStyle(tmpStyle);
                // targetCell.setCellStyle(sourceCell.getCellStyle());
                cType = sourceCell.getCellType();
                targetCell.setCellType(cType);
                switch (cType) {
                    case HSSFCell.CELL_TYPE_BOOLEAN:
                        targetCell.setCellValue(sourceCell.getBooleanCellValue());
                        break;
                    case HSSFCell.CELL_TYPE_ERROR:
                        targetCell.setCellErrorValue(sourceCell.getErrorCellValue());
                        break;
                    case HSSFCell.CELL_TYPE_FORMULA:
                        // parseFormula这个函数的用途在后面说明
                        targetCell.setCellFormula(sourceCell.getCellFormula());
                        break;
                    case HSSFCell.CELL_TYPE_NUMERIC:
                        if (HSSFDateUtil.isCellDateFormatted(sourceCell)) {
                            // 设置日期格式的样式
                            HSSFCellStyle cellStyle = targetWorkbook.createCellStyle();
                            // 指定日期显示格式,否则日期显示错误
                            cellStyle.setDataFormat(HSSFDataFormat.getBuiltinFormat("m/d/yy h:mm"));
                            targetCell.setCellValue(sourceCell.getDateCellValue());
                            targetCell.setCellStyle(cellStyle);
                        } else {
                            targetCell.setCellValue(sourceCell.getNumericCellValue());
                        }
                        break;
                    case HSSFCell.CELL_TYPE_STRING:
                        targetCell.setCellValue(sourceCell.getStringCellValue());
                        break;
                    default:
                        break;
                }
            }
        }
    }

    /**
     * 根据Excel名称向excel中赋值
     * @param workbook 要赋值的workbook对象
     * @param mapValue
     *            所存储的值
     */
    @SuppressWarnings("deprecation")
    public static void setCellValueByName(HSSFWorkbook workbook, Map<String, String> mapValue) {
        Iterator<String> it = mapValue.keySet().iterator();
        while (it.hasNext()) {
            String cellName = it.next();
            String cellValue = mapValue.get(cellName);
            System.out.println("根据名称查找单元格：" + cellName);
            // Retrieve the named range
            // Will be something like "$C$10,$D$12:$D$14";
            int namedCellIdx = workbook.getNameIndex(cellName);
            LOGGER.info("根据cellName查询该name索引：name=" + cellName);
            LOGGER.info("根据cell索引得到hssfName: namedCellIdx=" + namedCellIdx);
            HSSFName hssfName = workbook.getNameAt(namedCellIdx);
            LOGGER.info("得到的hssfName为：" + hssfName);

            // Retrieve the cell at the named range and test its contents
            // Will get back one AreaReference for C10, and
            // another for D12 to D14
            AreaReference[] arefs = AreaReference.generateContiguous(hssfName.getRefersToFormula());
            for (int i = 0; i < arefs.length; i++) {
                // Only get the corners of the Area
                // (use arefs[i].getAllReferencedCells() to get all cells)
                CellReference[] crefs = arefs[i].getAllReferencedCells();
                for (int j = 0; j < crefs.length; j++) {
                    // Check it turns into real stuff
                    HSSFSheet sheet = workbook.getSheet(crefs[j].getSheetName());
                    HSSFRow row = sheet.getRow(crefs[j].getRow());
                    HSSFCell cell = row.getCell(crefs[j].getCol());
                    // Do something with this corner cell
                    if (NumberUtils.isDigits(cellValue)) {
                        cell.setCellValue(NumberUtils.toInt(cellValue));
                        cell.setCellType(Cell.CELL_TYPE_NUMERIC);
                    } else {
                        cell.setCellValue(cellValue);
                    }
                }
            }
        }
    }

}
