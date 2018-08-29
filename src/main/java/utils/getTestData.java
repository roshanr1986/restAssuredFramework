package utils;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import properties.property;

import java.io.FileInputStream;
import java.io.IOException;



public class getTestData
{

    public static XSSFSheet ExcelWSheet;

    public static XSSFWorkbook ExcelWBook;

    public static XSSFCell Cell;

    public static XSSFRow Row;


    public static String filepath= property.excelTestDataFilePath;
    public static String extension=property.excelFileExtension;

    public int getColumnCount(String filename, String sheetname) throws Exception {


        int columns = 0;
        try {
            excelSetup(filename, sheetname);
            columns = ExcelWSheet.getRow(0).getLastCellNum();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return columns;
    }

    public int getRowCount(String filename, String sheetname) throws Exception {


        int rows = 0;
        try {
            excelSetup(filename, sheetname);
            rows = ExcelWSheet.getLastRowNum();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return rows;
    }


    public String readFromExcel(String filename, String sheetname, int row, int column) throws Exception{

        try {
            excelSetup(filename,sheetname);
        }catch (Exception e) { e.printStackTrace(); }

            String data = ExcelWSheet.getRow(row).getCell(column).getStringCellValue();

        return data;
    }


public void excelSetup(String filename, String sheetname) throws Exception{

    try {
        FileInputStream ExcelFile = new FileInputStream(filepath+filename+extension);
        ExcelWBook = new XSSFWorkbook(ExcelFile);
        ExcelWSheet = ExcelWBook.getSheet(sheetname);

    } catch (IOException e) {
        e.printStackTrace();
    }

}

}

