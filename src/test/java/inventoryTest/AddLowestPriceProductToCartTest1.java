package inventoryTest;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import genericutilities.FileUtility;
import genericutilities.SeleniumUtility;
import objectRepository.CartPage;
import objectRepository.InventoryItemPage;
import objectRepository.InventoryPage;
import objectRepository.LoginPage;

public class AddLowestPriceProductToCartTest1 //without base file
{
	@Test(groups="RegressionSuite")
	public void tc_002AddLowestPriceProductToCartTest() throws IOException
	{
		     //Create Object Of Utilities
				FileUtility fUtil =new FileUtility();
				SeleniumUtility sUtil=new SeleniumUtility();
				
				
		    //read the common data from property file
				String URL = fUtil.readDataFromPropertyFile("url");
				String USERNAME = fUtil.readDataFromPropertyFile("username");
				String PASSWORD = fUtil.readDataFromPropertyFile("password");
				
		     //read the test data from excel file
				String SORTOPTION = fUtil.readDataFromExcelFile("items", 5, 2);
				String PRODUCTNAME = fUtil.readDataFromExcelFile("items", 5, 3);
				
			//Launch the browser
				WebDriver driver=new EdgeDriver();
				sUtil.maximizeWindow(driver);
				sUtil.addImplicitywait(driver);
						
			//Load the URL	
				driver.get(URL);
					
			//Login to Application
				LoginPage lp= new LoginPage(driver);
	             lp.loginToApplication(USERNAME, PASSWORD);
	             
			//Choose the sort option from dropdown
	             InventoryPage ip=new InventoryPage(driver);   
					ip.clickOnLowestPriceProduct(driver, SORTOPTION, PRODUCTNAME);
					
				   //Click on the product 
		              
		              ip.clickOnAProduct(driver, PRODUCTNAME);
		              
		         // Add Product to cart 
		              InventoryItemPage iip= new InventoryItemPage(driver);
		              iip.clickOnAddToCartBtn();
	            // Navigate to Cart
		              ip.clickOnCartContainerBtn();

	           //Validate for the product in cart
		              CartPage cp=new CartPage(driver);
		              String productIncart = cp.captureItemName();
		
								if(productIncart.equals(PRODUCTNAME))
									
								{
									System.out.println(productIncart);
									System.out.println("Pass");
								}
								else 
								{
								    System.out.println("fail");
								  
							    }
		
	             //Logout the application
		                 ip.logoutOfApp();
	        }
}
