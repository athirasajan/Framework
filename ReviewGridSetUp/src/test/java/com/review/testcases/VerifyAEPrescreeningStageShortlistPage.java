/**
 * 
 */
package com.review.testcases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.review.base.Baseclass;
import com.review.pages.AEPrescreeningStageShortlistPage;
import com.review.pages.Loginpagee;
import com.review.util.Utility;



/**
 * @author athira
 *
 */
public class VerifyAEPrescreeningStageShortlistPage extends Baseclass {
	
	String sheetName="AEPrescreening";
	@DataProvider
	public Object[][] getAEstageData(){
		Object data[][]=Utility.getTestData(sheetName);
		return data;
		
	}
	
	@Test(dataProvider="getAEstageData")
	public void AEPrescreening(String Username) throws Exception{
		//test = extent.createTest("VerifyAEPrescreeninngstageShortlist");
		Loginpagee login=new Loginpagee(driver);
		login.clickOnsigninButton(Username);
		AEPrescreeningStageShortlistPage prescreening=new AEPrescreeningStageShortlistPage(driver);
		prescreening.AEPrescreening();
		prescreening.InviteReviewer();
		
		
		
	}

}
