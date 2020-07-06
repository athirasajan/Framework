/**
 * 
 */
package com.review.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;



/**
 * @author athira
 *
 */
public class RegistrationPage {
	WebDriver driver;
	By loading=By.xpath("//*[@id='ajax_loader']/img");
	By cookieOk=By.xpath("//*[contains(@class,'cookiewarning')]");
	
	public RegistrationPage(WebDriver driver){
		this.driver=driver;
	}
	public void registration(String username,String title,String fname,String lname,String email,String TInstitution,String options,String password) throws Exception{
		driver.findElement(By.id("register")).click();
		Thread.sleep(2000);
		 boolean exist2=driver.findElements(cookieOk).size()!=0;	
		 if(exist2==true)
		 {
		driver.findElement(cookieOk).click();
		 }
		Thread.sleep(2000);
		driver.findElement(By.id("username")).sendKeys(username);
		Thread.sleep(1000);
		Select drop=new Select(driver.findElement(By.id("user_titles")));
		drop.selectByVisibleText(title);
		Thread.sleep(1000);
		driver.findElement(By.id("first_name")).sendKeys(fname);
		Thread.sleep(1000);
		driver.findElement(By.id("last_name")).sendKeys(lname);
		Thread.sleep(1000);
		driver.findElement(By.id("email")).sendKeys(email);
		Thread.sleep(1000);
		driver.findElement(By.id("aff_type")).sendKeys(TInstitution);
		Thread.sleep(1000);
		driver.findElement(By.id("new_usr_company_search_trigger")).click();
		Thread.sleep(1000);
		driver.findElement(By.name("search_key")).sendKeys("letter");
		Thread.sleep(1000);
		driver.findElement(By.id("usr_company_search_button")).click();
		WebDriverWait wait2 = new WebDriverWait(driver,15);
		wait2.until(ExpectedConditions.invisibilityOfElementLocated(loading));
		//Thread.sleep(3000);
		driver.findElement(By.id("institution0")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("usr_company_search_save")).click();
		Thread.sleep(2000);
		Select optn=new Select(driver.findElement(By.id("ctrl_1")));
		optn.selectByVisibleText(options);
		Thread.sleep(1000);
		driver.findElement(By.id("pwd")).sendKeys(password);
		Thread.sleep(1000);
		driver.findElement(By.id("cpwd")).sendKeys(password);
		Thread.sleep(1000);
		driver.findElement(By.id("agree")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("btnsave")).click();
		Thread.sleep(1000);
		
		
		
		
		
	}
	

}
