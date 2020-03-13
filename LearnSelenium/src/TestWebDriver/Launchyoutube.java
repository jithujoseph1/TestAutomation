package TestWebDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.beust.jcommander.Parameter;

public class Launchyoutube {

	@Parameters({"youtubeurl","youtubetitle","youtubesearch"})
	@Test(priority=2)
	public void youtubeLaunch(String URL, String title, String searchkey) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","C:\\Jithu\\selenium\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();	
		driver.get(URL);
		String ttle = driver.getTitle();
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(ttle, title);
		//Assert.assertEquals(ttle, title);
		Thread.sleep(1000);
		driver.findElement(By.id("search")).sendKeys(searchkey);
		Thread.sleep(1000);
		driver.findElement(By.id("search-icon-legacy")).click();
		Thread.sleep(2000);
		driver.close();
		softAssert.assertAll();

	}
	
	@Test(priority=1,dependsOnMethods= {"youtubeLaunch"},dataProvider="keystosearch",alwaysRun=true)
	public void googleLaunch(String skey) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","C:\\Jithu\\selenium\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();	
		driver.get("http://google.com");
		String ttle = driver.getTitle();
		Assert.assertEquals(ttle, "Google");
		driver.findElement(By.name("q")).sendKeys(skey);
		Thread.sleep(1000);
		driver.findElement(By.name("btnK")).click();
		Thread.sleep(2000);
		driver.close();
		Thread.sleep(2000);

	}
	@BeforeMethod
	public void beforeMethodtest()  {
		// TODO Auto-generated method stub
		System.out.println("Before launch youtube");
	}
	
	@DataProvider(name="keystosearch")
	public String[] searchDataset()
	{
	String[] searchkeys = new String[2];
	searchkeys[0] = "java";
	searchkeys[1] = "selenium";
	return searchkeys;
	}
	
	

}

