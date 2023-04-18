package Vtiger.GenericUtilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This class consists of generic methods related to webdriver actions
 * @author Dell
 *
 */

public class WebDriverUtility {
	/**
	 * This method will maximize the window
	 * @param driver
	 */
	public void maximizeWindow(WebDriver driver) {
		driver.manage().window().maximize();
	}
	/**
	 * This method will minimize the window
	 * @param driver
	 */
	public void minimizeWindow(WebDriver driver ) {
		driver.manage().window().minimize();
	}
	/**
	 * This method will wait 20 seconds for page load
	 * @param driver
	 */
	public void waitForPageLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
	}
	/**
	 * This method will wait until the particular element to be visible
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeVisible(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(element));
		
	}
	/**
	 * This method will wait until the particular wait element is clickable
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeClickable(WebDriver driver, WebElement element) {
	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	 wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	/**
	 * This method will handle drop down index
	 * @param element
	 * @param index
	 */
	public void handleDropdown(WebElement element, int index) {
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}
	/**
	 * This method will handle drop down by value
	 * @param element
	 * @param value
	 */
	public void handleDropdown(WebElement element, String value) {
		Select sel = new Select(element);
		sel.selectByValue(value);
	}
	/**
	 * This method will handle drop down by visible  text
	 * @param text
	 * @param element
	 */
	public void handleDropdown(String text, WebElement element) {
		Select sel = new Select(element);
		sel.selectByVisibleText(text);
	}
	/**
	 * This method will perform mouseHover action on web element
	 * @param driver
	 * @param element
	 */
	public void mouseHoverAction(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}
	/**
	 * This method will perform right click on any where in the page
	 * @param driver
	 */
	public void rightClickAction(WebDriver driver) {
		Actions act = new Actions(driver);
		act.contextClick().perform();
	}
	/**
	 * This method will perform right click on perticular web element
	 * @param driver
	 * @param element
	 */
	public void rightClickAction(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.contextClick(element).perform();
	}
	/**
	 * This method will perform double click on web element
	 * @param driver
	 */
	public void doubleClickAction(WebDriver driver) {
		Actions act = new Actions(driver);
		act.doubleClick().perform();
	}
	/**
	 * This method will perform double click on perticular web element
	 * @param driver
	 * @param element
	 */
	public void doubleClickAction(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.doubleClick(element).perform();
	}
	/**
	 * This method will perform drag and drop action on web element
	 * @param driver
	 * @param srcElement
	 * @param dstElement
	 */
	public void dragAndDropAction(WebDriver driver, WebElement srcElement, WebElement dstElement ) {
		Actions act = new Actions(driver);
		act.dragAndDrop(srcElement, dstElement).perform();
	}
	/**
	 * This method will press the key
	 * @throws AWTException
	 */
	public void pressEnterKey() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
	}
	/**
	 * This method will release the key
	 * @throws AWTException
	 */
	public void releaseEnterKey() throws AWTException {
		Robot r = new Robot();
		r.keyRelease(KeyEvent.VK_ENTER);
	}
	/**
	 * This method will handle the frame with index
	 * @param driver
	 * @param index
	 */
	public void handleFrame(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}
	/**
	 * This method will handle the frame with id or name
	 * @param driver
	 * @param id
	 */
	public void handleFrame(WebDriver driver, String id) {
		driver.switchTo().frame(id);
	}
	/**
	 * This method will handle the frame with web element
	 * @param driver
	 * @param element
	 */
	public void handleFrame(WebDriver driver, WebElement element) {
		driver.switchTo().frame(element);
	}
	/**
	 * This method will switch to immediate parent frame
	 * @param driver
	 */
	public void handleParentFrame(WebDriver driver) {
		driver.switchTo().parentFrame();
	}
	/**
	 * This method will switch to default frame 
	 * @param driver
	 */
	public void handleDefaultFrame(WebDriver driver) {
		driver.switchTo().defaultContent();
	
	}
	/**
	 * This method will accept alert popup
	 * @param driver
	 */
	public void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	/**
	 * This method will dismiss alert popup
	 * @param driver
	 */
	public void dismissAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	/**
	 * This method will capture the return alert popup
	 * @param driver
	 * @param text
	 * @return
	 */
	public String getAlerttext(WebDriver driver, String text) {
		return driver.switchTo().alert().getText();
}
	/**
	 * This method will take screen shot and save it in screenshots folder
	 * @param driver
	 * @param screenshotName
	 * @return
	 * @throws IOException
	 */
	public String takeScreenShots(WebDriver driver, String screenshotName) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dst = new File(".\\Screenshots\\"+screenshotName+".png");
		FileUtils.copyFile(src, dst);
		return dst.getAbsolutePath();
	}
	public void switchTowindow(WebDriver driver, String partialWinTitle) {
		//Step 1 : capture all the window IDs
		Set<String> winIDs = driver.getWindowHandles();
		
		//Step 2 : use for each loop and navigate to each window
		for(String win:winIDs)
		{
			//step 3 : capture the title of each window
			String currentTitle=driver.switchTo().window(win).getTitle();
		
			//step 4 : compare the current Title with partial window title
			if(currentTitle.contains(partialWinTitle))
			{
				break;
			}
		}
	}
		public void scrollAction(WebDriver driver) {
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,500)", "");
	}
		public void scrollAction(WebDriver driver, WebElement element) {
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		int Y =element.getLocation().getY();
		jse.executeScript("window.scrollBy(0,"+Y+")", element);
		
		
		
		
	}
}

