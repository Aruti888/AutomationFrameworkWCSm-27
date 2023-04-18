package Vtiger.Practice;

import java.io.FileInputStream;
import java.util.Properties;


public class PropertyFilePractice {

	public static void main(String[] args) throws java.io.IOException {
		// TODO Auto-generated method stub
		//Step 1 : load the file in java readable formate using file input stream
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		
		//step 2 : create an object of properties from java.util
		Properties pOj = new Properties();
		
		//step 3 : load file input stream into properties
		pOj.load(fis);
		
		//step 4 : using the keys read the value
		String BROWSER = pOj.getProperty("browser");
		System.out.println(BROWSER);
		
		
		
		
		
        
	}

}
