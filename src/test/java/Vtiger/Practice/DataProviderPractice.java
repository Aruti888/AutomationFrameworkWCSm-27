package Vtiger.Practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderPractice {
	
	@Test(dataProvider = "getData")
	public void addToCart(String name, int price, int qty, String color, boolean isAvailable)
	{
		System.out.println("---"+name+"-"+price+"-"+qty+"-"+color+"-"+isAvailable+"---");
	}
	@DataProvider
	public Object[][] getData() 
	{
		Object[][] data = new Object[2][5];
		
		data[0][0] = "Samsung";
		data[0][1] = 12000;
		data[0][2] = 12;
		data[0][3] = "Black";
		data[0][4] = "true";
		
		data[1][0] = "Iphone";
		data[1][1] = 30000;
		data[1][2] = 11;
		data[1][3] = "silver";
		data[1][4] = "true";
		
		return data;
		
		
	}

}
