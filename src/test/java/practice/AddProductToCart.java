package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.edge.EdgeDriver;

public class AddProductToCart {

	public static void main(String[] args) 
	
	{
		
		WebDriver driver=new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.get("https://www.saucedemo.com/");
		
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
		
		driver.findElement(By.id("item_4_title_link")).click();
		driver.findElement(By.id("add-to-cart")).click();
		
		driver.findElement(By.id("shopping_cart_container")).click();
		
		String productIncart = driver.findElement(By.className("inventory_item_name")).getText();
		if(productIncart.equals("Sauce Labs Backpack"))
			
		{
			System.out.println(productIncart);
			System.out.println("Pass");
		}
		else 
		{
		    System.out.println("fail");
		  
	    }
		driver.findElement(By.id("react-burger-menu-btn")) .click();
		driver.findElement(By.id("logout_sidebar_link")) .click();
}
}