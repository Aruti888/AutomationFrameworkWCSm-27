package Vtiger.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Vtiger.GenericUtilities.WebDriverUtility;

public class CreateNewContactPage extends WebDriverUtility {
	
	//declaration
	@FindBy(name = "lastname")
	private WebElement lastNameEdt;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement SaveBtn;
	
	@FindBy(xpath = "//input[@name='account_name']/following-sibling::Img[@title='Select']")
	private WebElement OrgLookUpImg;
	
	@FindBy(name = "search_text")
	private WebElement OrgSearchEdt;
	
	@FindBy(name = "search")
	private WebElement OrgSearchBtn;
	
	//initialization
	public CreateNewContactPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
    
	//utilization
	public WebElement getLastNameEdt() {
		return lastNameEdt;
	}

	public WebElement getSaveBtn() {
		return SaveBtn;
	}

	public WebElement getOrgLookUpImg() {
		return OrgLookUpImg;
	}

	public WebElement getOrgSearchEdt() {
		return OrgSearchEdt;
	}

	public WebElement getOrgSearchBtn() {
		return OrgSearchBtn;
	}
	
	//Business libraries
	public void createNewContact(String LASTNAME) {
		lastNameEdt.sendKeys(LASTNAME);
		SaveBtn.click();
	}
	
	public void createNewContact(WebDriver driver, String LASTNAME, String ORGNAME) {
		lastNameEdt.sendKeys(LASTNAME);
		OrgLookUpImg.click();
		switchTowindow(driver, "Accounts");
		OrgSearchEdt.sendKeys(ORGNAME);
		OrgSearchBtn.click();
		driver.findElement(By.xpath("//a[.='"+ORGNAME+"']")).click();
		switchTowindow(driver, "Contacts");
		SaveBtn.click();
	}

}
