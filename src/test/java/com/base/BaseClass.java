package com.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.apache.log4j.Logger;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.util.ExtentManager;
import com.util.Xls_Reader;

public class BaseClass {

	public static Properties config = new Properties();
	public static Xls_Reader excel = null;
	public static Logger app_logs = Logger.getLogger("BaseClass");
	public static ExtentReports e_report = ExtentManager.getInstance();
	public static ExtentTest test;
	
	
	@BeforeSuite()
	public static void init() throws IOException {
		if (DriverInit.Driver == null) {
			// load config property file
			FileInputStream fis = new FileInputStream(
			System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\config.properties");
			config.load(fis);
			app_logs.debug("loading the config property file");
			
			// load excel file
			excel = new Xls_Reader(
			System.getProperty("user.dir") + "\\src\\test\\resources\\excel\\testdata.xlsx");
			app_logs.debug("loading the excel file");

			if (config.getProperty("browser").equals("chrome")) {
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\test\\resources\\browser_drivers\\chromedriver.exe");
				DriverInit.Driver = new ChromeDriver();
			} else if (config.getProperty("browser").equals("firefox")) {
				System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\src\\test\\resources\\browser_drivers\\geckodriver.exe");
				DriverInit.Driver = new FirefoxDriver();
			} else if (config.getProperty("browser").equals("edge")) {
				System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") + "\\src\\test\\resources\\browser_drivers\\MicrosoftWebDriver.exe");
				DriverInit.Driver = new EdgeDriver();
			}
			
			DriverInit.Driver.get(config.getProperty("testsiteURL"));
			DriverInit.Driver.manage().window().maximize();

			// Global implicit Wait
			DriverInit.Driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}
	}

	@AfterSuite()
	public static void tearDown() throws AddressException, MessagingException, IOException {
		//MonitoringMail mail = new MonitoringMail();
		/*String fileName = getRandomString(10) + ".png";
		File scrFile = ((TakesScreenshot) DriverInit.Driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File("C:\\Users\\Naresh\\oxygen-workspace\\com.framework\\src\\test\\resources\\screenshots\\" +fileName));*/
		//mail.sendMail(TestConfig.server, TestConfig.from, TestConfig.to, TestConfig.subject, TestConfig.messageBody,
		//		TestConfig.attachmentPath, TestConfig.attachmentName);
		DriverInit.Driver.quit();	}
	
	public static String getRandomString(int length) {
		StringBuilder sb = new StringBuilder();
		String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
		for (int i = 0; i < length; i++) {
			int index = (int) (Math.random() * characters.length());
			sb.append(characters.charAt(index));
		}
		return sb.toString();
	}
	
	@DataProvider()
	public Object[][] getData() {
		String sheetName = "LoginTest";
		int rows = excel.getRowCount(sheetName);
		int cols = excel.getColumnCount(sheetName);
		Object data[][] = new Object[rows - 1][cols];
		for (int rowNum = 2; rowNum <= rows; rowNum++) {

			for (int colNum = 0; colNum < cols; colNum++) {
				data[rowNum - 2][colNum] = excel.getCellData(sheetName, colNum, rowNum);
			}
		}
		return data;
	}
	
	
}
