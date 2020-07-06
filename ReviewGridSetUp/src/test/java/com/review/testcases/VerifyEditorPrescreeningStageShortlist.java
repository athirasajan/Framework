/**
 * 
 */
package com.review.testcases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.review.base.Baseclass;
import com.review.pages.EditorPrescreeningStageShortlistPage;
import com.review.pages.Loginpagee;
import com.review.util.Utility;


/**
 * @author athira
 *
 */
public class VerifyEditorPrescreeningStageShortlist extends Baseclass {
	
	String sheetName="EditorPrescreening";
	@DataProvider
	public Object[][] getEditorstageData(){
		Object data[][]=Utility.getTestData(sheetName);
		return data;
		
	}
	@Test(dataProvider="getEditorstageData")
	public void EditorPrescreening(String Username) throws Exception{
		//test = extent.createTest("VerifyEditorPrescreeningstageShortlist");
		Loginpagee login=new  Loginpagee(driver);
		login.clickOnsigninButton(Username);
		EditorPrescreeningStageShortlistPage editor=new EditorPrescreeningStageShortlistPage(driver);
		editor.editorPrescreening();
		
		
	}

}
