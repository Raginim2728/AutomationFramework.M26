package inventoryTests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import GenericUtilities.BaseClass;
import GenericUtilities.FileUtilities;
import GenericUtilities.JavaUtilities;
import GenericUtilities.SeleniumUtilities;
import ObjectRepository.CartPage;
import ObjectRepository.InventoryItemPage;
import ObjectRepository.InventoryPage;
import ObjectRepository.LoginPage;

@Listeners(GenericUtilities.ListenersImplementation.class)
public class AddLowestProductToCart extends BaseClass
{
	@Test(groups = "SmokeSuite")
	public void tc_002_AddLowestProductToCart() throws IOException
	{
		
		String SORTOPTION = fUtil.readDataFromExcel("Product", 4, 2);
		String PROLOW = fUtil.readDataFromExcel("Product", 4, 3);
		
		InventoryPage ip= new InventoryPage(driver);
		InventoryItemPage iip= new InventoryItemPage(driver);
		CartPage cp= new CartPage(driver); 
		
		String pAddedToCart = ip.clickOnLowestPriceProduct(driver, PROLOW, SORTOPTION);
		
		iip.clickOnAddToCartBtn();
		
		ip.clickOnCartContainer();
		
		String pInCart = cp.getProductName();
		
		Assert.assertEquals(pInCart,  pAddedToCart);
	
		
	}
	@Test(retryAnalyzer = GenericUtilities.RetryAnalyserImplementation.class)
	public void sample()
	{
		//Assert.fail();
		System.out.println("Hi");
	}
}
