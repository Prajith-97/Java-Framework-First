package utility;

import org.testng.annotations.DataProvider;

import java.io.IOException;

public class testDataProvider {

    public static Object[][] testData(String excelPath, String sheetName) throws IOException {
        excelUtils excel = new excelUtils(excelPath, sheetName);
        int rowCount = excelUtils.getRowCount();
        int colCount = excelUtils.getColCount();
        Object[][] data=new Object[rowCount-1][colCount];
        for (int i = 1; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                String cellData = excelUtils.getCellDataString(i, j);
                System.out.println(cellData);
                data[i-1][j]=cellData;
            }
        }
        return data;
    }
//        public static void main(String[] args) throws IOException {
//               excelUtils obj =new excelUtils("C:\\JavaIntellij\\Framework\\src\\test\\Excel\\driverSheet.xlsx","sheet1");
//               testData("C:\\JavaIntellij\\Framework\\src\\test\\Excel\\driverSheet.xlsx","sheet1");
//    }
    @DataProvider(name = "featureFileDetails")
    public static Object[][] data() throws IOException {
        String excelPath= "C:\\JavaIntellij\\Framework\\src\\test\\Excel\\driverSheet.xlsx";
        Object[][] data = testData(excelPath,"sheet1");
        return data;
//        return new Object[][]{{"C:\\JavaIntellij\\Framework\\src\\test\\resources\\features\\login.feature"},{"C:\\JavaIntellij\\Framework\\src\\test\\resources\\features\\plp.feature"}};
    }
    }
