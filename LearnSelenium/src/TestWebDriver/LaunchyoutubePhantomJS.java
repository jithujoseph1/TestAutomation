package TestWebDriver;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.beust.jcommander.Parameter;

public class LaunchyoutubePhantomJS {

	@Parameters({"youtubeurl","youtubetitle","youtubesearch"})
	@Test
	public void youtubeLaunch(String URL, String title, String searchkey) throws WebDriverException,IOException,InterruptedException {
		// TODO Auto-generated method stub
		//System.setProperty("webdriver.chrome.driver","C:\\Jithu\\selenium\\drivers\\chromedriver.exe");
		//WebDriver driver = new ChromeDriver();
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("takesScreenshot", true);
		capabilities.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,"C:\\Jithu\\selenium\\phantomjs-2.1.1-windows\\phantomjs-2.1.1-windows\\bin\\phantomjs.exe");
		PhantomJSDriver driver = new PhantomJSDriver(capabilities);
		driver.get(URL);
		String ttle = driver.getTitle();
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(ttle, title);
		//Assert.assertEquals(ttle, title);
		Thread.sleep(1000);
		System.out.println("Taking screenshot now");
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		System.out.println("File:"+srcFile);
		FileUtils.copyFile(srcFile, new File("C:\\Jithu\\selenium\\screenshot\\screenshot1.jpg"));
		System.out.println("Screenshot captured");
		Document doc = Jsoup.parse(driver.getPageSource());
		Elements links = doc.select("a[href]");
		for (Element el:links)
		{
		System.out.println(el.text());	
		}
		/*Thread.sleep(1000);
		driver.findElement(By.id("search")).sendKeys(searchkey);
		Thread.sleep(1000);
		driver.findElement(By.id("search-icon-legacy")).click();
		Thread.sleep(2000);
		System.out.println("Taking screenshot now");
		srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		System.out.println("File:"+srcFile);
		FileUtils.copyFile(srcFile, new File("C:\\Jithu\\selenium\\screenshot\\screenshot2.png"));
		System.out.println("Screenshot captured");*/
		driver.close();
		softAssert.assertAll();

	}
	
	
	@BeforeMethod
	public void beforeMethodtest()  {
		// TODO Auto-generated method stub
		System.out.println("Before launch youtube");
	}
	
	
	
	

}

