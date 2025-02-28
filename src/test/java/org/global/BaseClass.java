package org.global;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;
	public static Alert alert; 
	public void getDriver(String browserType ) {

		switch (browserType) {
		case "Chrome":
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			
			break;
		case "Edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();

		default:
			break;
		}
		
		}
	public void windowsMax() {
		driver.manage().window().maximize();
		
		
	}
		public void getUrl(String url) {
		driver.get(url);
		
	}
	public void screenCapture() throws IOException {
		TakesScreenshot takesScreenshot = (TakesScreenshot)driver;
		File screenshotAs = takesScreenshot.getScreenshotAs(OutputType.FILE);
		File targetFile = new File("Image\\"+System.currentTimeMillis()+".jpeg");
		FileUtils.copyFile(screenshotAs,targetFile);
		}
	public String readExcel(int rownum ,int cellnum) throws IOException {
		File file = new File("C:\\Users\\HP\\Documents\\excel\\Adactin.xlsx");
		FileInputStream fileInputStream = new FileInputStream(file);
		Workbook book = new XSSFWorkbook(fileInputStream);
		Sheet sheet = book.getSheet("Sheet1");
		Row row = sheet.getRow(rownum);
		Cell cell = row.getCell(cellnum);
		
		CellType cellType = cell.getCellType();
		
		String value =null;
		
		switch (cellType) {
		case STRING:
			 value = cell.getStringCellValue();
			
			break;
		case NUMERIC:
			if (DateUtil.isCellDateFormatted(cell)) {
				Date dateCellValue = cell.getDateCellValue();
				SimpleDateFormat simpleDateFormat =new SimpleDateFormat("dd/MM/yyyy");
				 value = simpleDateFormat.format(dateCellValue);
				
				}else {
					double numericCellValue = cell.getNumericCellValue();
					long ref = (long)numericCellValue;
					BigDecimal valueOf = BigDecimal.valueOf(ref);
					value = valueOf.toString();
				
			}
			break;

		default:
			System.out.println("invalid cell type");
			break;
		}
		return value;
	}
	public void clickButton(WebElement element) {
	 element.click();
		
	}

	public void selectByVisibleText(WebElement element, String readExcel) {
        Select select = new Select(element);
        select.selectByVisibleText(readExcel);
    }
	
	public void click(WebElement element) {
		element.click();
	}
	
	public void sleep(int millis) throws InterruptedException {
		Thread.sleep(millis);
	}
	
	
	public void confirmAlert(String values) {
		 Alert a = driver.switchTo().alert();
		switch (values) {
		case "accept":
			a.accept();
			break;
		case"dismiss":
			a.dismiss();
			break;

		default:
			break;
		}
	

	}
	
	
	}
	
	
	


	

























