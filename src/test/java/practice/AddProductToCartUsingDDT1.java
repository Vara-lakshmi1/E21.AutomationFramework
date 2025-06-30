package practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import genericutilities.FileUtility;
import genericutilities.SeleniumUtility;
import objectRepository.LoginPage;

public class AddProductToCartUsingDDT1 
{
public static void main(String[] args) throws IOException 
	
	{
	
		//Create Object Of Utilities
			FileUtility fUtil =new FileUtility();
			SeleniumUtility sUtil=new SeleniumUtility();
	
	
		//read the common data from property file
				String URL = fUtil.readDataFromPropertyFile("url");
				String USERNAME = fUtil.readDataFromPropertyFile("username");
				String PASSWORD = fUtil.readDataFromPropertyFile("password");
				
	//read the test data from excel file
				String PRODUCTNAME = fUtil.readDataFromExcelFile("items", 1, 2);
				
	//Launch the browser
		WebDriver driver=new EdgeDriver();
		sUtil.maximizeWindow(driver);
		sUtil.addImplicitywait(driver);
		
	//Load the URL	
		driver.get(URL);
	
	//Login to Application
//		driver.findElement(By.id("user-name")).sendKeys(USERNAME);
//		driver.findElement(By.id("password")).sendKeys(PASSWORD);
//		driver.findElement(By.id("login-button")).click();
		
		LoginPage lp= new LoginPage(driver);
//		lp.getUsernameEdt().sendKeys(USERNAME);
//		lp.getPasswordEdt().sendKeys(PASSWORD);
//		lp.getLoginEdt().click();
		
		lp.loginToApplication(USERNAME, PASSWORD);
	
	//Click on the product and Add to cart
		//driver.findElement(By.id("item_4_title_link")).click();
		driver.findElement(By.xpath("//div[.='"+PRODUCTNAME+"']")).click();
		driver.findElement(By.id("add-to-cart")).click();
		
	// Navigate to Cart
		driver.findElement(By.id("shopping_cart_container")).click();
	
	//Validate for the product in cart
		String productIncart = driver.findElement(By.className("inventory_item_name")).getText();
		
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
		driver.findElement(By.id("react-burger-menu-btn")) .click();
		driver.findElement(By.id("logout_sidebar_link")) .click();
}
}
