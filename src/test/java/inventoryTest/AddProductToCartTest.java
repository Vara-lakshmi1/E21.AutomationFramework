package inventoryTest;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericutilities.BaseClass;
import genericutilities.FileUtility;
import genericutilities.SeleniumUtility;
import objectRepository.CartPage;
import objectRepository.InventoryItemPage;
import objectRepository.InventoryPage;
import objectRepository.LoginPage;
@Listeners(genericutilities.ListenerImplementationUtility.class)
public class AddProductToCartTest extends BaseClass {

	@Test(groups="SmokeSuite")
	public void tc_001AddProductToCartTest() throws IOException
	
	{		
          //read the test data from excel file
			String PRODUCTNAME = fUtil.readDataFromExcelFile("items", 1, 2);
			
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
	                      
	              
        }
	
					 @Test 
				     public void sample()
				     {
						
					  Assert.fail();
				   	  System.out.println("Demo");
				     }

	
	}


