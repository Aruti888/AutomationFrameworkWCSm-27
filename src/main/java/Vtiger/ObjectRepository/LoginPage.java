package Vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage { //Rule 1 : create a seperate pom class for every web page
	
	//Rule 2 : Identify all the webelements using annotations
    @FindBy(name = "user_name")
    private WebElement UserNameEdt;
    
    @FindBy(name = "user_password")
    private WebElement PasswordEdt;
    
    @FindAll({@FindBy(id = "submitButton"),@FindBy(xpath="//input[@type='submit']")})
    private WebElement SubmitBtn;
	
    //Rule 3 : initialize these webelements using constructor
    public LoginPage(WebDriver driver)
    {
    	PageFactory.initElements(driver, this);
    }
    
    //Rule 4 : provide getters to acces these elements
	public WebElement getUserNameEdt() {
		return UserNameEdt;
	}

	public WebElement getPasswordEdt() {
		return PasswordEdt;
	}

	public WebElement getSubmitBtn() {
		return SubmitBtn;
	}
    // Business Library - Generic method - Project Specific
	public void loginToApp(String USERNAME, String PASSWORD) {
		
	UserNameEdt.sendKeys(USERNAME);
	PasswordEdt.sendKeys(PASSWORD);
	SubmitBtn.click();
	}
	
	
	
}
