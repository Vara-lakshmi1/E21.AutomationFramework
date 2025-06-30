package inventoryTest;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
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
public class AddLowestPriceProductToCartTest extends BaseClass{

	@Test(groups="RegressionSuite")
	public void tc_002AddLowestPriceProductToCartTest() throws IOException
	{
		     
		     //read the test data from excel file
				String SORTOPTION = fUtil.readDataFromExcelFile("items", 5, 2);
				String PRODUCTNAME = fUtil.readDataFromExcelFile("items", 5, 3);
				
		
					
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
		
								if(productIncart.equals(PRODUCTNAME))
									
								{
									System.out.println(productIncart);
									System.out.println("Pass");
								}
								else 
								{
								    System.out.println("fail");
								  
							    }
		
	            
	        }
	}


