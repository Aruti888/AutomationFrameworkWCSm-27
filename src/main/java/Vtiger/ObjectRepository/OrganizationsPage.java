package Vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationsPage {
	
	//declaration
	@FindBy(xpath = "//img[@alt='Create Organization...']")
	private WebElement CreateOrgLookUpImg;
	
	
	//initialization
	public OrganizationsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//utilization
	public WebElement getCreateOrgLookUpImg() {
		return CreateOrgLookUpImg;
	}
	
	//Business library
	/**
	 * This method will click on create organization look up image
	 */
	public void clickOnCreateOrganizationLookUpImg() {
		CreateOrgLookUpImg.click();
	}
	

}
