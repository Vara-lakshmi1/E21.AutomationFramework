package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InventoryItemPage //Rule 1
{
		//Rule 2
	   @FindBy(id = "add-to-cart")private WebElement addToCartBtn;
	   
	//Rule 3
	   public InventoryItemPage(WebDriver driver)
	   {
		   PageFactory.initElements(driver, this);
	   }
	   //Rule 4
	    public WebElement getAddToCartBtn() 
	    {
		return addToCartBtn;
	    }
	   //Business Library
	    public void clickOnAddToCartBtn()
	    {
	    	addToCartBtn.click();
	    }
}
