/**
 * 
 */
package com.review.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;



/**
 * @author athira
 *
 */
public class Baseclass {
	
	public static WebDriver driver;
	public static Properties prop;
	
	public Baseclass(){
		try{
			prop = new Properties();
			
			FileInputStream ip=new FileInputStream("C:\\Users\\athira\\workspace\\ReviewGridSetUp\\src\\main\\java\\com\\review\\config\\config.properties");
			prop.load(ip);
			
			
		}
		catch (FileNotFoundException e){
			e.printStackTrace();
			
		}
		catch (IOException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
	}
	
	
	
	//public static void main(String[]args) throws MalformedURLException, Exception{
	public static void intialisation() throws MalformedURLException{
		
		String browserName=prop.getProperty("browser");
		if(browserName.equals("chrome")){
			DesiredCapabilities cap=new DesiredCapabilities();
			cap.setBrowserName("chrome");
			cap.setPlatform(Platform.LINUX);
			
			ChromeOptions options= new ChromeOptions();
			options.merge(cap);
			String hubUrl="http://192.168.112.159:12773/wd/hub";
			driver=new RemoteWebDriver(new URL(hubUrl),options);
			
		}
		else if(browserName.equals("Firefox"))
		{
			DesiredCapabilities cap=new DesiredCapabilities();
			cap.setBrowserName("firefox");
			cap.setPlatform(Platform.LINUX);
			
			ChromeOptions options= new ChromeOptions();
			options.merge(cap);
			String hubUrl="http://192.168.112.159:28469/wd/hub";
			driver=new RemoteWebDriver(new URL(hubUrl),options);
			
		}
		else if(browserName.equals("IE"))
		{
			
		}
		else
		{
			System.out.println("Do not support thiis browser");
		}
		
	
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		//driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		//driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
	}

}
