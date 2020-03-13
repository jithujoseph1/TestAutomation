package TestWebDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Launch {

	@Test(priority=1,dependsOnMethods= {"googleLaunch"})
	public void amazonLaunch() throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","C:\\Jithu\\selenium\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();	
		driver.get("http://amazon.com");
		WebElement wa =  driver.findElement(By.id("nav-cart"));
		System.out.println(wa.getAttribute("aria-label"));
		driver.findElement(By.linkText("Try Prime")).click();
		Thread.sleep(2000);
		driver.navigate().back();
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[1]/header/div/div[2]/div[2]/div/div/a")).click();
		Thread.sleep(2000);
		WebElement srch = driver.findElement(By.id("twotabsearchtextbox"));
		srch.sendKeys("Mattress");
		Thread.sleep(2000);
		srch.clear();
		srch.sendKeys("Mattress pad");
		driver.findElement(By.xpath("//*[@id=\"nav-search\"]/form/div[2]/div/input")).click();
		String ttle = driver.getTitle();
		Assert.assertEquals(ttle, "Amazon.com: Mattress pad");
		Thread.sleep(1000);
		driver.close();

	}
	
	@Test(priority=2,groups= {"Regression"})
	public void googleLaunch() throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","C:\\Jithu\\selenium\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();	
		driver.get("http://google.com");
		String ttle = driver.getTitle();
		Assert.assertEquals(ttle, "Google");
		Thread.sleep(2000);
		driver.close();

	}
	@BeforeMethod
	public void beforeMethodtest()  {
		// TODO Auto-generated method stub
		System.out.println("Before launch amazon");
	}

}

