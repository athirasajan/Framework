/**
 * 
 */
package com.review.testcases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.review.base.Baseclass;
import com.review.pages.Loginpagee;
import com.review.pages.ProxyLoginpagee;
import com.review.pages.ReviewProcessstagePage;
import com.review.util.Utility;




/**
 * @author athira
 *
 */
public class Verify5ReviewProcessstage extends Baseclass{
	
	String sheetName="ReviewProcess";
	@DataProvider
	public Object[][] getReviewstageData(){
		Object data[][]=Utility.getTestData(sheetName);
		return data;
		
	}
	
	@Test(dataProvider="getReviewstageData")
	public void ReviewProcess(String username,String Proxy_Reviewer) throws Exception{
		//test = extent.createTest("verifyReviewProcessstage");
		Loginpagee login=new Loginpagee(driver);
		login.clickOnsigninButton(username);
		ProxyLoginpagee prologin=new ProxyLoginpagee(driver);
		prologin.ProxyLogin(Proxy_Reviewer);
		ReviewProcessstagePage review=new ReviewProcessstagePage(driver);
		review.AcceptInvitation();
		
		
	}

}
