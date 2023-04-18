package Vtiger.Practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class VtigerScenario4 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		//Step 1: Read all the neccessary Data
				/*Read the data from property file*/
				FileInputStream fisp = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
				Properties pObj = new Properties();
				pObj.load(fisp);
				String BROWSER = pObj.getProperty("browser");
				String URL = pObj.getProperty("url");
				String USERNAME = pObj.getProperty("username");
				String PASSWORD = pObj.getProperty("password");
				
				Random r = new Random();
				int value = r.nextInt(1000);
				
				/*Read the data from excel sheet*/
				FileInputStream fise = new FileInputStream(".\\src\\test\\resources\\Test Data.xlsx");
				Workbook wb = WorkbookFactory.create(fise);
				String ORGNAME = wb.getSheet("Organizations").getRow(1).getCell(2).getStringCellValue()+value;
				wb.close();
				
				WebDriver driver = null;
				
				//Step 1: Launch the browser
				if(BROWSER.equalsIgnoreCase("chrome"))
				{
					WebDriverManager.chromedriver().setup();
					driver = new ChromeDriver();
				}
				else if(BROWSER.equalsIgnoreCase("firefox"))
				{
					WebDriverManager.firefoxdriver().setup();
					driver = new FirefoxDriver();
				}
				else
				{
					System.out.println("Invalid Browser name");
				}
			    
				
		//Step 1 : Launch the browser
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(URL);
		
		//Step 2 : Login to application
		WebElement ele=driver.findElement(By.xpath("//input[@name='user_name']"));
		ele.sendKeys(USERNAME);
		WebElement element=driver.findElement(By.xpath("//input[@name='user_password']"));
		element.sendKeys(PASSWORD);
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		//Step 3: Navigate to Organizations link
		driver.findElement(By.xpath("//td[.='Organizations']")).click();
		
		//Step 4: Click on Create Organization Look up Image
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		
		//Step 5: Create organization with mandatory Fields
		WebElement orgname=driver.findElement(By.xpath("//input[@name='accountname']"));
		orgname.sendKeys(ORGNAME);
		
		WebElement industry=driver.findElement(By.xpath("//select[@name='industry']"));
		Select s=new Select(industry);
		s.selectByVisibleText("Energy");
		
		WebElement type=driver.findElement(By.xpath("//select[@name='accounttype']"));
		Select s1=new Select(type);
		s1.selectByValue("Customer");
		
		driver.findElement(By.xpath("//input[@value='T']")).click();
		WebElement assigngrp=driver.findElement(By.name("assigned_group_id"));
		Select ss=new Select(assigngrp);
		ss.selectByValue("4");
		
		//Step 6 : Save Organization
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]' and @class='crmbutton small save']")).click();
		
		//Step 7: Validate for Organization
		String OrgHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(OrgHeader.contains(ORGNAME))
		{
			System.out.println(OrgHeader+" ---- PASS ----");
		}
		else
		{
			System.out.println("---- Failed ----");
		}
			    
	    
		//driver.findElement(By.xpath("//a[@class='hdrLink' and text()='Organizations']")).click();
		//Step 8 : Logout of application
		WebElement imgmenu=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		WebElement signout=driver.findElement(By.xpath("//a[text()='Sign Out']"));
		
		Actions act=new Actions(driver);
		act.moveToElement(imgmenu).moveToElement(signout).click().perform();
		
		driver.quit();
		

	}

}
