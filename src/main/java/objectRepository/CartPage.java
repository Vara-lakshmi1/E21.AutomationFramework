package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage 

{
 // Rule 2
	@FindBy(className = "inventory_item_name")private WebElement itemInfo;
	@FindBy(id = "remove-sauce-labs-backpack")private WebElement remBtn;
	@FindBy(id = "checkout")private WebElement checkoutBtn;
	
	//Rule 3
	public CartPage (WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	//Rule 4

	public WebElement getRemBtn() {
		return remBtn;
	}

	public WebElement getItemInfo() {
		return itemInfo;
	}

	public void setItemInfo(WebElement itemInfo) {
		this.itemInfo = itemInfo;
	}

	public WebElement getCheckoutBtn() {
		return checkoutBtn;
	}
	//Business Library
	public void clickOnRemoveBtn()
	{
		remBtn.click();
	}
	public String captureItemName()
	{
		return itemInfo.getText();
	}
}
