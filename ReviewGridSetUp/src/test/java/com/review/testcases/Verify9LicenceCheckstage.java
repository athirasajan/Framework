/**
 * 
 */
package com.review.testcases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.review.base.Baseclass;
import com.review.pages.LicenceCheckstagePage;
import com.review.pages.Loginpagee;
import com.review.util.Utility;





/**
 * @author athira
 *
 */
public class Verify9LicenceCheckstage extends Baseclass{
	
	String sheetName="LicenceCheck";
	@DataProvider
	public Object[][] getLicenceCheckstageData(){
		Object data[][]=Utility.getTestData(sheetName);
		return data;
		
	}

	@Test(dataProvider="getLicenceCheckstageData")
	public void LicenceCheck(String Username) throws Exception{
		//test = extent.createTest("VerifyLicenceCheckstage");
		Loginpagee login=new Loginpagee(driver);
		login.clickOnsigninButton(Username);
		LicenceCheckstagePage licenceCheck=new LicenceCheckstagePage(driver);
		licenceCheck.licenceCheck();
		
		
	}

}
