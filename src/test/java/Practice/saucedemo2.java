package Practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class saucedemo2 {

	public static void main(String[] args) throws InterruptedException, IOException
	{
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		FileInputStream file= new FileInputStream("./src/test/resources/CommonData.properties");
		Properties p= new Properties();
		p.load(file);
		String URL= p.getProperty("url");
		String USERNAME= p.getProperty("username");
		String PASSWORD = p.getProperty("password");
				
		driver.get(URL);
		driver.findElement(By.id("user-name")).sendKeys(USERNAME);
		driver.findElement(By.id("password")).sendKeys(PASSWORD);
		driver.findElement(By.id("login-button")).click();
		WebElement opt = driver.findElement(By.className("product_sort_container"));
		Select s= new Select(opt);
		s.selectByValue("lohi");
		driver.findElement(By.id("item_2_title_link")).click();
		driver.findElement(By.id("add-to-cart")).click();
		driver.findElement(By.className("shopping_cart_link")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[text()='Remove']")).click();
		driver.findElement(By.id("react-burger-menu-btn")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("logout_sidebar_link")).click();
	}

}
