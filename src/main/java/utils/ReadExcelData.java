package utils;


public class ReadExcelData  {

    public Object[][] getData(String fileName, String sheetName) throws Exception {

        getTestData dataObject = new getTestData();
        int rowCount = 0;
        int colCount = 0;
        try {
            rowCount=dataObject.getRowCount(fileName,sheetName);
            colCount=dataObject.getColumnCount(fileName,sheetName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Object data[][] = new Object[rowCount][colCount];

        for(int i=0;i<rowCount;i++){
            for(int n=0;n<colCount;n++){
                data[i][n]=dataObject.readFromExcel(fileName,sheetName,i+1,n);
                //System.out.println(data[i][n]);
            }
        }

        return data;
    }



}
