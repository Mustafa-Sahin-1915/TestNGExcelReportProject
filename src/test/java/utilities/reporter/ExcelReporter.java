package utilities.reporter;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class ExcelReporter {

    private String reportFileName;
    private String reportPath;

    private String savedFileFullPath;
    public String workingDir;

    HSSFWorkbook workbook;
    // Declare An Excel Work Sheet
    HSSFSheet sheet;
    Map<String, Object[]> TestNGResults;

    private int testStepNo;
    private int rowOfExcel;

    public ExcelReporter(String reportPath, String reportFileName){
        this.reportFileName = reportFileName;
        this.reportPath =reportPath;
        setUpReporter();
    }
    private void setUpReporter(){
        this.savedFileFullPath = reportPath +"\\"+reportFileName;
        this.testStepNo=0;
        this.rowOfExcel=0;
        // create a new work book
        workbook = new HSSFWorkbook();
        // create a new work sheet
        sheet = workbook.createSheet("TestNG Result Summary");
        TestNGResults = new LinkedHashMap<String, Object[]>();
        rowOfExcel++;
        TestNGResults.put(""+rowOfExcel, new Object[] { "Test Step No.", "Action", "Expected Output", "Actual Output","Status" });
        try {
            // Get current working directory and load the data file
            workingDir = System.getProperty("user.dir");
        } catch (Exception e) {
            throw new IllegalStateException("Can't start the Firefox Web Driver", e);
        }
    }
    public void addTest(String action, String expectedResult, String actualResult,String status){
        rowOfExcel++;
        testStepNo++;
        TestNGResults.put(""+rowOfExcel, new Object[] { ""+testStepNo, action, expectedResult, actualResult, status });
    }
    public void addPassTest(String action, String expectedResult, String actualResult){
        addTest(action, expectedResult, actualResult, "Pass");
    }
    public void addFailTest(String action, String expectedResult, String actualResult){
        addTest(action, expectedResult, actualResult, "Fail");
    }
    public void saveResultsToFile(){
        Set<String> keyset = TestNGResults.keySet();
        int rownum = 0;
        for (String key : keyset) {
            Row row = sheet.createRow(rownum++);
            Object[] objArr = TestNGResults.get(key);
            int cellnum = 0;
            for (Object obj : objArr) {
                Cell cell = row.createCell(cellnum++);
                if (obj instanceof Date)
                    cell.setCellValue((Date) obj);
                else if (obj instanceof Boolean)
                    cell.setCellValue((Boolean) obj);
                else if (obj instanceof String)
                    cell.setCellValue((String) obj);
                else if (obj instanceof Double)
                    cell.setCellValue((Double) obj);
            }
        }
        try {
            FileOutputStream out = new FileOutputStream(new File(savedFileFullPath));
            workbook.write(out);
            out.close();
            System.out.println("Successfully TestNG results to Excel File!!!");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void addTestNGInfoToExcel(){

    }
    public static void main(String[] args) {
        //Usage Sample
        ExcelReporter excelReporter = new ExcelReporter("target", "testresultstestng.xls");
        excelReporter.addPassTest("what did you do 1", "expected:1","actual:1");
        excelReporter.addPassTest("what did you do 2", "expected:2","actual:2");
        excelReporter.addFailTest("what did you do 3", "expected:3","actual:4");
        excelReporter.saveResultsToFile();
    }

}
