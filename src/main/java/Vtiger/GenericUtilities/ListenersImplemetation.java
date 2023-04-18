package Vtiger.GenericUtilities;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

/**
 * This class provides implementation for the ITestListener interface of TestNG
 * @author Dell
 *
 */
public class ListenersImplemetation implements ITestListener
{
	ExtentReports report;
	ExtentTest test;

	
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
		String methodName=result.getMethod().getMethodName();
		//System.out.println(methodName+"----test script execution started----");
		
		test = report.createTest(methodName+"----test execution is started------");
		
	}

	
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
		String methodName=result.getMethod().getMethodName();
		
		test.log(Status.PASS, methodName+"----PASSED----");
		
	}

	public void onTestFailure(ITestResult result, String path) {
		// TODO Auto-generated method stub
		
		String methodName=result.getMethod().getMethodName();
		test.log(Status.FAIL, methodName+"---FAILED-----");
		test.log(Status.INFO, result.getThrowable());
		
		//System.out.println(methodName+"-----test script execution failed");
		//System.out.println(result.getThrowable());
		
		WebDriverUtility wUtil = new WebDriverUtility();
		String screenShotName=methodName+"-"+new JavaUtility().getSystemDateInFormat();
		
		try {
			wUtil.takeScreenShots(BaseClass.sDriver, screenShotName);
			test.addScreenCaptureFromPath(path); //go to the screenshot location and attached to the report
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
		String methodName=result.getMethod().getMethodName();
		test.log(Status.SKIP, methodName+"-----Skipped----");
		test.log(Status.INFO, result.getThrowable());
		
		//System.out.println(methodName+"-----test script execution skipped");
		//System.out.println(result.getThrowable());
	}

	
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}


	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
		System.out.println("-----Execution started-----");
		//Extent report Configuration
		ExtentSparkReporter htmlreporter = new ExtentSparkReporter(".\\ExtentReports\\Report-"+new JavaUtility().getSystemDateInFormat()+".html");
		htmlreporter.config().setDocumentTitle("Vtiger Execution Report");
		htmlreporter.config().setTheme(Theme.DARK);
		htmlreporter.config().setReportName("Automation Execution Report");
		
		report = new ExtentReports();
		report.attachReporter(htmlreporter);
		report.setSystemInfo("Base URl", "http://localhost:8888");
		report.setSystemInfo("Base Browser", "Edge");
		report.setSystemInfo("Base Platform", "Window");
		report.setSystemInfo("Reporter-Name", "Aarti");
	}

	
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
		System.out.println("-----Execution finished------");
		
		report.flush(); //generate the report
	}
	


	
}	


