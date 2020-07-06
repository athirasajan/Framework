/**
 * 
 */
package com.review.pages;

import java.awt.Desktop.Action;
import java.util.List;




import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
public class ReviewProcessstagePage {
	WebDriver driver;
	
	//manage-invitation
	//manage-under-review
	By invitation=By.id("manage-invitation");
	By accept=By.id("accept_invitation");
	By yesbutton5=By.xpath("//*[contains(@class,'btn-small btn-primary')]");
	//*[@id="sidebar-mini_id"]/div[1]/div[1]/section[2]/div[1]/div/div[4]/div/div[2]/div/a[1]
	By yesbutton2=By.xpath("//*[contains(@class,'btn-small btn-primary')]");
	By okButton2=By.xpath("//*[contains(@class,'swal2-confirm swal2-styled')]");
	By Ok=By.xpath("//*[contains(@class,'btn-primary btn_nxt_stage_details_modal')]");
    public ReviewProcessstagePage(WebDriver driver){
		this.driver=driver;
	}
	
	public void AcceptInvitation() throws Exception{
		
		String journal=driver.findElement(By.xpath("//a/h1/strong")).getText();
		Assert.assertTrue(journal.equals(Utility.getData(0,1,0)));
		System.out.println(journal);
		
		Thread.sleep(2000);
		driver.findElement(By.linkText("Reviewer")).click();
		Thread.sleep(1000);
		driver.findElement(invitation).click();
		Thread.sleep(1000);
		
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
		
		 
		}
		
		//driver.findElement(viewarticle2).click();
		String ID=Utility.getData(0,0,0);
		WebElement t2=driver.findElement(By.xpath("//*[contains(text(), '"+ID.trim()+"')]/ancestor::div[contains(@class,'box box-')]"));
		System.out.println(t2.getText());
		Utility.highLightElement(driver, t2);
		WebElement t3=t2.findElement(By.linkText("View article"));
		
		System.out.println(t3.getText());
		Thread.sleep(1000);
		t3.click();
		Thread.sleep(2000);
		driver.findElement(accept).click();
		Thread.sleep(2000);
		boolean exist=driver.findElements(yesbutton5).size()!=0;
		if(exist==true)
		{
		Actions actions=new Actions(driver);
		WebElement yes=driver.findElement(yesbutton5);
		actions.moveToElement(yes).perform();
		//Thread.sleep(2000);
		driver.findElement(yesbutton5).click();
		}
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
		            	if(elementt.getAttribute("value").equals("Yes")||elementt.getAttribute("value").equals("y")||elementt.getAttribute("value").equals("Accept")||elementt.getAttribute("value").equals("Outstanding"))
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
		
		
	   
	   	
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//button[contains(text(),'Submit Review')]")).click();
		Thread.sleep(1000);
		
		
		
		boolean existt=driver.findElements(yesbutton2).size()!=0;
		if(existt==true)
		{
		driver.findElement(yesbutton2).click();
		}
		Thread.sleep(2000);
		
		String alertText=driver.findElement(By.xpath("//h2[@class='swal2-title']")).getText();
		Assert.assertTrue(alertText.contains("Thank you for submitting your review"));
		Thread.sleep(1000);
		System.out.println("Review Process Stage Completed---"+alertText);
		driver.findElement(okButton2).click();
		Thread.sleep(3000);
		
		
	}

}
