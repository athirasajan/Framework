/**
 * 
 */
package com.review.util;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;













import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;

/**
 * @author athira
 *
 */
public class Utility {
	public static void capturescreenshot(WebDriver driver, String screenshotname){
		try {	
			TakesScreenshot ts=(TakesScreenshot)driver;
			File source=ts.getScreenshotAs(OutputType.FILE);
			//FileUtils.copyFile(source,new File("./Screenshots/"+screenshotname+".png"));
			FileHandler.copy(source, new File("./Screenshots/"+screenshotname+".png"));
			System.out.println("Screenshot Taken");
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	  	

	}
	public static void highLightElement(WebDriver driver, WebElement element)
	{
	JavascriptExecutor js=(JavascriptExecutor)driver; 

	js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);

	try 
	{
	Thread.sleep(500);
	} 
	catch (InterruptedException e) {

	System.out.println(e.getMessage());
	} 

	js.executeScript("arguments[0].setAttribute('style','border: solid 2px white');", element); 

	}
	
	
		
		

		public static String TESTDATA_SHEET_PATH = "C:/Users/athira/workspace/ReviewGridSetUp/src/main/java/com/review/testdata/test.xlsx";
		
		static Workbook book;
		static Sheet sheet;
		
		public static Object[][] getTestData(String sheetName) {
			FileInputStream file = null;
			try {
				file = new FileInputStream(TESTDATA_SHEET_PATH);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			try {
				book = WorkbookFactory.create(file);
			} catch (InvalidFormatException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			sheet = book.getSheet(sheetName);
			Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
			System.out.println(sheet.getLastRowNum() + "--------" +
		    sheet.getRow(0).getLastCellNum());
			for (int i = 0; i < sheet.getLastRowNum(); i++) {
				for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
					try{
					data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
					System.out.println(data[i][k]);
					}
					catch( Exception e){
						e.printStackTrace();
					}
				}
			}
			return data;
		}
	
		public static String getData(int sheetno,int row,int column) throws Exception{
			
			FileInputStream fis;
			XSSFWorkbook wb;
			XSSFSheet sh1;
			
			File src=new File("C:/Users/athira/workspace/ReviewGridSetUp/src/main/java/com/review/testdata/test.xlsx");
			fis = new FileInputStream(src);
			wb=new XSSFWorkbook(fis);
			sh1= wb.getSheetAt(sheetno);
			//cell.setCellType(Cell.CELL_TYPE_STRING);
			
			//String data=sh1.getRow(row).getCell(column).getStringCellValue();
			String data=sh1.getRow(row).getCell(column).toString();
			
			return data;
			
		}

	

}
