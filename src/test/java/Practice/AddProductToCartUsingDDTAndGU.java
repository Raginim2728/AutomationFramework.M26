package Practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import GenericUtilities.FileUtilities;
import GenericUtilities.JavaUtilities;
import GenericUtilities.SeleniumUtilities;
import ObjectRepository.InventoryPage;
import ObjectRepository.LoginPage;

public class AddProductToCartUsingDDTAndGU {

	public static void main(String[] args) throws InterruptedException, IOException 
	{
		
		//Create object of all required utility classes
		FileUtilities fUtil= new FileUtilities();
		JavaUtilities jUtil = new JavaUtilities();
		SeleniumUtilities sUtil = new SeleniumUtilities(); 
		
		//Read common data from Property file
		String URL= fUtil.readDataFromPropertyFile("url");
		String USERNAME= fUtil.readDataFromPropertyFile("username");
		String PASSWORD = fUtil.readDataFromPropertyFile("password");
		
		//Read Test data from excel file
		String PRODUCTNAME = fUtil.readDataFromExcel("Product", 1, 2);
		
		//Launch the browser
		WebDriver driver = new ChromeDriver();
		sUtil.maximizeWindow(driver);
		sUtil.addImplicitlyWait(driver);		
		driver.get(URL);
		
		//Login to application
//		driver.findElement(By.id("user-name")).sendKeys(USERNAME);
//		driver.findElement(By.id("password")).sendKeys(PASSWORD);
//		driver.findElement(By.id("login-button")).click();
//		
		LoginPage lp = new LoginPage(driver);
		lp.loginToapp(USERNAME, PASSWORD);
		
//		lp.getUsernameEdt().sendKeys(USERNAME);
//		lp.getPasswordEdt().sendKeys(PASSWORD);
//		lp.getLoginBtn().click();
//		
		//click on a product
		WebElement product = driver.findElement(By.xpath("//div[text()='"+PRODUCTNAME+"']"));
		String paddedtocart = product.getText();
		product.click();
		
		//add product to cart 
		driver.findElement(By.id("add-to-cart")).click();
		
		//Navigate to cart
		driver.findElement(By.id("shopping_cart_container")).click();
		
		//capture Screenshot for reference
		String screenshotname = "TC_001"+jUtil.getSystemDateInFormat();
		String path = sUtil.captureScreenshot(driver, screenshotname);
		System.out.println(path);
		
		
		//verifying product name in cart is same as added product name
				String proincart = driver.findElement(By.className("inventory_item_name")).getText();
				System.out.println(proincart);
				if(proincart.equals(paddedtocart))
				{
					System.out.println("Item Matching");
				}
				else
				{
					System.out.println("Item not Matching");
				}
				//click on checkout
				driver.findElement(By.id("checkout")).click();
				// provide details and click continue
				driver.findElement(By.id("first-name")).sendKeys("Sowmiya");
				driver.findElement(By.id("last-name")).sendKeys("M");
				driver.findElement(By.id("postal-code")).sendKeys("1234");
				driver.findElement(By.id("continue")).click();
				
				driver.findElement(By.id("finish")).click();
				//get the message and click back to home
				System.out.println(driver.findElement(By.xpath("//h2[@class='complete-header']")).getText());
				driver.findElement(By.id("back-to-products")).click();
				//driver.close();
	}

}
