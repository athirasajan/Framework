package com.review.pages;



import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.review.util.Utility;

//This class will store all the locator and methods of proxy login

public class ProxyLoginpagee {
	WebDriver driver;
	By UserImage=By.xpath("//*[@id='profile-full-name']");
	By proxy=By.id("switch_to_proxy");
	By name=By.xpath("//*[@id='pxy_login_text']");
	By go=By.id("pxy_login_go");
public ProxyLoginpagee(WebDriver driver) {
	this.driver=driver;
	
	
}

public void ProxyLogin(String pname) throws Exception{
	Thread.sleep(1000);
	WebElement user=driver.findElement(UserImage);
	JavascriptExecutor executor = (JavascriptExecutor)driver;
	executor.executeScript("arguments[0].click();", user);
	//driver.findElement(UserImage).click();
	Thread.sleep(1000);
	driver.findElement(proxy).click();
	Thread.sleep(1000);
	WebElement element=driver.findElement(name);
	Utility.highLightElement(driver, element);
	element.sendKeys(pname);
	Thread.sleep(1000);
	driver.findElement(name).sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
	Thread.sleep(1000);
	driver.findElement(go).click();
	Utility.capturescreenshot(driver, "New proxy page");
	

}
}

