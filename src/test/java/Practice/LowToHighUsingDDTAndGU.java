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

public class LowToHighUsingDDTAndGU {

	public static void main(String[] args) throws IOException, InterruptedException 
	{
		FileUtilities fUtil= new FileUtilities();
		JavaUtilities jUtil= new JavaUtilities();
		SeleniumUtilities sUtil= new SeleniumUtilities();

		String URL= fUtil.readDataFromPropertyFile("url");
		String USERNAME= fUtil.readDataFromPropertyFile("username");
		String PASSWORD = fUtil.readDataFromPropertyFile("password");
		
		WebDriver driver = new ChromeDriver();
		sUtil.maximizeWindow(driver);
		sUtil.addImplicitlyWait(driver);
		
				
		driver.get(URL);
//		driver.findElement(By.id("user-name")).sendKeys(USERNAME);
//		driver.findElement(By.id("password")).sendKeys(PASSWORD);
//		driver.findElement(By.id("login-button")).click();
		
		LoginPage lp= new LoginPage(driver);
		lp.loginToapp(USERNAME, PASSWORD);
		
		WebElement opt = driver.findElement(By.className("product_sort_container"));
    	opt.click();
		InventoryPage ip= new InventoryPage(driver);
		
		String SORTOPTION = fUtil.readDataFromExcel("Product", 4, 2);
		System.out.println(SORTOPTION);
		
		sUtil.handleDropDown(opt, SORTOPTION);;
		
		
		String PROLOW = fUtil.readDataFromExcel("Product", 4, 3);
		driver.findElement(By.xpath("//div[text()='"+PROLOW+"']")).click();
		ip.clickOnLowestPriceProduct(driver, PROLOW, SORTOPTION);
		
		driver.findElement(By.id("add-to-cart")).click();
		driver.findElement(By.className("shopping_cart_link")).click();
		
		driver.findElement(By.xpath("//button[text()='Remove']")).click();
		driver.findElement(By.id("react-burger-menu-btn")).click();
		
		driver.findElement(By.id("logout_sidebar_link")).click();

	}

}
