package Vtiger.Practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RetryAnalyserPractice {
	
	@Test(retryAnalyzer = Vtiger.GenericUtilities.RetryAnalyserImplementation.class)
	public void sample()
	{
		Assert.fail();
		System.out.print("hi");
	}

}
