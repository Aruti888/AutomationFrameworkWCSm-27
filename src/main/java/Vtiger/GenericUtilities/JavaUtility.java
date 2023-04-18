package Vtiger.GenericUtilities;

/**
 * This class consists of generic method related to java
 * @author Dell
 *
 */

import java.util.Date;
import java.util.Random;


public class JavaUtility {
	/**
	 * This method is return the random number after every run
	 * @author Dell
	 */

	
	public int getRandomNumber() {
		Random r = new Random();
		return r.nextInt(1000);
	}
	
	/**
	 * This method will return the system current date
	 * @return
	 */
	public String getSystemDate() {
		Date d = new Date();
		return d.toString();
		
	}
	/**
	 * This method will return the system current date in the specified format
	 * @return
	 */
	
	public String getSystemDateInFormat() {
		Date d =new Date();
		String[] dArr=d.toString().split(" ");
		String date=dArr[2];
		String month = dArr[1];
		String year = dArr[5];
		String time = dArr[3].replace(":", "-");
		String dateValue = date+"-"+month+"-"+year+"-"+time;
		return dateValue;
	}
}
