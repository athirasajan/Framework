/**
 * 
 */
package com.review.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;




import net.bytebuddy.asm.Advice.Exit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.review.util.Utility;

/**
 * @author athira
 *
 */
public class StaffCheckstagePage {
	WebDriver driver;
	By manuscript=By.id("manage-new-manuscript");
	By ViewArticle=By.xpath("//*[contains(@id,'art-detail-')]/div/span[1]/a");
	By Startbutton=By.xpath("//*[@id='action_btns_div']/div/button");
	By YesButton=By.xpath("//*[contains(@class,'btn-small btn-primary')]");
	
	By Browse=By.xpath("//*[contains(@id,'files_')]");
	//*[@id="files_7873"]
	By UpdateAndContinue=By.id("btn_form_22");
	By yesbutton2=By.xpath("//*[contains(@class,'btn-small btn-primary')]");
	By Ok=By.xpath("//*[contains(@class,'btn-primary btn_nxt_stage_details_modal')]");
	By paginationId=By.id("pagination-article-list");
	
	
	public StaffCheckstagePage(WebDriver driver){
		this.driver=driver;
	}
	public void StaffCheck() throws Exception{
		String journal=driver.findElement(By.xpath("//a/h1/strong")).getText();
		Assert.assertTrue(journal.equals(Utility.getData(0,1,0)));
		System.out.println(journal);
		Thread.sleep(2000);
		driver.findElement(By.linkText("Staff")).click();
	
		//driver.findElement(manuscript).click();
		Thread.sleep(2000);
		
		Thread.sleep(1000);
		
		String ID=Utility.getData(0,0,0);
		driver.findElement(By.id("show-filter")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("article_code")).sendKeys(ID.trim());
		Thread.sleep(3000);
		driver.findElement(By.id("btn_search")).click();
		Thread.sleep(2000);
		/*boolean last=driver.findElements(By.linkText("Last �")).size()!=0;
		if(last==true){
			driver.findElement(By.linkText("Last �")).click();	
		}
		
		
	
	    	
	    	else
	    	{
		List<WebElement> pagination =driver.findElements(paginationId); 
		// checkif pagination link exists 
		System.out.println(pagination.size());
		java.util.Iterator<WebElement> page = pagination.iterator();
		while(page.hasNext()) {
			
	   	    WebElement nexte = page.next();
	   	    if (nexte.isDisplayed()) {
        
		 
	   	    	
		System.out.println("pagination exists"); 

		// click on pagination link 

		for(int j=0; j<pagination .size(); j++){ 
			Thread.sleep(2000);
		pagination.get(j).click(); 
	
		
		}
		break;
	   	    }
		
		 
		}
	    	}
	    
	
		
		Thread.sleep(2000);
		System.out.println(Utility.getData(0,0,2));
		String ID=Utility.getData(0,0,2);*/
		//List<WebElement>viewArticle=driver.findElements(Articleid);box box-h box-solid box-tog
		Thread.sleep(3000);
		WebElement t2=driver.findElement(By.xpath("//*[contains(text(), '"+ID.trim()+"')]/ancestor::div[contains(@class,'box box-')]"));
		System.out.println(t2.getText());
		Utility.highLightElement(driver, t2);
		//WebElement t3=t2.findElement(By.xpath("//a[@title='View Article']"));
		WebElement t3=t2.findElement(By.linkText("View article"));
		System.out.println(t3.getText());
		Thread.sleep(1000);
		t3.click();
		
		//System.out.println(viewArticle.size());
		Thread.sleep(3000);	 
		driver.findElement(Startbutton).click();
		Thread.sleep(1000);
		boolean existt = driver.findElements(By.xpath("//*[contains(@class,'btn-small btn-primary')]") ).size() != 0;
		 
		 if(existt==true)
		 {
			 driver.findElement(By.xpath("//*[contains(@class,'btn-small btn-primary')]")).click();
		 }
		Thread.sleep(1000);
		
		List<WebElement>forms=driver.findElements(By.xpath("//*[contains(@class,'form-horizontal generic')]"));
		System.out.println(forms.size());
		for(int no=0;no<forms.size();no++)
		{
			
		
		
		
		
		List<WebElement> allFormChildElements = driver.findElements(By.xpath("//div/label/input"));
		System.out.println(allFormChildElements.size());
		

		Thread.sleep(2000);
		
		
		java.util.Iterator<WebElement> item = allFormChildElements.iterator();
	   	while(item.hasNext()) {
	   	    WebElement elementt = item.next();
	   	    if (elementt.isDisplayed()) {
		    	System.out.println("if");
		        switch (elementt.getAttribute("type"))
		        {
		            
		            case "radio":
		                //check or uncheck
		            	System.out.println("Radio Button");
		            	
		            	
		            	Thread.sleep(1000);
		            	System.out.println(elementt.getAttribute("value"));
		            	if(elementt.getAttribute("value").equals("Yes")||elementt.getAttribute("value").equals("y"))
		            	{
		            	//driver.findElement(By.xpath("//*[contains(@name,'"+formId+"')]")).click();
		            	//driver.findElement(By.id(item.getAttribute("id"))).click();
		            	elementt.click();
		            	}
		            	else
		            	{
		            		break;	
		            	}
		                break;
		            case "checkbox":
		            	System.out.println("Checkbox");
		            	Thread.sleep(1000);
		            	elementt.click();
		                break;
		            case "text": 
		                //specify text value
		            	System.out.println("textbox");
		            	Thread.sleep(1000);
		            	//driver.findElement(By.xpath("//*[contains(@name,'"+formId+"')]")).sendKeys("test");
		            	elementt.sendKeys("test");
		                break;
		            	
		            //and so on
		        }
		    }
		}
		List<WebElement> allFormChildElements2 = driver.findElements(By.xpath("//div/textarea"));
		System.out.println(allFormChildElements2.size());
		java.util.Iterator<WebElement> i = allFormChildElements2.iterator();
	   	while(i.hasNext()) {
	   	    WebElement elementtt = i.next();
	   	    if (elementtt.isDisplayed()) {
		    	System.out.println("TextArea");
		    	//driver.findElement(By.xpath("//*[contains(@name,'"+formId+"')]")).sendKeys("test");
		    	elementtt.sendKeys("test");
		    }
		}
	   	
		
	   	List<WebElement> allFormChildElements3 = driver.findElements(By.xpath("//div/select"));
		System.out.println(allFormChildElements3.size());
		java.util.Iterator<WebElement> j = allFormChildElements3.iterator();
	   	while(j.hasNext()) {
	   	    WebElement dropdown = j.next();
	   	    if (dropdown.isDisplayed()) {
		    	System.out.println("Dropdown");
		    	//driver.findElement(By.xpath("//*[contains(@name,'"+formId+"')]")).sendKeys("test");
		    	Select option=new Select(dropdown);
		    	//option.selectByValue("Submitted");
		    	option.selectByIndex(1);
		    }
		}
	   	
	   	List<WebElement> allFormChildElements4 = driver.findElements(By.xpath("//input[@type='text']"));
		System.out.println(allFormChildElements4.size());
		java.util.Iterator<WebElement> k = allFormChildElements4.iterator();
	   	while(k.hasNext()) {
	   	    WebElement element4 = k.next();
	   	 if (element4.isDisplayed()) {
		    	System.out.println("Text box");
		    	if(element4.getAttribute("name").equals("search_value"))
         	{
         		element4.sendKeys(" ");
         	}
		    	//driver.findElement(By.xpath("//*[contains(@name,'"+formId+"')]")).sendKeys("test");
		    	else
		    	{
		    	element4.sendKeys("test b");
		    	}
		}
	   	}
	   	Thread.sleep(1000);
	   	
	   	List<WebElement> allFormChildElements5 = driver.findElements(By.xpath("//*[contains(@id,'_group_element_')]/div/span[1]"));
	   	List<WebElement> choose=driver.findElements(By.xpath("//*[contains(@class,'gen_file_upload')]"));
	   	
	   	for(WebElement option:allFormChildElements5){
	   		for(WebElement button:choose)
	   		{
	   			try{
	   			
	   		if(option.isDisplayed()&&button.isDisplayed()){
	   			//WebElement choose=driver.findElement(By.xpath("//*[contains(@class,'gen_file_upload')]"));
	   			System.out.println(option.getText());
	   			String text=option.getText();
	   			if(text.contains("pdf")){
					System.out.println("choose file pdf");
					Thread.sleep(1000);
					
					button.sendKeys("C:\\Users\\athira\\Desktop\\Athira Sajan_Jan 2019.pdf");
					
					break;
	   			}
	   			else if(text.contains("jpg")){
	   				System.out.println("choose file jpg");
					Thread.sleep(1000);
					
					button.sendKeys("C:\\Users\\athira\\Desktop\\download.jpg");
					
					break;
	   				
	   			}
	   			else
	   			{
	   				System.out.println("choose file png");
					Thread.sleep(1000);
					
					button.sendKeys("C:\\Users\\athira\\Desktop\\review2_error.PNG");
					}
					break;
	   			}
	   			
	   		}
	   			catch(Exception e){
	   				System.out.println(e.getMessage());
	   				
	   			}
	   		
	   		
	   		
	   		
	   	}
	   	}
	   	
	   		
	   	
	   	
		
	   
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[contains(text(),'Save and proceed')]")).click();
		}
		boolean skip=driver.findElements(By.xpath("//*[contains(@class,'box-solid art_stages_panel action')]")).size()!=0;
		 if(skip==true)
		 {
			List<WebElement>skipC= driver.findElements(By.xpath("//*[contains(@class,'box-solid art_stages_panel action')]"));
			
			System.out.println(skipC.size());
			for(WebElement nextSkip:skipC){
				try{
				if(nextSkip.isDisplayed()){
					
				
				WebElement element=nextSkip.findElement(By.name("skip-article-assign-users"));
				JavascriptExecutor js = (JavascriptExecutor)driver;
				js.executeScript("arguments[0].click();", element);
				Thread.sleep(1000);
				
				}
			}
			
			catch (Exception e) {
				// TODO: handle exception
			}
		 }
		 }
		
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//button[contains(text(),'Move to Editor Prescreening')]")).click();
		Thread.sleep(1000);
		boolean existtt = driver.findElements(By.xpath("//*[contains(@class,'btn-small btn-primary')]") ).size() != 0;
		 
		 if(existtt==true)
		 {
			 driver.findElement(By.xpath("//*[contains(@class,'btn-small btn-primary')]")).click();
		 }
		Thread.sleep(2000);
		String alertText=driver.findElement(By.xpath("//div[@class='user-marign'][2]")).getText();
		Assert.assertTrue(alertText.contains("Editor Prescreening can be performed by "));
		System.out.println("StaffCheck Stage Completed---"+alertText);
		Thread.sleep(1000);
		driver.findElement(Ok).click();
		Thread.sleep(3000);
		
	}
	

}
