/**
 * 
 */
package com.review.testcases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.review.base.Baseclass;
import com.review.pages.Loginpagee;
import com.review.pages.ProductionstagePage;
import com.review.util.Utility;




/**
 * @author athira
 *
 */
public class Verify11Productionstage extends Baseclass{
	
	String sheetName="Production";
	@DataProvider
	public Object[][] getProductionstageData(){
		Object data[][]=Utility.getTestData(sheetName);
		return data;
		
	}
	@Test(dataProvider="getProductionstageData")
	public void Production(String Username) throws Exception{
		//test = extent.createTest("VerifyProductionstage");
		Loginpagee login=new Loginpagee(driver);
		login.clickOnsigninButton(Username);
		ProductionstagePage productionStage=new ProductionstagePage(driver);
		productionStage.production();
		
		
	}

}
