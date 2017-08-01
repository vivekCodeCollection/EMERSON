package Com;

import java.io.File;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.testng.annotations.Test;

import com.google.common.base.Stopwatch;

public class Exp1 {
	
	@Test
	public void Browserlaunch(){
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\workspace\\Exp\\Exe\\chromedriver.exe");
		WebDriver driver =new ChromeDriver();
		
		
		/*File file=new File("C:\\Users\\user\\Desktop\\vivek Docs\\phantomjs-2.1.1-windows\\phantomjs-2.1.1-windows\\bin\\phantomjs.exe") ;
		System.setProperty("phantomjs.binary.path", file.getAbsolutePath());
		
		WebDriver driver =new PhantomJSDriver();*/
		//driver.get("https://qa-ares.emersonecologics.com/");
		
		//driver.manage().window().maximize();
		
		
		//System.out.println(System.currentTimeMillis());
		long previousTime = System.currentTimeMillis();
		driver.get("https://qa-ares.emersonecologics.com/");
		long currentTime = System.currentTimeMillis();
		System.out.println((double)(previousTime-currentTime)/1000);
		Long loadtime = (Long)((JavascriptExecutor)driver).executeScript(
			    "return performance.timing.loadEventEnd - performance.timing.navigationStart;");
		System.out.println(loadtime/1000);
		/*
		
		*/
		System.out.println(driver.getCurrentUrl());
		
		
		
		
	}

}
 