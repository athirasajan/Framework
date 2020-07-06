/**
 * 
 */
package com.review.pages;

import java.util.List;







import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.review.util.Utility;




/**
 * @author athira
 *
 */
public class AEPrescreeningstagePage {
	WebDriver driver;
	By manuscript=By.id("manage-new-manuscript-title");
	By startbutton=By.xpath("//div/button[text()='Start']");
	By YesButton=By.xpath("//*[contains(@class,'btn-small btn-primary')]");
	By yesbutton2=By.xpath("//*[contains(@class,'btn-small btn-primary')]");
	By Ok=By.xpath("//*[contains(@class,'btn-primary btn_nxt_stage_details_modal')]");
	By loading=By.xpath("//*[@id='ajax_loader']/img");
	//By delete=By.xpath("//*[@id='sbkeyword-elms']/div/div[4]/a[2]");
	By delete=By.xpath("//a[contains(@title,'Delete')]");
	By search=By.id("btn_search_reviewer");
	By radiobutton=By.xpath("//td/a[contains(text(),'Emma George')]//preceding-sibling::input");
	By shortlistButton=By.id("trigger_add_reviewer");
	By InReview=By.id("manage-peer-review");
	By Invite=By.linkText("Invite");
	By Send=By.xpath("//*[@id='btn_send_invitation']");
	By yesbutton4=By.xpath("//*[contains(@class,'btn-small btn-primary')]");
	//*[@id="sidebar-mini_id"]/div[11]/div[2]/div/a[1]
	
	
	public AEPrescreeningstagePage(WebDriver driver){
		this.driver=driver;
	}
	public void AEPrescreening() throws Exception{
		
		String journal=driver.findElement(By.xpath("//a/h1/strong")).getText();
		Assert.assertTrue(journal.equals(Utility.getData(0,1,0)));
		System.out.println(journal);
		
		Thread.sleep(2000);
		driver.findElement(By.linkText("Associate Editor")).click();
		Thread.sleep(1000);
		//driver.findElement(manuscript).click();
		Thread.sleep(2000);
		String ID=Utility.getData(0,0,0);
		driver.findElement(By.id("show-filter")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("article_code")).sendKeys(ID.trim());
		Thread.sleep(3000);
		driver.findElement(By.id("btn_search")).click();
		Thread.sleep(2000);
		//List<WebElement>viewArticle=driver.findElements(Articleid);
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
		boolean ext=driver.findElements(startbutton).size()!=0;
		if(ext==true)
		{
		driver.findElement(startbutton).click();
		Thread.sleep(1000);
		
		boolean exist=driver.findElements(YesButton).size()!=0;
		if(exist==true)
		{
		driver.findElement(YesButton).click();
		}
		}
		//Thread.sleep(1000);
		
		 List<WebElement>forms=driver.findElements(By.tagName("form"));
			
		    System.out.println(forms.size());
			//String form=driver.findElement(By.tagName("form")).getAttribute("id");
			System.out.println(	forms.get(5).getAttribute("id"));
			String formId=forms.get(5).getAttribute("id");
			WebElement formElement = driver.findElement(By.id(formId));
			List<WebElement> allFormChildElements = formElement.findElements(By.xpath("//div/label/input"));
			//List<WebElement> allFormChildElements=formElement.findElements(By.xpath("//tagname[@attribute1=�input�][attribute2=�textarea�]"));
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
			List<WebElement> allFormChildElements2 = formElement.findElements(By.xpath("//div/textarea"));
			System.out.println(allFormChildElements2.size());
			if(allFormChildElements2.size()>0)
			{
			
			java.util.Iterator<WebElement> i = allFormChildElements2.iterator();
		   	while(i.hasNext()) {
		   	    WebElement elementtt = i.next();
		   	    if (elementtt.isDisplayed()) {
			    	System.out.println("TextArea");
			    	//driver.findElement(By.xpath("//*[contains(@name,'"+formId+"')]")).sendKeys("test");
			    	elementtt.sendKeys("test");
			    }
			}
			}
			
		   	
			
		   	List<WebElement> allFormChildElements3 = formElement.findElements(By.xpath("//div/select"));
			System.out.println(allFormChildElements3.size());
			if(allFormChildElements3.size()>0)
			{
			java.util.Iterator<WebElement> j = allFormChildElements3.iterator();
		   	while(j.hasNext()) {
		   	    WebElement dropdown = j.next();
		   	    if (dropdown.isDisplayed()) {
			    	System.out.println("Dropdown");
			    	//driver.findElement(By.xpath("//*[contains(@name,'"+formId+"')]")).sendKeys("test");
			    	Select option=new Select(dropdown);
			    	option.selectByIndex(1);
			    }
			}
			}
		   	
		   	List<WebElement> allFormChildElements4 = formElement.findElements(By.xpath("//input[@type='text']"));
			System.out.println(allFormChildElements4.size());
			if(allFormChildElements4.size()>0)
			{
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
			}
			/*Boolean isPresent = driver.findElements(By.xpath("//input[@type='file']")).size() > 0;
		   	if(isPresent==true)
		   	{
		   List<WebElement> allFormChildElements5 = formElement.findElements(By.xpath("//input[@type='file']"));
			System.out.println(allFormChildElements5.size());
			
				
			java.util.Iterator<WebElement> l = allFormChildElements5.iterator();
		   	while(l.hasNext()) {
		   	    WebElement element5 = l.next();
		   	    if (element5.isDisplayed()) {
			    	System.out.println("choose file");
			    	//driver.findElement(By.xpath("//*[contains(@name,'"+formId+"')]")).sendKeys("test");
			    	element5.sendKeys("C:\\Users\\athira\\Desktop\\download (2).jpg");
			    }
		   	    
			}
		   	}
		   	else
		   	{
		   		System.out.println("No choose file");
		   	}*/
				
		   	
		   
		   	Thread.sleep(2000);
			driver.findElement(By.xpath("//*[contains(@id,'btn_form_')]")).click();
			Thread.sleep(2000);
			/*boolean skip=driver.findElements(By.xpath("//*[contains(@class,'box-solid art_stages_panel action')]")).size()!=0;
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
				}*/
			driver.findElement(By.xpath("//button[contains(text(),'Move to Review Process')]")).click();
			Thread.sleep(1000);
			driver.findElement(yesbutton2).click();
			WebDriverWait wait2 = new WebDriverWait(driver,15);
			wait2.until(ExpectedConditions.invisibilityOfElementLocated(loading));
			Thread.sleep(3000);
			
			String alertText=driver.findElement(By.xpath("//div[@class='user-marign'][2]")).getText();
			Assert.assertTrue(alertText.contains("Reviewer can be shortlisted by"));
			System.out.println("AEPrescreening stage Completed---"+alertText);
			Thread.sleep(1000);
			driver.findElement(Ok).click();
			Thread.sleep(2000);
			
			String title=driver.findElement(By.id("title_name")).getText();
			System.out.println(title);
			if(title.contains("Prescreening")){

			Thread.sleep(1000);
			driver.findElement(By.linkText("Editor")).click();
			Thread.sleep(2000);
			driver.findElement(By.id("show-filter")).click();
			Thread.sleep(1000);
			driver.findElement(By.id("article_code")).sendKeys(ID.trim());
			Thread.sleep(2000);
			driver.findElement(By.id("btn_search")).click();
			Thread.sleep(1000);
			WebElement t22=driver.findElement(By.xpath("//*[contains(text(), '"+ID.trim()+"')]/ancestor::div[contains(@class,'box box-')]"));
			//WebElement t2=driver.findElement(By.xpath("//*[contains(text(), '"+ID.trim()+"')]/ancestor::div[contains(@class,'box box-h box-solid')]"));
			System.out.println(t22.getText());
			Utility.highLightElement(driver, t22);
			//WebElement t3=t2.findElement(By.xpath("//a[@title='View Article']"));
			WebElement t33=t22.findElement(By.linkText("View article"));
			System.out.println(t33.getText());
			Thread.sleep(1000);
			t33.click();
			}
			Thread.sleep(3000);
			driver.findElement(delete).click();
			Thread.sleep(2000);
			//Select limit=new Select(driver.findElement(By.id("sel_limit")));
			//limit.selectByVisibleText("50");
			//Thread.sleep(2000);
			Select filter=new Select(driver.findElement(By.xpath("//div/label[text()='Add Filter ']//following::select")));
			filter.selectByVisibleText("Email");
			Thread.sleep(1000);
			driver.findElement(By.id("srch_email_val_0")).sendKeys("emma@reviewdemo.rivervalleytechnologies.com");
			Thread.sleep(2000);
			driver.findElement(search).click();
			WebDriverWait wait3 = new WebDriverWait(driver,15);
			wait3.until(ExpectedConditions.invisibilityOfElementLocated(loading));
			Thread.sleep(3000);
			driver.findElement(radiobutton).click();
			Thread.sleep(3000);
			driver.findElement(shortlistButton).click();
			Thread.sleep(2000);
			boolean status=driver.findElement(By.name("reviewer_select")).isDisplayed();
			if(status){
				System.out.println("---Reviewer get shortlisted---");
			}
			else{
				System.out.println("---Reviewer not get shortlisted---");
			}
			Thread.sleep(2000);
				
			
			
	}
	public void InviteReviewer() throws Exception{
		String ID=Utility.getData(0,0,0);
		Thread.sleep(2000);
		driver.findElement(By.linkText("Associate Editor")).click();

		Thread.sleep(3000);
		driver.findElement(By.id("show-filter")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("article_code")).sendKeys(ID.trim());
		Thread.sleep(2000);
		driver.findElement(By.id("btn_search")).click();
		Thread.sleep(1000);
		/*driver.findElement(InReview).click();
		Thread.sleep(2000);
		List<WebElement> pagination =driver.findElements(By.id("pagination-article-list")); 
		// checkif pagination link exists 
		System.out.println(pagination.size());
		java.util.Iterator<WebElement> page = pagination.iterator();
		while(page.hasNext()) {
		WebElement nexte = page.next();
		if (nexte.isDisplayed()) {



		System.out.println("pagination exists"); 

		// click on pagination link 

		for(int i=0; i<pagination .size(); i++){ 
		pagination.get(i).click(); 


		}
		break;
		}


		}*/


		String ID1=Utility.getData(0,0,0);
		//List<WebElement>viewArticle=driver.findElements(Articleid);
		Thread.sleep(3000);
		WebElement tt2=driver.findElement(By.xpath("//*[contains(text(), '"+ID1.trim()+"')]/ancestor::div[contains(@class,'box box-')]"));
		System.out.println(tt2.getText());
		Utility.highLightElement(driver, tt2);
		//WebElement t3=t2.findElement(By.xpath("//a[@title='View Article']"));
		WebElement tt3=tt2.findElement(By.linkText("View article"));
		System.out.println(tt3.getText());
		Thread.sleep(1000);
		tt3.click();
		//WebDriverWait wait = new WebDriverWait(driver,15);
		//wait.until(ExpectedConditions.invisibilityOfElementLocated(loading));
		Thread.sleep(3000);
		driver.findElement(Invite).click();
		Thread.sleep(3000);
		driver.findElement(Send).click();
		Thread.sleep(3000);
		boolean existt = driver.findElements(By.xpath("//*[contains(@class,'btn-small btn-primary')]") ).size() != 0;

		if(existt==true)
		{
		driver.findElement(By.xpath("//*[contains(@class,'btn-small btn-primary')]")).click();
		}
		Thread.sleep(3000);
		boolean uninvite=driver.findElement(By.name("uninvite_user")).isDisplayed();
		if(uninvite){
			System.out.println("---Reviewer Invitation mail sent--- ");
		}
		else{
			System.out.println("---mail not sent--- ");
		}
		Thread.sleep(3000);




		}

	
	
	

}
