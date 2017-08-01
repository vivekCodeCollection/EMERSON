package CloPack;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class test {

   public static void main(String[] args) throws MalformedURLException {
		
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		capabilities.setBrowserName("chrome");
		capabilities.setPlatform(Platform.WINDOWS);
		RemoteWebDriver driver = new RemoteWebDriver(new URL("http://xncfTrc1pxxqQHKzKhtINur81aWRwzkT:NmZxE2oTpM95jKuUROtv8KtZLgH7GRRj@AAXXL1VA.gridlastic.com:80/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		System.out.println("Starting Test");
		driver.get("http://www.google.com");
		driver.findElement(By.name("q")).sendKeys("gridLastic");
		driver.findElement(By.name("btnG")).click();
		
		List<WebElement> allLinks = driver.findElements(By.tagName("a"));
		System.out.println("Size of the link is : "+ allLinks.size());
		
		for(int i=0;i<allLinks.size();i++){
			System.out.println("Links are : " + allLinks.get(i).getAttribute("href"));
			allLinks = driver.findElements(By.tagName("a"));
		}
		
		System.out.println("Ending Test");
		driver.quit();

	}

	

}
