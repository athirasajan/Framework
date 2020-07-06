/**
 * 
 */
package com.review.testcases;



import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import com.review.base.Baseclass;
import com.review.pages.ArticleSubmissionpage;
import com.review.pages.Loginpagee;
import com.review.util.Utility;







/**
 * @author athira
 *
 */
public class Verify1ArticleSubmission extends Baseclass {
	
	String sheetName="ArticleSubmission";
	
	Loginpagee login;
	ArticleSubmissionpage article;
	
	@DataProvider
	public Object[][] getArticleSubmissionData(){
		Object data[][]=Utility.getTestData(sheetName);
		return data;
		
	}
	@BeforeMethod
	public void SetUp() throws Exception{
		intialisation();
		login=new Loginpagee(driver);
		//login.clickOnsigninButton(prop.getProperty("username"));
		article=new ArticleSubmissionpage(driver);
	}
	@Test(dataProvider="getArticleSubmissionData")
	public void Login(String Username,String ArticleType,String ArticleTy,String ArticleAbstract,String FileLocation) throws Exception{
		//test = extent.createTest("VerifyArticleSubmission");
	
		//Loginpagee login=new Loginpagee(driver);
		
		login.clickOnsigninButton(Username);
	
		
		//ArticleSubmissionpage article=new ArticleSubmissionpage(driver);
		article.ArticleSubmission(ArticleType, ArticleTy, ArticleAbstract, FileLocation);
		
	}
	@AfterMethod
	public void TearDown(){
		driver.quit();
	}
}
		
		


