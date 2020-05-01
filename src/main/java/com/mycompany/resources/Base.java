package com.mycompany.resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Base {

	public static WebDriver driver;
	public Properties prop;
	
	public WebDriver initBrowsers() throws IOException {
		
		prop=new Properties();
		FileInputStream file=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\com\\mycompany\\resources\\data.properties");
		prop.load(file);
		
		//Instead of taking the data of which browser to execute? from data.properties file, we can take from system directly
		
		//String browserName=System.getProperty("browser");//While running the test give the command like "mvn test -Dbrowser=chrome" /firefox/ie
		
		String browserName=prop.getProperty("browser");
		
		if(browserName.contains("chrome")) {
			//We can run the tests without opening the browser(binary chrome) i,e Headless chrome 
			ChromeOptions options=new ChromeOptions();
			System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
			
			if(browserName.contains("headless")) {// If u give "headless" word it'll run without opening the browser
	
				options.addArguments("headless");
			}
			driver=new ChromeDriver(options);
		}
		
		else if(browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "./driver/geckodriver.exe");
			driver=new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver", "./driver/IEDriverServer.exe");
			driver=new InternetExplorerDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		return driver;
	}
	
	public void getScreenshots(String result) throws IOException {
		 
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("./screenshots/"+result+"screenshot.png"));
	}
	

}
