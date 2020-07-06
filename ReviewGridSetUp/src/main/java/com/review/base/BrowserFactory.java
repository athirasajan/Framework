package com.review.base;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.BasicConfigurator;


import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BrowserFactory {
	
	
	public static WebDriver startApplication(WebDriver driver,String browserName,String appURL) throws MalformedURLException{
		
		BasicConfigurator.configure();
		
		if(browserName.equals("Chrome"))
		{
			DesiredCapabilities cap=new DesiredCapabilities();
			cap.setBrowserName("chrome");
			cap.setPlatform(Platform.LINUX);
			
			ChromeOptions options= new ChromeOptions();
			options.merge(cap);
			String hubUrl="http://192.168.112.159:29718/wd/hub";
			driver=new RemoteWebDriver(new URL(hubUrl),options);
			
			
			
		}
		else if(browserName.equals("Firefox"))
		{
			DesiredCapabilities cap=new DesiredCapabilities();
			cap.setBrowserName("firefox");
			cap.setPlatform(Platform.LINUX);
			
			ChromeOptions options= new ChromeOptions();
			options.merge(cap);
			String hubUrl="http://192.168.112.159:29718/wd/hub";
			driver=new RemoteWebDriver(new URL(hubUrl),options);
			
			
		}
		else if(browserName.equals("IE"))
		{
			
		}
		else
		{
			System.out.println("Do not support thiis browser");
		}
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(appURL);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		return driver;
		
	}
	
	
	public void quitBrowser(){
		
		
	}

}
