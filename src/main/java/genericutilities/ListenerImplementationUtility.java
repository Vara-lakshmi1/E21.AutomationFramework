package genericutilities;

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
 * This class provides implememtation to ITestlistener interface of TestNG
 * @author LENOVO
 *
 */
public class ListenerImplementationUtility implements ITestListener

{
	ExtentReports report;
	ExtentTest test;
	public void onTestStart(ITestResult result) 
	
	{  //Capture the method name
		String methodname = result.getMethod().getMethodName();
		System.out.println(methodname+"Test Execution Started");
		//Create Test in Extent Reports
		test=report.createTest(methodname);
	}

	public void onTestSuccess(ITestResult result) 
	
	{     //Capture the method name
		 String methodname = result.getMethod().getMethodName();
		System.out.println(methodname+"Test Pass");
		
		//Log the test Status as Pass in Extent Reports
		test.log(Status.PASS, methodname+"-Test Pass");
	}

	public void onTestFailure(ITestResult result) 
	{   
		//Capture the method name
		 String methodname = result.getMethod().getMethodName();
		System.out.println(methodname+"Test Fail ");
		
		//Log the test Status as fail in Extent Reports
			test.log(Status.FAIL, methodname+"-Test Fail");
			
		//Capture the Exception
		System.out.println(result.getThrowable());
		
		//Log The Exception in Extent Report
		test.log(Status.WARNING,result.getThrowable());
		
		//Capture the Screenshot 
		SeleniumUtility s=new SeleniumUtility();
		JavaUtility j=new JavaUtility();
		
		//Configration the Screenshot name
		String screenshotName=methodname+"-"+j.getSystemDate();
		try {
			String path = s.captureScreenShot(BaseClass.sDriver, screenshotName);

		
		//Attach the ScreenShot to Extent Report
		test.addScreenCaptureFromPath(path, screenshotName);
		
		    }
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void onTestSkipped(ITestResult result) 
	{    
		//Capture the method name
		 String methodname = result.getMethod().getMethodName();
		System.out.println(methodname+"Test Skip");
		
		//Log the test status as Skip in Extent reports
		test.log(Status.SKIP, methodname+"-Test Skip");
		
		//Capture the Exception
		System.out.println(result.getThrowable());
		
		//Log The Exception in Extent Report
			test.log(Status.WARNING,result.getThrowable());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) 
	{
		
	}

	public void onTestFailedWithTimeout(ITestResult result) 
	{
		
	}

	public void onStart(ITestContext context) 
	{
	 
	System.out.println("Suite Execution Start ");
	//basic configration of Extent Report
	ExtentSparkReporter esr=new ExtentSparkReporter(".\\ExtentReports\\Report -"+new JavaUtility().getSystemDate()+".html");
	esr.config().setDocumentTitle("Swag Labs Execution Report");
	esr.config().setTheme(Theme.DARK);
	esr.config().setReportName("Swag Labs Automation Framework Execution");
	
	//configure Extent report
	 report=new ExtentReports();
	report.attachReporter(esr);
	report.setSystemInfo("Base Platform ", "Windows");
	report.setSystemInfo("Base Browser", "MicroSoft Edge");
	report.setSystemInfo("Base Env", "Test Env");
	report.setSystemInfo("Reporter Name", "Vara");
	}

	public void onFinish(ITestContext context) 
	{
	 
    System.out.println("Suite Execution finish");
    //Generate Extent Report
    report.flush();
	}

	
			  
}
