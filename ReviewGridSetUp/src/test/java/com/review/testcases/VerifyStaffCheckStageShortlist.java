package com.review.testcases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.review.base.Baseclass;
import com.review.pages.Loginpagee;
import com.review.pages.StaffcheckStageShortlist;
import com.review.util.Utility;



public class VerifyStaffCheckStageShortlist extends Baseclass{
	
	String sheetName="Staffcheck";
	@DataProvider
	public Object[][] getStaffCheckstageData(){
		Object data[][]=Utility.getTestData(sheetName);
		return data;
		
	}

		@Test(dataProvider="getStaffCheckstageData")
		public void StaffCheckStage(String Username) throws Exception{
			
		
			//test = extent.createTest("VerifyStaffCheckstageShortlist");
			Loginpagee login=new Loginpagee(driver);
			
			login.clickOnsigninButton(Username);
			StaffcheckStageShortlist shortlist=new StaffcheckStageShortlist(driver);
			shortlist.StaffCheck();
			
			
			
		}

}
