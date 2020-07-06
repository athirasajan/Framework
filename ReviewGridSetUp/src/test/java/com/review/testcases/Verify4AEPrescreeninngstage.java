/**
 * 
 */
package com.review.testcases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.review.base.Baseclass;
import com.review.pages.AEPrescreeningstagePage;
import com.review.pages.Loginpagee;
import com.review.util.Utility;




/**
 * @author athira
 *
 */
public class Verify4AEPrescreeninngstage extends Baseclass{
	
	String sheetName="AEPrescreening";
	@DataProvider
	public Object[][] getAEstageData(){
		Object data[][]=Utility.getTestData(sheetName);
		return data;
		
	}
	
	@Test(dataProvider="getAEstageData")
	public void AEPrescreening(String Username) throws Exception{
		//test = extent.createTest("VerifyAEPrescreeninngstage");
		Loginpagee login=new Loginpagee(driver);
		login.clickOnsigninButton(Username);
		AEPrescreeningstagePage prescreening=new AEPrescreeningstagePage(driver);
		prescreening.AEPrescreening();
		prescreening.InviteReviewer();
		
		
		
	}

}
