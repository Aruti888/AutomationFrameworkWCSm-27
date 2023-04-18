package Vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Vtiger.GenericUtilities.WebDriverUtility;

public class CreateNewOrganizationsPage extends WebDriverUtility {
	
	//declaration
	@FindBy(name = "accountname")
	private WebElement OrgNameEdt;
	
	@FindBy(name = "industry")
	private WebElement IndustryDropDwn;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement SaveBtn;
	
	//initialization
	public CreateNewOrganizationsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
    
	//utilization
	public WebElement getOrgNameEdt() {
		return OrgNameEdt;
	}

	public WebElement getIndustryDropDwn() {
		return IndustryDropDwn;
	}

	public WebElement getSaveBtn() {
		return SaveBtn;
	}
	
	//Business library
	/**
	 * This method will create organization with mandatory information
	 * @param ORGNAME
	 */
	public void createNewOrganization(String ORGNAME ) {
		OrgNameEdt.sendKeys(ORGNAME);
		SaveBtn.click();
	}
	/**
	 * This method will create Organization with industry drop down
	 * @param ORGNAME
	 * @param INDUSTRY
	 */
	public void createNewOrganization(String ORGNAME, String INDUSTRY) {
		OrgNameEdt.sendKeys(ORGNAME);
		handleDropdown(IndustryDropDwn, INDUSTRY);
		SaveBtn.click();
	
	}
	
	
	

}
