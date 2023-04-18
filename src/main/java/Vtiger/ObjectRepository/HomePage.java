package Vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Vtiger.GenericUtilities.WebDriverUtility;

public class HomePage extends WebDriverUtility {
	
	//Declaration
	@FindBy(linkText = "Organizations")
	private WebElement OrganizationsLnk;
	
	@FindBy(linkText = "Contacts")
	private WebElement ContactsLnk;
	
	@FindBy(linkText = "Opportunities")
	private WebElement OpportunitiesLnk;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement AdministratorImg;
	
	@FindBy(linkText = "Sign Out")
	private WebElement SignOutLnk;
	
	//initialization
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//utilization
	public WebElement getOrganizationsLnk() {
		return OrganizationsLnk;
	}

	public WebElement getContactsLnk() {
		return ContactsLnk;
	}

	public WebElement getOpportunitiesLnk() {
		return OpportunitiesLnk;
	}

	public WebElement getAdministratorImg() {
		return AdministratorImg;
	}

	public WebElement getSignOutLnk() {
		return SignOutLnk;
	}
	
	//Business library
	/**
	 * This method will click on organization link
	 */
	public void clickOnOrganizationLink() {
		OrganizationsLnk.click();
	}
	public void clickOnContactLink() {
		ContactsLnk.click();
	}
	/**
	 * This method will perform sign out operation on web page
	 * @param driver
	 */
	public void logoutOfApp(WebDriver driver) {
		mouseHoverAction(driver, AdministratorImg);
		SignOutLnk.click();
	}
	

}
