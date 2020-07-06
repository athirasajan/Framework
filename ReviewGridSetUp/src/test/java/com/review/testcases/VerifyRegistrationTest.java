/**
 * 
 */
package com.review.testcases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.review.base.Baseclass;
import com.review.pages.RegistrationPage;
import com.review.util.Utility;



/**
 * @author athira
 *
 */
public class VerifyRegistrationTest extends Baseclass {
	
	String sheetName="Register";
	
	@DataProvider
	public Object[][] getRegisterData(){
		Object data[][]=Utility.getTestData(sheetName);
		return data;
		
	}
	@Test(dataProvider="getRegisterData")
	public void RegisterUser(String Username,String Title,String FirstName,String LastName,String Email,String TypeInstitution,String Options,String Password) throws Exception{
		//test = extent.createTest("VerifyRegistration");
		RegistrationPage reg=new RegistrationPage(driver);
		reg.registration(Username,Title,FirstName,LastName,Email,TypeInstitution,Options,Password);
	}

}
