package Vtiger.GenericUtilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * This class consists of generic methods related to property file
 * @author Dell
 */

public class PropertyFileUtility {
	/**
	 * @param
	 * @return
	 * @throws IOException
	 */

	public String readDataFromPropertyFile(String key) throws IOException {
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties pObj = new Properties();
		pObj.load(fis);
		String value=pObj.getProperty(key);
		return value;

	}

}
