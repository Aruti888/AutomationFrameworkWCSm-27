package Vtiger.ObjectRepository;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfoPage {
	
	//declaration
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement OrgHeaderText;
	
	//initialization
	public OrganizationInfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}
    
	//utilization
	public WebElement getOrgHeaderText() {
		return OrgHeaderText;
	}
	
	//Business library
	public String getOrgHeader() {
		return OrgHeaderText.getText();
	}
	

}
