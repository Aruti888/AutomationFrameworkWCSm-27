package Vtiger.Practice;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionsPractice {
	
	@Test
	public void practice()
	{
		System.out.println("step 1");
		System.out.println("step 2");
		Assert.assertEquals(false, true); // condition is pass actual = expected
		System.out.println("step 3");
		System.out.println("step 4");
	}
	
	@Test
	public void practice1()
	{
		SoftAssert sa = new SoftAssert();
		
		System.out.println("step 1 - Practice");
		sa.assertEquals("A", "c");
	
		System.out.println("step 2 - Practice");
		sa.assertEquals("A", "A"); //pass
		
		System.out.println("step 3 - Practice");
		sa.assertTrue(false); // fail
		
		System.out.println("step 4 - Practice");
		Assert.assertTrue(true);
		
		sa.assertAll(); // failures will be logged
	}

}
