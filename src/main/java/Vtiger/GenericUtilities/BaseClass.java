package Vtiger.GenericUtilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;


import Vtiger.ObjectRepository.HomePage;
import Vtiger.ObjectRepository.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	//Step 1 : Create object of Generic Utilities
	public ExcelFileUtility eUtil = new ExcelFileUtility();
	public PropertyFileUtility pUtil = new PropertyFileUtility();
	public JavaUtility jUtil = new JavaUtility();
	public WebDriverUtility wUtil = new WebDriverUtility();
	
	public WebDriver driver = null;
	public static WebDriver sDriver; //This is for Listeners
	
	@BeforeSuite(alwaysRun = true)
	public void bsConfig() 
	{
		System.out.println("---------------Database Connection Successful---------");
	}
	
	//@Parameters("browser")
	//@BeforeTest
	@BeforeClass(groups = {"SmokeSuite", "RegressionSuite"})
	public void bcConfig(/*String BROWSER*/) throws IOException 
	{
		String URL=pUtil.readDataFromPropertyFile("url");
		String BROWSER=pUtil.readDataFromPropertyFile("browser");
		
		//Step 2 : launch the browser - Runtime Polymorphism
		if(BROWSER.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			System.out.println("----- "+BROWSER+" Launched------");
		}
		else if(BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			System.out.println("----- "+BROWSER+" Launched------");
		}
		else {
			System.out.println("Invalid Browser name");
		}
		
		sDriver = driver; // this is for listeners
		wUtil.maximizeWindow(driver);
		wUtil.waitForPageLoad(driver);
		driver.get(URL);
		}
	
	@BeforeMethod(groups = {"SmokeSuite", "RegressionSuite"})
	public void bmConfig() throws IOException
	{
		String USERNAME=pUtil.readDataFromPropertyFile("username");
		String PASSWORD=pUtil.readDataFromPropertyFile("password");
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		System.out.println("--Login to App successfully---");
	}
	
	@AfterMethod(groups = {"SmokeSuite", "RegressionSuite"})
	public void amConfig()
	{
		HomePage hp = new HomePage(driver);
		hp.logoutOfApp(driver);
		System.out.println("--Log out app Successful--");
	}
	
	//@AfterTest
	@AfterClass(groups = {"SmokeSuite", "RegressionSuite"})
	public void acConfig()
	{
		driver.quit();
		System.out.println("browser closed");
	}
	@AfterSuite(groups = {"SmokeSuite", "RegressionSuite"})
	public void asConfig()
	{
		System.out.println("------------Datbase closed Successful-");
	}
	}

	
