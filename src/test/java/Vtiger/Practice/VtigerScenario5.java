package Vtiger.Practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

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

public class VtigerScenario5 {

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
				String LASTNAME = wb.getSheet("Contact").getRow(1).getCell(2).getStringCellValue()+value;
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
		driver.manage().window().maximize();
		
		//Step 2 : Login the application with valid credentials
		WebElement ele=driver.findElement(By.xpath("//input[@name='user_name']"));
		ele.sendKeys(USERNAME);
		WebElement element=driver.findElement(By.xpath("//input[@name='user_password']"));
		element.sendKeys(PASSWORD);
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		//Step 3 : Navigate to Contact link
		driver.findElement(By.xpath("//td[.='Contacts']")).click();
		
		//Step 4 : Click on Create Contact Look up Image
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		
		//Step 5 : Create Contact with mandatory Fields
		WebElement drpele=driver.findElement(By.name("salutationtype"));
		Select s= new Select(drpele);
		s.selectByVisibleText("Dr.");
		WebElement Ele=driver.findElement(By.xpath("//input[@name='firstname']"));
		Ele.sendKeys("Abc");
		WebElement Element=driver.findElement(By.xpath("//input[@name='lastname']"));
		Element.sendKeys(LASTNAME);
		
		//driver.findElement(By.xpath("//input[@name='account_name']"));
		String PID=driver.getWindowHandle();
		driver.findElement(By.xpath("//img[@title='Select' and @language='javascript']")).click();
		Set<String> allwh=driver.getWindowHandles();
		for (String id : allwh)
		{
			if(id!=PID)
			{
				driver.switchTo().window(id);
			}
			
		}
		
		driver.findElement(By.xpath("//a[.='Dell']")).click();
		driver.switchTo().window(PID);
		
		
		WebElement w=driver.findElement(By.xpath("//input[@id='email']"));
		w.sendKeys("Abc@gmail.com");
		
		
		driver.findElement(By.xpath("//input[@value='U']")).click();
		//boolean a = we.isSelected();
		//System.out.println(a);
		WebElement assignuser=driver.findElement(By.name("assigned_user_id"));
		Select s1=new Select(assignuser);
		s1.selectByVisibleText("Administrator");
		
		//Step 6 : Save Contact
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]' and @class='crmbutton small save']")).click();
		
		//Step 7 : Validate for Contact
		String ContHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(ContHeader.contains(LASTNAME))
		{
			System.out.println(ContHeader+" ---- PASS ----");
		}
		else
		{
			System.out.println("---- Failed ----");
		}
		
		//driver.findElement(By.xpath("//a[@class='hdrLink' and text()='Contacts']")).click();
		
		//Step 8 : Logout of application
		WebElement imgmenu=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		WebElement signout=driver.findElement(By.xpath("//a[text()='Sign Out']"));
		
		Actions act=new Actions(driver);
		act.moveToElement(imgmenu).moveToElement(signout).click().perform();
		
		
		

	}

}
