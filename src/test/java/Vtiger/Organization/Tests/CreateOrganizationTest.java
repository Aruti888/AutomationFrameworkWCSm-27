package Vtiger.Organization.Tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import Vtiger.GenericUtilities.BaseClass;
import Vtiger.ObjectRepository.CreateNewOrganizationsPage;
import Vtiger.ObjectRepository.HomePage;
import Vtiger.ObjectRepository.OrganizationInfoPage;
import Vtiger.ObjectRepository.OrganizationsPage;

@Listeners(Vtiger.GenericUtilities.ListenersImplemetation.class)
public class CreateOrganizationTest extends BaseClass {
	
	@Test(groups = "SmokeSuite") 
	public void createOrgTest() throws IOException{
		
		
		String ORGNAME=eUtil.readDataFromExcel("Organizations", 1, 2)+jUtil.getRandomNumber();
		
				
		//Step 3: Navigate to Organizations link
        HomePage hp = new HomePage(driver);
        hp.clickOnOrganizationLink();
        Reporter.log("Navigated to Organizations link", true); //printed in report
				
		//Step 4: Click on Create Organization Look up Image
		OrganizationsPage op = new OrganizationsPage(driver);
		op.clickOnCreateOrganizationLookUpImg();
		Reporter.log("Clicked on create Organization look up image");
		
		//Assert.fail(); // This is for low level reporting
				
		//Step 5: Create organization with mandatory Fields
		CreateNewOrganizationsPage cnop = new CreateNewOrganizationsPage(driver);
		cnop.createNewOrganization(ORGNAME);
		Reporter.log("New Organization is created");
				
		//Step 7: Validate for Organization
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String OrgHeader=oip.getOrgHeader();
		Assert.assertTrue(OrgHeader.contains(ORGNAME));	

	}
	
	@Test
	public void demo()
	{
		System.out.println("demo");
	}

}		

		
		


