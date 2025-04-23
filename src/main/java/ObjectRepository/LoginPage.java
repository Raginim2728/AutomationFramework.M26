package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class LoginPage //Rule 1: Create a separate POM class
{
	//Declaration
	//Rule 2: Identify all webelements using annotations
	@FindBy(id="user-name")
	private WebElement usernameEdt;
	
	//Auto Healing Process - if first locator is not able to identify the web element
	//automatically then@FindAll will shift to another locator for identifying the web element
	@FindAll({@FindBy(id="password"),@FindBy(name="password")}) // single web element with multiple locators- OR operators
	private WebElement passwordEdt;
	
	//@FindBys({@FindBy(id="password"), @FindBy(name="password")}) //single web element with multiple locators- AND operation
	
	@FindBy(className="submit-button")
	private WebElement loginBtn;
	
	//Rule 3: Create constructor to initialize webelements
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	// Rule 4:Provide getters to access the webelements
	public WebElement getUsernameEdt() {
		return usernameEdt;
	}

	public WebElement getPasswordEdt() {
		return passwordEdt;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
	
	// Business library - Generic Methods related to application

	
	/*
	 * This method will perform Login to application operation
	 * @param username
	 * @param password
	 */
	public void loginToapp(String username, String password)
	{
		usernameEdt.sendKeys(username);
		passwordEdt.sendKeys(password);
		loginBtn.click();
	}
	
	
}
