/**
 * 
 */
package com.review.testcases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.review.base.Baseclass;
import com.review.pages.LicenceFormstagePage;
import com.review.pages.Loginpagee;
import com.review.util.Utility;



/**
 * @author athira
 *
 */
public class Verify8LicenceFormstage extends Baseclass {
	String sheetName="LicenceForm";
	@DataProvider
	public Object[][] getLicenceFormstageData(){
		Object data[][]=Utility.getTestData(sheetName);
		return data;
		
	}
	@Test(dataProvider="getLicenceFormstageData")
	public void LicenceForm(String Username) throws Exception{
		//test = extent.createTest("VerifyLicenceFormstage");
		Loginpagee login=new Loginpagee(driver);
		login.clickOnsigninButton(Username);
		LicenceFormstagePage licence=new LicenceFormstagePage(driver);
		licence.licenceForm();
	}

}
