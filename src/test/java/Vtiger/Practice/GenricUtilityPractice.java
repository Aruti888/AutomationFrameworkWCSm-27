package Vtiger.Practice;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import Vtiger.GenericUtilities.ExcelFileUtility;
import Vtiger.GenericUtilities.JavaUtility;
import Vtiger.GenericUtilities.PropertyFileUtility;
import Vtiger.GenericUtilities.WebDriverUtility;

public class GenricUtilityPractice {

	public static void main(String[] args) throws Throwable, IOException {
		// TODO Auto-generated method stub
		PropertyFileUtility pUtil = new PropertyFileUtility();
		String data=pUtil.readDataFromPropertyFile("browser");
		String data1=pUtil.readDataFromPropertyFile("password");
		System.out.println(data);
		System.out.println(data1);
		
		ExcelFileUtility eUtil = new ExcelFileUtility();
		String value=eUtil.readDataFromExcel("Contact", 1, 2);
		System.out.println(value);
		
		eUtil.writeIntoExcel("Contact", 10, 7, value);
		System.out.println("data added");
		
		JavaUtility jUtil = new JavaUtility();
		System.out.println(jUtil.getRandomNumber());
		
		System.out.println(jUtil.getSystemDate());
		
		System.out.println(jUtil.getSystemDateInFormat());
		
		//WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new ChromeDriver();
		WebDriverUtility wUtil = new WebDriverUtility();
		wUtil.maximizeWindow(driver);
		Thread.sleep(3000);
		wUtil.minimizeWindow(driver);
		
		
		

	}

}
