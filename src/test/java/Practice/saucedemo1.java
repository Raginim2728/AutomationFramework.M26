package Practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class saucedemo1 {

	public static void main(String[] args) throws InterruptedException, IOException
	{
		
		//launching browser
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		//open application using url
		FileInputStream file= new FileInputStream(".//src//test//resources//CommonData.properties");
		Properties p= new Properties();
		p.load(file);
		String URL= p.getProperty("url");
		String USERNAME= p.getProperty("username");
		String PASSWORD = p.getProperty("password");
				
		driver.get(URL);
		driver.findElement(By.id("user-name")).sendKeys(USERNAME);
		driver.findElement(By.id("password")).sendKeys(PASSWORD);
		driver.findElement(By.id("login-button")).click();
		
		//select a product and add to cart
		FileInputStream fil= new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fil);
		Sheet sh = wb.getSheet("Product");
		Row row = sh.getRow(1);
		Cell cell = row.getCell(2);
		String PRODUCTNAME = cell.getStringCellValue();
		
		WebElement product = driver.findElement(By.xpath("//div[text()='"+PRODUCTNAME+"']"));
		
		String proadded = product.getText();
		product.click();
		driver.findElement(By.id("add-to-cart")).click();
		//verifying the add to cart button changed to remove button
		WebElement btn = driver.findElement(By.id("remove"));
		if(btn.isDisplayed())
		{
			System.out.println("Button is changed to "+driver.findElement(By.id("remove")).getText());
		}
		else
		{
			System.out.println("Button is not changed");
		}
		//go to cart
		driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
		Thread.sleep(3000);
		//verifying product name in cart is same as added product name
		String proincart = driver.findElement(By.className("inventory_item_name")).getText();
		System.out.println(proincart);
		if(proincart.equals(proadded))
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
		//validating/printing the payment information and click finish
		//List<WebElement> info = driver.findElements(By.className("summary_info"));
		//for(int i=0; i<info.size(); i++)
		//{
		//	WebElement ele = info.get(i);
		//	System.out.println("***Details*** "+ele.getText());
		//}
		driver.findElement(By.id("finish")).click();
		//get the message and click back to home
		System.out.println(driver.findElement(By.xpath("//h2[@class='complete-header']")).getText());
		driver.findElement(By.id("back-to-products")).click();
		//driver.close();
	}

}
