package LaunchSettings;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class BaseClass {
	
	public static void main(String[] args) throws MalformedURLException {
		
		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setCapability("automationName", "Appium");
		dc.setCapability("platformName", "Android");
		dc.setCapability("platformVersion", "7.0.0");
		dc.setCapability("deviceName", "Moto G4");
		dc.setCapability("appPackage", "com.android.settings");
		dc.setCapability("appActivity", "com.android.settings.Settings");
		AndroidDriver<WebElement> driver=new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub/"), dc);
		driver.findElement(By.name("More")).click();
	}

}

