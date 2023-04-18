package Vtiger.Practice;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Vtiger.ObjectRepository.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class POMClassPractice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://localhost:8888");
		
		LoginPage lp = new LoginPage(driver);
		//lp.getUserNameEdt().sendKeys("admin");
		//lp.getPasswordEdt().sendKeys("admin");
		//lp.getSubmitBtn().click();
		
		lp.loginToApp("admin", "admin");
		
		
		

	}

}
