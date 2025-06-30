package genericutilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import objectRepository.InventoryPage;
import objectRepository.LoginPage;

public class BaseClass
{
   public FileUtility fUtil=new FileUtility();
   public JavaUtility jUtil=new JavaUtility();
   public SeleniumUtility sUtil=new SeleniumUtility();
   
   public WebDriver driver;
   //For Listeners 
   public static WebDriver sDriver;
   
   @BeforeSuite(alwaysRun=true)//(groups="SmokeSuite")
   public void bsConfig()
   {
	   System.out.println("----------------Database connection successful-----------");
	   
   }
   
  // @Parameters("Browser")
  // @BeforeTest
   @BeforeClass(alwaysRun=true)//(groups="SmokeSuite")
   public void bcConfig() throws IOException//public void bcConfig(String pValue) throws IOException  for cross browser
   {
	   
	   String URL = fUtil.readDataFromPropertyFile("url");
	   //driver=new EdgeDriver();
	   
	   driver=new FirefoxDriver();
//	   //for cross browser execution
//	   if(pValue.equals("edge"))
//	   {
//		   driver=new EdgeDriver(); 
//	   }
//	   else if(pValue.equals("firefox"))
//	   {
//		   driver=new FirefoxDriver();
//	   }
//	   else
//	   {
//		   driver=new EdgeDriver(); 
//	   }
	   sUtil.maximizeWindow(driver); 
	   sUtil.addImplicitywait(driver);
	   
	   driver.get(URL);
	   
	   System.out.println("------------Browser Lunched Sucessfully-----------------");
	   //For Listener
       sDriver = driver; 
   }

	  
	      
      @BeforeMethod(alwaysRun=true)//(groups="SmokeSuite")
   public void bmConfig() throws IOException
   {
	  String USERNAME = fUtil.readDataFromPropertyFile("username");
	  String PASSWORD = fUtil.readDataFromPropertyFile("password");
	  
	  LoginPage lp=new LoginPage(driver);
	  lp.loginToApplication(USERNAME, PASSWORD);
	  
	  System.out.println("-----------Login to Application successful--------------");
   }
      
   @AfterMethod(alwaysRun=true)//or (groups="SmokeSuite")
   public void amConfig()
   {
	   InventoryPage ip=new InventoryPage(driver);
	   ip.logoutOfApp();
	   System.out.println("-----------Logout of Application successful--------------");
   }
   
  // @AfterTest
  @AfterClass(alwaysRun=true)
   public void acConfig()
   {
	   
	   driver.quit();
	   System.out.println("------------Browser closure Sucessfully-----------------");
	   
	   
   }
   @AfterSuite(alwaysRun=true)
   public void asConfig()
   {
	   
	   System.out.println("----------------Database closure successful-----------");
	    
   }
}
