/**
 * 
 */
package com.review.testcases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.review.base.Baseclass;
import com.review.pages.AERecommendationStageShortlist;
import com.review.pages.Loginpagee;
import com.review.util.Utility;



/**
 * @author athira
 *
 */
public class VerifyAERecommendationStageShortlist extends Baseclass{
	
	String sheetName="AERecommendation";
	@DataProvider
	public Object[][] getAERecommendationstageData(){
		Object data[][]=Utility.getTestData(sheetName);
		return data;
		
	}
	@Test(dataProvider="getAERecommendationstageData")
	public void AERecommendation(String Username) throws Exception{
		//test = extent.createTest("VerifyAERecommendationstageShortlist");
		Loginpagee login=new Loginpagee(driver);
		login.clickOnsigninButton(Username);
		AERecommendationStageShortlist aeRecommendation=new AERecommendationStageShortlist(driver);
		aeRecommendation.AERecommendation();
		
		
		
	}

}
