/**
 * 
 */
package com.review.pages;

import java.util.concurrent.TimeUnit;




import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.review.util.Utility;

/**
 * @author athira
 * 
 * This class will store all the locator and methods of login page
 *
 */
public class Loginpagee {
	WebDriver driver;
	By username=By.id("login_username");
	By password=By.id("login_password");
	By signinButton=By.xpath("//*[@id='loginform']/div[4]/div[2]/button");
	By cookieOk=By.xpath("//*[contains(@class,'cookiewarning')]");
	By loading=By.xpath("//*[@id='ajax_loader']/img");
	//html/body/div[7]/span
	
	
	
	
	public Loginpagee(WebDriver driver){
		this.driver=driver;
	}
	public void clickOnsigninButton(String uname) throws Exception{
		driver.findElement(username).sendKeys(uname);
		driver.findElement(password).clear();
		driver.findElement(password).sendKeys("1");
		//Thread.sleep(3000);
		driver.findElement(signinButton).click();
		WebDriverWait wait2 = new WebDriverWait(driver,15);
		wait2.until(ExpectedConditions.invisibilityOfElementLocated(loading));
		 boolean exist2=driver.findElements(cookieOk).size()!=0;	
		 if(exist2==true)
		 {
		driver.findElement(cookieOk).click();
		 }
		 
		Thread.sleep(3000);
		driver.findElement(By.linkText(Utility.getData(0,1,0))).click();
		Thread.sleep(3000);
		
	}

}
