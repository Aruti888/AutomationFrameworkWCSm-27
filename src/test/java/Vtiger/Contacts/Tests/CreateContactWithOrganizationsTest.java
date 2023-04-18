package Vtiger.Contacts.Tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import Vtiger.GenericUtilities.BaseClass;
import Vtiger.ObjectRepository.ContactsInfoPage;
import Vtiger.ObjectRepository.ContactsPage;
import Vtiger.ObjectRepository.CreateNewContactPage;
import Vtiger.ObjectRepository.CreateNewOrganizationsPage;
import Vtiger.ObjectRepository.HomePage;
import Vtiger.ObjectRepository.OrganizationInfoPage;
import Vtiger.ObjectRepository.OrganizationsPage;

@Listeners(Vtiger.GenericUtilities.ListenersImplemetation.class)
public class CreateContactWithOrganizationsTest extends BaseClass {
    
	@Test(groups = "RegressionSuite")
	public void createContWithOrgTest() throws IOException {
		// TODO Auto-generated method stub
		
		
				String LASTNAME = eUtil.readDataFromExcel("Contact", 4, 2);
				String ORGNAME=eUtil.readDataFromExcel("Organizations", 1, 2)+jUtil.getRandomNumber();
				
				
						
				//Step 5: Navigate to Organizations link
				HomePage hp = new HomePage(driver);
				hp.clickOnOrganizationLink();
						
				//Step 6: Click on Create Organization Look up Image
				OrganizationsPage  op = new OrganizationsPage(driver);
				 op.clickOnCreateOrganizationLookUpImg();
						
				//Step 7: Create organization with mandatory Fields
				CreateNewOrganizationsPage cnop = new CreateNewOrganizationsPage(driver);
				cnop.createNewOrganization(ORGNAME);
						
				
				//Step 8: Validate for Organization
				OrganizationInfoPage oip = new OrganizationInfoPage(driver);
				String OrgHeader = oip.getOrgHeader();
				Assert.assertTrue(OrgHeader.contains(ORGNAME));
							
				// Step 9: Navigate Contacts Link
				hp.clickOnContactLink();

				// Step 10: Click on create Contact Look Up Image
				ContactsPage cp = new ContactsPage(driver);
				cp.clickOnCreateContactLookUpImg();

				// Step 11: Create contact
				CreateNewContactPage cncp = new CreateNewContactPage(driver);
				cncp.createNewContact(driver, LASTNAME, ORGNAME);
				//wUtil.takeScreenShots(driver, "Screenshot1");

				// Step 12: Validate for Contacts
				ContactsInfoPage cip = new ContactsInfoPage(driver);
				String ContactHeader=cip.getContactHeader();
				Assert.assertTrue(ContactHeader.contains(LASTNAME));
				

				

	}

}
