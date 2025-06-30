package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{
	//Rule 2
	//Declaration
       @FindBy(id="user-name")private WebElement usernameEdt;
	   @FindBy(id="password")private WebElement passwordEdt;
	   @FindBy(name="login-button") private WebElement loginBtn;
	   
	 //Rule3
	 //initiation
	   public LoginPage(WebDriver driver)
	   {
		   PageFactory.initElements(driver, this);
	   }
	   
	 
	//Rule4 
     //Utiliation
		public WebElement getUsernameEdt() 
		{
			return usernameEdt;
		}
	
		public WebElement getPasswordEdt() 
		{
			return passwordEdt;
		}
	
		public WebElement getLoginEdt() 
		{
			return loginBtn;
		}
	   
	 // Business Library _Generic Method _Project Specific
		/**
		 * This method perform Login application
		 * @param us
		 * @param ps
		 */
	   public void loginToApplication(String us,String ps)
	   {
		   usernameEdt.sendKeys(us);
		   passwordEdt.sendKeys(ps);
		   loginBtn.click();
	   }
}
