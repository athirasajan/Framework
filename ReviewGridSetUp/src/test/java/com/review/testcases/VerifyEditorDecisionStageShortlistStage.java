/**
 * 
 */
package com.review.testcases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.review.base.Baseclass;
import com.review.pages.EditorDecisionStageShortlistPage;
import com.review.pages.FinaliseDecisionAcceptstagePage;
import com.review.pages.Loginpagee;
import com.review.util.Utility;


/**
 * @author athira
 *
 */
public class VerifyEditorDecisionStageShortlistStage extends Baseclass {
	String sheetName="EditorDecisionstage";
	@DataProvider
	public Object[][] getEditorDecisionstageData(){
		Object data[][]=Utility.getTestData(sheetName);
		return data;
		
	}
	
	@Test(dataProvider="getEditorDecisionstageData")
	public void EditorDecision(String Username) throws Exception{
		//test = extent.createTest("VerifyEditorDecisionstageShortlist");
		Loginpagee login=new Loginpagee(driver);
		login.clickOnsigninButton(Username);
		EditorDecisionStageShortlistPage editor=new EditorDecisionStageShortlistPage(driver);
		editor.editorDecision();
		FinaliseDecisionAcceptstagePage accept=new FinaliseDecisionAcceptstagePage(driver);
		accept.FinaliseDecision();

}
}
