package push;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ama {

	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.gecko.driver","./driver/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		WebElement search = driver.findElement(By.id("twotabsearchtextbox"));
		search.sendKeys("iphone 11");
		search.sendKeys(Keys.ENTER);
		driver.findElement(By.xpath("//span[text()='Apple iPhone 11 (64GB) - Purple'][1]")).click();
		
		Set<String> winhand = driver.getWindowHandles();
		List<String> winhand1 =new ArrayList(winhand);
		driver.switchTo().window(winhand1.get(1));
		
		driver.findElement(By.id("add-to-cart-button")).click();
		Thread.sleep(2000);
		
		//driver.findElement(By.xpath("(//a[@class='a-button-text a-text-center'])[1]\"")).click();
		
		driver.findElement(By.id("hlb-ptc-btn-native")).click();
		
		driver.findElement(By.id("ap_email")).sendKeys("9987870509");
	    driver.findElement(By.id("continue")).click();
	    driver.findElement(By.id("ap_password")).sendKeys("Selenium@123");
	    driver.findElement(By.id("signInSubmit")).click();
	    
	    String Name = driver.findElement(By.xpath("(//li[@class='displayAddressLI displayAddressFullName'])[2]")).getText();
		System.out.println("The name is "+Name);
		driver.quit();
		

	}

}
