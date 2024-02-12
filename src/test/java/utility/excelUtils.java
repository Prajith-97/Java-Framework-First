package utility;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;

public class excelUtils {
    static XSSFWorkbook workBook;
    static XSSFSheet sheet;

    public excelUtils(String excelPath, String sheetName) throws IOException {
        workBook = new XSSFWorkbook(excelPath);
        sheet = workBook.getSheet(sheetName);
    }
    public static int getRowCount(){
        int rowCount=0;
        try{
            rowCount=sheet.getPhysicalNumberOfRows();
        }catch (Exception e){
            e.printStackTrace();
        }
        return rowCount;
    }

    public static int getColCount(){
        int colCount=0;
        try{
            colCount=sheet.getRow(0).getPhysicalNumberOfCells();
        }catch (Exception e){
            e.printStackTrace();
        }
        return colCount;
    }
    public static String getCellDataString(int rowNum, int colNum) throws IOException {
        String cellData = sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
        return cellData;
    }
    public static void getCellDataInteger(int rowNum, int colNum) throws IOException {
        Double data = sheet.getRow(rowNum).getCell(colNum).getNumericCellValue();
        System.out.println(data);
    }
//    public static void main(String[] args) throws IOException {
//       excelUtils obj =new excelUtils("C:\\JavaIntellij\\Framework\\src\\test\\Excel\\driverSheet.xlsx","sheet1");
//         getCellDataInteger(0,0);
//         getCellDataString(1,1);
//    }

}
