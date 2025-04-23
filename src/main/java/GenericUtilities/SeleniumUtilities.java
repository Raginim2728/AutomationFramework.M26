package GenericUtilities;

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
 * This class contain generic methods related to selenium
 * @author Sowmiya
 */
public class SeleniumUtilities 
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
	 * This method will add implicitly wait to the code
	 * @param driver
	 */
	public void addImplicitlyWait(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}
	
	/**
	 *  This method will wait for a particular element to be visible
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeVisible(WebDriver driver, WebElement element)
	{
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	/**
	 *  This method will wait for a particular element to be clickable
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeClickable(WebDriver driver, WebElement element)
	{
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	/**
	 * This method will handle dropdown by index
	 * @param element
	 * @param index
	 */
	public void handleDropDown(WebElement element, int index)
	{
		Select s= new Select(element);
		s.selectByIndex(index);
	
	}
	
	/**
	 * This method will handle dropdown by visible text
	 * @param element
	 * @param visibleText
	 */
	public void handleDropDown(WebElement element, String visibleText)
	{
		Select s= new Select(element);
		s.selectByVisibleText(visibleText);
	}
	
	/**
	 * This method will handle dropdown by value
	 * @param Value
	 * @param element
	 */
	public void handleDropDown( String Value, WebElement element)
	{
		Select s = new Select(element);
		s.selectByValue(Value);
	}
	/**
	 * This method will perform Mouse hover action
	 * @param driver
	 * @param element
	 */
	public void mouseHoverAction(WebDriver driver, WebElement element)
	{
		Actions a= new  Actions(driver);
		a.moveToElement(element).perform();
	}
	/**
	 * This method will perform click and hold 
	 * @param driver
	 * @param element
	 */
	public void clickAndHold(WebDriver driver, WebElement element)
	{
		Actions a= new  Actions(driver);
		a.clickAndHold(element).perform();;
	}
	
	/**
	 * This method will perform context click action 
	 * @param driver
	 * @param element
	 */
	
	
	public void contextClickAction(WebDriver driver, WebElement element)
	{
		Actions a= new  Actions(driver);
		a.contextClick(element).perform();
	}
	
	/**
	 * This method will perform double click action
	 * @param driver
	 * @param target
	 */
	public void doubleClickAction(WebDriver driver, WebElement target)
	{
		Actions a= new  Actions(driver);
		a.doubleClick(target).perform();
	}
	
	/**
	 * This method will perform drag and drop action
	 * @param driver
	 * @param source
	 * @param target
	 */
	public void dragAndDropAction(WebDriver driver,WebElement source,	WebElement target)
	{
		Actions a= new Actions(driver);
		a.dragAndDrop(source, target).perform();
		
	}
	/**
	 * This method will perform scroll Action
	 * @param driver
 	* @param source
 	* @param target
 	*/
	public void scrollAction(WebDriver driver,WebElement source,	WebElement target)
	{
		Actions a= new Actions(driver);
		a.scrollToElement(target).perform();
		
	}
	/**
	 * This method will switch the focus to frame by index
	 * @param driver
	 * @param index
	 */
	public void frameHandling(WebDriver driver, int index)
	{
		driver.switchTo().frame(index);
		
	}
	/**
	 * This method will switch the focus to frame by nameOrId
	 * @param driver
	 * @param index
	 */
	public void frameHandling(WebDriver driver,String nameOrId )
	{
		driver.switchTo().frame(nameOrId);
		
	}
	/**
	 * This method will switch the focus to frame by WebElement
	 * @param driver
	 * @param index
	 */
	public void frameHandling(WebDriver driver, WebElement frameElement )
	{
		driver.switchTo().frame(frameElement);
		
	}

    /**
     *  This method will switch back to the main page ( default content)
     *  @param driver
     */
    public void switchToDefaultContent(WebDriver driver)
    {
        driver.switchTo().defaultContent();
    }

    /**
     * This method will switch to immediate parent
     * @param driver
     */
    public void switchToParentFrame(WebDriver driver)
    {
        driver.switchTo().parentFrame();
    }
   /**
    * This method will switch to window
    * @param driver
    * @param windowHandle
    */
    public void switchToWindow(WebDriver driver, String windowHandle)
    {
    	driver.switchTo().window(windowHandle);
    }
    /**
     * This method will switch to Alert and accept it
     * @param driver
     */
    public void acceptAlert(WebDriver driver)
    {
    	driver.switchTo().alert().accept();
    	
    }
    /**
     * This method will switch to Alert and dismiss it
     * @param driver
     */
    public void dismissAlert(WebDriver driver)
    {
    	driver.switchTo().alert().dismiss();
    	
    }
    /**
     * This method will capture Alert text and return to caller
     * @param driver
     * @return 
     */
    public String getAlertText(WebDriver driver)
    {
    	return driver.switchTo().alert().getText();
    	
    }
    /**
     * This method will switch to alerts and send text to alerts
     * @param driver
     * @param keysToSend
     */
    public void switchToAlert(WebDriver driver, String keysToSend)
    {
    	driver.switchTo().alert().sendKeys(keysToSend);;
    	
    }
    /**
     * This method will scroll to element by using JS  
     * @param driver
     * @param element
     */
    public void scrollToElementByJs(WebDriver driver, WebElement element)
    {
    	JavascriptExecutor js=  (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }
    /**
     * This method will scroll to top of the page by using JS
     * @param driver
     */
    public void scrollToTopByJs(WebDriver driver)
    {
    	JavascriptExecutor js=  (JavascriptExecutor) driver;
    	js.executeScript("window.scrollTo(0, 0);");
    }
	/**
	 * This Method will scroll to bottom of the page by using JS
	 * @param driver
	 */
    public void scrollToBottomByJs(WebDriver driver)
    {
    	JavascriptExecutor js=  (JavascriptExecutor) driver;
    	js.executeScript("window.scrollTo(0, document.body.scrollHeight);","");
    }
    /**
     * This Method will scroll down by using JS
     * @param driver
     */
    public void scrollDownByJs(WebDriver driver)
    {
    	JavascriptExecutor js=  (JavascriptExecutor) driver;
    	js.executeScript("window.scrollTo(0, 500);","");
    }
    /**
     * This Method will scroll up by using JS
     * @param driver
     */
    public void scrollUpByJs(WebDriver driver)
    {
    	JavascriptExecutor js=  (JavascriptExecutor) driver;
    	js.executeScript("window.scrollTo(0, -500);","");
    }
    /**
     * This Method will scroll right by using JS
     * @param driver
     */
    public void scrollRightByJs(WebDriver driver)
    {
    	JavascriptExecutor js=  (JavascriptExecutor) driver;
    	js.executeScript("window.scrollTo(500, 0);","");
    }
    /**
     * This Method will scroll left by using JS
     * @param driver
     */
    public void scrollLeftByJs(WebDriver driver)
    {
    	JavascriptExecutor js=  (JavascriptExecutor) driver;
    	js.executeScript("window.scrollTo(-500, 0);", "");
    	
    }
    /**
     * This
     * @param driver
     * @param element
     */
    public void clickElementByJs(WebDriver driver, WebElement element)
    {
    	JavascriptExecutor js=  (JavascriptExecutor) driver;
    	 js.executeScript("arguments[0].click();", element);
    }
    
    /**
     * This method will send text to the element by using JS
     * @param driver
     * @param element
     * @param text
     */
    public void sendKeysByJS(WebDriver driver, WebElement element, String text)
    {
     	JavascriptExecutor js=  (JavascriptExecutor) driver;
        js.executeScript("arguments[0].value='" + text + "';", element);
    }
    /**
     * This method will capture Screenshot and return the path to Caller
     * @param driver
     * @param screenshotName
     * @return
     * @throws IOException
     */
    public String captureScreenshot(WebDriver driver, String screenshotName ) throws IOException
    {
    	TakesScreenshot ts= (TakesScreenshot)driver;
    	File src =ts.getScreenshotAs(OutputType.FILE);
    	File dst= new File(".//Screenshots//"+screenshotName+".png"); //tsname_date_time
    	FileHandler.copy(src, dst);
    	
    	return dst.getAbsolutePath();//for Extent Reports
    }
    
    

}
