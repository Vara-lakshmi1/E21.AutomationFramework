package objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericutilities.SeleniumUtility;

public class InventoryPage extends SeleniumUtility//Rule 1
{
	//Rule 2
// @FindBy(xpath = "//div [.='Sauce Labs Backpack']")private WebElement ProductN1;
 @FindBy(className = "product_sort_container")private WebElement sortDrop;
 @FindBy(id = "shopping_cart_container")private WebElement cartCont;
 @FindBy(id = "react-burger-menu-btn")private  WebElement menuBtn;
 @FindBy(id = "logout_sidebar_link")private WebElement logoutLink;
    //Rule 3
	public InventoryPage(WebDriver driver)
	     {
		   PageFactory.initElements(driver,this);
		 }
   //Rule 4

	public WebElement getSortDrop() {
		return sortDrop;
	}

	public WebElement getCartCont() {
		return cartCont;
	}

	public WebElement getMentBtn() {
		return menuBtn;
	}

	public WebElement getLogoutLink() {
		return logoutLink;
	}
	
    //Business Library
	public void logoutOfApp()
	{
		menuBtn.click();
		logoutLink.click();
	}
    public void clickOnCartContainerBtn()
    {
    	cartCont.click();
    }
    public void clickOnAProduct(WebDriver driver,String ProductName)//we use findelement for dynamic element
    {
    	driver.findElement(By.xpath("//div[.='"+ProductName+"']")).click();
    }
    public void clickOnLowestPriceProduct(WebDriver driver,String sortoption,String ProductName)
    {
    	handleDropdown(sortDrop, sortoption);
    	driver.findElement(By.xpath("//div[.='"+ProductName+"']")).click();
    }
}
