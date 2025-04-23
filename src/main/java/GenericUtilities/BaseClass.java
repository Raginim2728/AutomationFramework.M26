package GenericUtilities;
/**
 * This class consists of Basic configuration Annotations of TestNG
 * @author Sowmiya
 */

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import ObjectRepository.InventoryPage;
import ObjectRepository.LoginPage;

public class BaseClass
{
	public FileUtilities fUtil= new FileUtilities();
	public JavaUtilities jUtil = new JavaUtilities();
	public SeleniumUtilities sUtil = new SeleniumUtilities();
	
	public  WebDriver driver;
	
	//For Listeners
	public static WebDriver sdriver;
	
	@BeforeSuite(alwaysRun = true)
	public void bsConfig()
	{
		System.out.println("----Database connected Successfully----");
	}
	//@Parameters("Browser")
	//@BeforeTest
	@BeforeClass(alwaysRun = true)
	public void bcConfig(/*String pValue*/) throws IOException
	{
		String URL = fUtil.readDataFromPropertyFile("url");
		driver = new FirefoxDriver();
//		if(pValue.equals("firefox"))
//		{
//			driver = new FirefoxDriver();
//		}
//		else if(pValue.equals("chrome"))
//		{
//			driver = new ChromeDriver();
//		}
//		else
//		{
//			driver = new ChromeDriver();
//		}
		
			
		sUtil.maximizeWindow(driver);
		sUtil.addImplicitlyWait(driver);
		
		driver.get(URL);
		System.out.println("----Browser Launch Successfully-----");
		
		//For Listeners
		sdriver= driver;
		
	}
	
	@BeforeMethod(alwaysRun = true)
	public void bmConfig() throws IOException
	{
		String USERNAME = fUtil.readDataFromPropertyFile("username");
		String PASSWORD = fUtil.readDataFromPropertyFile("password");
		
		LoginPage lp = new LoginPage(driver);
		lp.loginToapp(USERNAME, PASSWORD);
		
		System.out.println("---Login to App successfully----");
	}
	
	@AfterMethod(alwaysRun = true)
	public void amConfig()
	{
		InventoryPage ip= new InventoryPage(driver);
		ip.logoutOfApp();
		
		System.out.println("----Logout to App Successfully---");
	}
	
	//@AfterTest
	@AfterClass(alwaysRun = true)
	public void acConfig()
	{
		driver.quit();
		System.out.println("----Browser Closure Successfully----");
		
	}
	
	@AfterSuite(alwaysRun = true)
	public void asConfig()
	{
		System.out.println("----Database Closure Successfully----");
	}
}
