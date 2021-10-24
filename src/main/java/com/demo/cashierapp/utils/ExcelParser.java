package com.demo.cashierapp.utils;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;


import java.io.IOException;

public class ExcelParser {
    static XSSFWorkbook workbook;
    static XSSFSheet sheet;


    public ExcelParser(String excelPath, String sheetName) throws IOException {
        workbook = new XSSFWorkbook(excelPath);
        sheet = workbook.getSheet(sheetName);

    }

    public void getCellData(int rowNum, int colNum) throws IOException {
        DataFormatter formatter = new DataFormatter();
        Object value = formatter.formatCellValue(sheet.getRow(rowNum).getCell(colNum));
        System.out.println(value);
    }

    public int getRowCount() {

        int rowCount = sheet.getPhysicalNumberOfRows();
        return rowCount;

    }

}
