/**
 * 
 */
package com.review.testcases;

import java.net.MalformedURLException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import com.review.base.Baseclass;
import com.review.pages.Loginpagee;

/**
 * @author athira
 *
 */
public class LoginPageTest extends Baseclass {
	Loginpagee loginpage;
	
	public LoginPageTest(){
		super();
	}
	@BeforeMethod
	public void SetUp() throws MalformedURLException{
		intialisation();
		loginpage=new Loginpagee(driver);
		
	}
	
	@Test(priority=1)
	public void LoginTest() throws Exception{
		loginpage.clickOnsigninButton(prop.getProperty("username"));
	}
	
	@AfterMethod
	public void TearDown(){
		driver.quit();
	}
	

}
