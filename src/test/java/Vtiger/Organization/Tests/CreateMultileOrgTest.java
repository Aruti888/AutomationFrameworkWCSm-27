package Vtiger.Organization.Tests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import Vtiger.GenericUtilities.BaseClass;
import Vtiger.GenericUtilities.ExcelFileUtility;
import Vtiger.GenericUtilities.JavaUtility;
import Vtiger.ObjectRepository.CreateNewOrganizationsPage;
import Vtiger.ObjectRepository.HomePage;
import Vtiger.ObjectRepository.OrganizationInfoPage;
import Vtiger.ObjectRepository.OrganizationsPage;

@Listeners(Vtiger.GenericUtilities.ListenersImplemetation.class)
public class CreateMultileOrgTest extends BaseClass {
	
	ExcelFileUtility eUtil = new ExcelFileUtility();
	JavaUtility jUtil = new JavaUtility();
	
	@Test(dataProvider = "OrgWithIndustry")
	public void createOrgTest(String ORG, String INDUSTRY) throws IOException {
		
		String ORGNAME = ORG+jUtil.getRandomNumber();
				
		//Step 3: Navigate to Organizations link
        HomePage hp = new HomePage(driver);
        hp.clickOnOrganizationLink();

				
		//Step 4: Click on Create Organization Look up Image
		OrganizationsPage op = new OrganizationsPage(driver);
		op.clickOnCreateOrganizationLookUpImg();
				
		//Step 5: Create organization with mandatory Fields
		CreateNewOrganizationsPage cnop = new CreateNewOrganizationsPage(driver);
		cnop.createNewOrganization(ORGNAME, INDUSTRY);
				
		//Step 7: Validate for Organization
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String OrgHeader=oip.getOrgHeader();
		Assert.assertTrue(OrgHeader.contains(ORGNAME));
			
	}
		@DataProvider(name = "OrgWithIndustry")
		public Object[][] getData() throws EncryptedDocumentException, IOException 
		{
			Object[][] data = eUtil.readDataFromExcelToDataProvider("dataProviderOrg");
			return data;
			
			//Driver.close();
		
	}
		
	

}
