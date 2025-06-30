package inventoryTest;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import genericutilities.FileUtility;
import genericutilities.SeleniumUtility;
import objectRepository.CartPage;
import objectRepository.InventoryItemPage;
import objectRepository.InventoryPage;
import objectRepository.LoginPage;

public class AddProductToCartTest1 //without base class
{
public void tc_001AddProductToCartTest() throws IOException
	
	{
			//Create Object Of Utilities
			FileUtility fUtil =new FileUtility();
			SeleniumUtility sUtil=new SeleniumUtility();


	     //read the common data from property file
			String URL = fUtil.readDataFromPropertyFile("url");
			String USERNAME = fUtil.readDataFromPropertyFile("username");
			String PASSWORD = fUtil.readDataFromPropertyFile("password");
//			
          //read the test data from excel file
			String PRODUCTNAME = fUtil.readDataFromExcelFile("items", 1, 2);
			
        //Launch the browser
			WebDriver driver=new EdgeDriver();
			sUtil.maximizeWindow(driver);
			sUtil.addImplicitywait(driver);
			
			//Load the URL	
				driver.get(URL);

           //Login to Application

                 LoginPage lp= new LoginPage(driver);
	             lp.loginToApplication(USERNAME, PASSWORD);

            //Click on the product 
	              InventoryPage ip=new InventoryPage(driver);
	              ip.clickOnAProduct(driver, PRODUCTNAME);
	              
	         // Add Product to cart 
	              InventoryItemPage iip= new InventoryItemPage(driver);
	              iip.clickOnAddToCartBtn();
            // Navigate to Cart
	              ip.clickOnCartContainerBtn();

           //Validate for the product in cart
	              CartPage cp=new CartPage(driver);
	              String productIncart = cp.captureItemName();
	              
	              Assert.assertEquals(productIncart, PRODUCTNAME);
	              System.out.println(productIncart);
	              
	             
	
//							if(productIncart.equals(PRODUCTNAME))
//								
//							{
//								System.out.println(productIncart);
//								System.out.println("Pass");
//							}
//							else 
//							{
//							    System.out.println("fail");
//							  
//						    }
	
             //Logout the application
	                 ip.logoutOfApp();
	              
	             
	             
	              
	              
        }
	 @Test 
     public void sample()
     {
   	  System.out.println("Demo");
     }

	

}


