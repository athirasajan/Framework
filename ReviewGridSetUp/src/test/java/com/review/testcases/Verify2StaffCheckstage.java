/**
 * 
 */
package com.review.testcases;

import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.annotations.Parameters;

import com.review.base.Baseclass;
import com.review.pages.Loginpagee;
import com.review.pages.StaffCheckstagePage;
import com.review.util.Utility;












/**
 * @author athira
 *
 */
public class Verify2StaffCheckstage extends Baseclass {
	
String sheetName="Staffcheck";
@DataProvider
public Object[][] getStaffCheckstageData(){
	Object data[][]=Utility.getTestData(sheetName);
	return data;
	
}

	@Test(dataProvider="getStaffCheckstageData")
	public void StaffCheckStage(String Username) throws Exception{
		
	
		//test = extent.createTest("VerifyStaffCheckstage");
		Loginpagee login=new Loginpagee(driver);
		
		login.clickOnsigninButton(Username);
		StaffCheckstagePage staff=new StaffCheckstagePage(driver);
		staff.StaffCheck();
		
		
		
	}
	
}
