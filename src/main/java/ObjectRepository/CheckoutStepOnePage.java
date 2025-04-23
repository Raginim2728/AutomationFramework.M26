package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutStepOnePage 
{
	@FindBy(id="first-name")
	private WebElement firstNameEdt;
	
	@FindBy(id="first-name")
	private WebElement lastNameEdt;
	
	@FindBy(id="postal-code")
	private WebElement postalCodeEdt;
	
	@FindBy (id="continue")
	private WebElement continueBtn;
	
	@FindBy(id="cancel")
	private WebElement cancelBtn;
	
	public CheckoutStepOnePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getFirstNameEdt() {
		return firstNameEdt;
	}

	public WebElement getLastNameEdt() {
		return lastNameEdt;
	}

	public WebElement getPostalCodeEdt() {
		return postalCodeEdt;
	}

	public WebElement getContinueBtn() {
		return continueBtn;
	}

	public WebElement getCancelBtn() {
		return cancelBtn;
	}
	
	public void checkoutEnterDetails()
	{
		firstNameEdt.sendKeys(null);
	}
	
	public void clickContinueBtn() {
		
	}
	
}
