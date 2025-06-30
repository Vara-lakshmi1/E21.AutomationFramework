package genericutilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This class consist of generic method related to selenium
 * @author Vara
 *
 */

public class SeleniumUtility 

{
	
	
	/**
	 * This method will maximize the window
	 * @param driver
	 */
	 public void maximizeWindow(WebDriver driver)
	 {
		 driver.manage().window().maximize();
	 }
	 
	 
	 /**
		 * This method will minimize the window
		 * @param driver
		 */
		 public void minimizeWindow(WebDriver driver)
		 {
			 driver.manage().window().minimize();
		 }
		 
		 
		 
		 /**
			 * This method will fullscreen the window
			 * @param driver
			 */
			 public void fullScreenWindow(WebDriver driver)
			 {
				 driver.manage().window().fullscreen();
			 }
			 
			 
			 
			 /**
			  * This method will add Implicity wait for 10 seconds
			  * @param driver
			  */
			 public void addImplicitywait(WebDriver driver)
			 {
				 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			 }
			 
			 /**
			  * This method will wait for 10 seconds for element to be visible
			  * @param driver
			  */
			 public void waitForElementToBeVisible(WebDriver driver,WebElement element)
			 {
				 WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
				 wait.until(ExpectedConditions.visibilityOf(element));
			 }
			 
			 /**
			  * This method will wait for 10 seconds for element to be clickable
			  * @param driver
			  */
			 public void waitForElementToBeClickable(WebDriver driver,WebElement element)
			 {
				 WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
				 wait.until(ExpectedConditions.elementToBeClickable(element));
			 }
			 
			 /**
			  * This method handle Dropdown By index
			  * @param element
			  * @param index
			  */
			 public void handleDropdown(WebElement element,int index)
			 {
				 Select s=new Select(element);
				 s.selectByIndex(index);
			 }
			 /**
			  * This method handle Dropdown By visible Text
			  * @param element
			  * @param visible Text
			  */
			 public void handleDropdown(WebElement element,String visibleText)
			 {
				 Select s=new Select(element);
				 s.selectByVisibleText(visibleText);
			 }
			 /**
			  * This method handle Dropdown By value
			  * @param element
			  * @param value
			  */
			 public void handleDropdown(String value,WebElement element)
			 {
				 Select s=new Select(element);
				 s.selectByValue(value);
			 }
			 
			 /**
			  * This method perform mouse hovering action on Webelement
			  * @param driver
			  * @param element
			  */
			 public void mouseHoverAction(WebDriver driver,WebElement element)
			 {
				 Actions act=new Actions(driver);
				 act.moveToElement(element).perform();
			 }
			 /**
			  * This method perform mouse action to drag and drop the Webelement
			  * @param driver
			  * @param elementDrag
			  * @param elementDrop
			  */
			 public void dragAndDropAction(WebDriver driver,WebElement elementDrag,WebElement elementDrop)
			 {
				 Actions act=new Actions(driver);
				 act.dragAndDrop(elementDrag, elementDrop).perform();
			 }
			 /**
			  * This method perform mouse action to doubleclick the Webelement
			  * @param driver
			  * @param element
			  */
			 public void doubleClickAction(WebDriver driver,WebElement element)
			 {
				 Actions act=new Actions(driver);
				 act.doubleClick(element).perform();
			 }
			 /**
			  * This method perform mouse action to rightclick on Webelement
			  * @param driver
			  * @param element
			  */
			 public void rightClickAction(WebDriver driver,WebElement element)
			 {
				 Actions act=new Actions(driver);
				 act.contextClick(element).perform();
			 }
			 /**
			  * This method perform mouse action to click and hold Webelement
			  * @param driver
			  * @param element
			  */
			 public void clickAndHoldAction(WebDriver driver,WebElement element)
			 {
				 Actions act=new Actions(driver);
				 act.clickAndHold(element).perform();
			 }
			 /**
			  * This method perform mouse action to release the Webelement
			  * @param driver
			  * @param element
			  */
			 public void releaseAction(WebDriver driver,WebElement element)
			 {
				 Actions act=new Actions(driver);
				 act.release(element).perform();
			 }
			 /**
			  * This method perfrom Scroll action on webelement
			  * @param driver
			  * @param element
			  */
			 public void scrollAction(WebDriver driver,WebElement element)
			 {
				 Actions act=new Actions(driver);
				 act.scrollToElement(element).perform();
			 }
			 /**
			  * 
			  * @param driver
			  * @param FrameID
			  */
			 public void switchToFrame(WebDriver driver,int frameIndex)
			 {
				 driver.switchTo().frame(frameIndex);
			 }
			 public void switchToFrame(WebDriver driver,String frameNameOrID)
			 {
				 driver.switchTo().frame(frameNameOrID);
			 }
			 public void switchToFrame(WebDriver driver,WebElement frameElement)
			 {
				 driver.switchTo().frame(frameElement);
			 }
			 /**
			  * 
			  * @param driver
			  */
			 public void switchToParentFrame(WebDriver driver)
			 {
				 driver.switchTo().parentFrame();
			 }
			 /**
			  * 
			  * @param driver
			  */
			 public void switchToDefaultFrame(WebDriver driver)
			 {
				 driver.switchTo().defaultContent();
			 }
			 /**
			  * 
			  * @param driver
			  * @param WindowID
			  */
			 public void switchToWindow(WebDriver driver,String WindowID)
			 {
				 driver.switchTo().window(WindowID);
			 }
			 
			 /**
			  * 
			  * @param driver
			  */
			 
			public void acceptAlert(WebDriver driver)
			{
				driver.switchTo().alert().accept();
			}
			/**
			 * 
			 * @param driver
			 */
			public void dismissAlert(WebDriver driver)
			{
				driver.switchTo().alert().dismiss();;
			}
			/**
			 * 
			 * @param driver
			 * @param key
			 */
			public void sendDataToAlert(WebDriver driver,String data)
			{
				driver.switchTo().alert().sendKeys(data);;;
			}
			/**
			 * 
			 * @param driver
			 * @return text
			 */
			public String getAlertText(WebDriver driver)
			{
				String text = driver.switchTo().alert().getText();
				return text;
			}
			public void scrollDown(WebDriver driver)
			{
				JavascriptExecutor js= (JavascriptExecutor) driver;
				js.executeScript("window.scrollBy(0,500);", "");
			}
			public String captureScreenShot(WebDriver driver,String screenshotName) throws IOException 
			{
				TakesScreenshot ts=(TakesScreenshot)driver;
				File src = ts.getScreenshotAs(OutputType.FILE)	;
				File dst=new File(".\\Screenshots\\"+screenshotName+".png");
				FileHandler.copy(src, dst);
				return dst.getAbsolutePath();//For extend Reports
				
			}
}
