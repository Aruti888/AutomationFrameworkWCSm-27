package Vtiger.Practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGPracticeTest {
	
	@Test
	public void createUsertest() {
		Assert.fail();
		System.out.println("user is created");
	}
	@Test(enabled = false)
	public void modifyUserTest() {
		System.out.println("user is modified");
	}
	@Test(priority = 1, dependsOnMethods = "createUsertest")
	public void deleteUserTest() {
		System.out.println("User is deleted");
	}

}
