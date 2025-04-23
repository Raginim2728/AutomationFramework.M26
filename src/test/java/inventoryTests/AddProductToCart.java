package inventoryTests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
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


public class AddProductToCart extends BaseClass 
{
	
	@Test(groups="RegressionSuite")
	public  void tc_001_AddProductToCartTest() throws IOException
	{

		
		//Read common data from Excel file
		String PRODUCTNAME = fUtil.readDataFromExcel("Product", 1, 2);
		
		//Click on a Product
		InventoryPage ip = new InventoryPage(driver);
		String pAddedToCart = ip.clickOnAProduct(driver, PRODUCTNAME);
		
		//Add the Product to cart
		InventoryItemPage iip= new InventoryItemPage(driver);
		iip.clickOnAddToCartBtn();
		
		//Go to cart
		ip.clickOnCartContainer();
		
		//Validate the Product in the Cart
		CartPage cp= new CartPage(driver);
		String pInCart = cp.getProductName();
//		if(pInCart.equals(pAddedToCart))
//		{
//			System.out.println("PASS");
//			System.out.println(pInCart);
//		}
//		else
//		{
//			System.out.println("FAIL");
//		}
//		
		Assert.assertTrue(pInCart.equals(pAddedToCart));
		Assert.assertEquals(pInCart, pAddedToCart);


	}
	
	@Test
	public void sample()
	{
		System.out.println("Hiiii");
	}

}
