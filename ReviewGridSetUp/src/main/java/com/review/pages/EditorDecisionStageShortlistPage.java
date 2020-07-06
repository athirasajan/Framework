/**
 * 
 */
package com.review.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.review.util.Utility;



/**
 * @author athira
 *
 */
public class EditorDecisionStageShortlistPage {
	
	WebDriver driver;
	By editor=By.linkText("Editor");
	By PendingDecision=By.id("manage-awaiting-decision-title");
	By startbutton=By.xpath("//div/button[text()='Start']");
	By yesButton=By.xpath("//*[contains(@class,'btn-small btn-primary')]");
	By yesbutton2=By.xpath("//*[contains(@class,'btn-small btn-primary')]");
	By okButton2=By.xpath("//*[contains(@class,'btn-primary btn_nxt_stage_details_modal')]");
	 public EditorDecisionStageShortlistPage(WebDriver driver){
			this.driver=driver;
		}
	 public void editorDecision() throws Exception{
		 Thread.sleep(1000);
		 	driver.findElement(editor).click();
		 	Thread.sleep(1000);
			//driver.findElement(PendingDecision).click();
			Thread.sleep(1000);
			
			String ID=Utility.getData(0,0,0);
			driver.findElement(By.id("show-filter")).click();
			Thread.sleep(3000);
			driver.findElement(By.id("article_code")).sendKeys(ID.trim());
			Thread.sleep(3000);
			driver.findElement(By.id("btn_search")).click();
			Thread.sleep(2000);
			WebElement t2=driver.findElement(By.xpath("//*[contains(text(), '"+ID.trim()+"')]/ancestor::div[contains(@class,'box box-')]"));
			System.out.println(t2.getText());
			Utility.highLightElement(driver, t2);
			WebElement t3=t2.findElement(By.linkText("View article"));
			System.out.println(t3.getText());
			Thread.sleep(1000);
			t3.click();
			Thread.sleep(1000);
			
			//Thread.sleep(3000);
			List<WebElement>forms=driver.findElements(By.xpath("//div/form[contains(@id,'form_')]"));
			
		    System.out.println(forms.size());
			//String form=driver.findElement(By.tagName("form")).getAttribute("id");
		    System.out.println(forms.get(0).getAttribute("id"));
			
			
			
			String formId=forms.get(0).getAttribute("id");
			WebElement formElement = driver.findElement(By.id(formId));
			/*List<WebElement> allFormChildElements = formElement.findElements(By.xpath("//div/label/input"));
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
			            	
			            	
			            	Thread.sleep(2000);
			            	System.out.println(elementt.getAttribute("value"));
			            	if(elementt.getAttribute("value").equals("Yes")||elementt.getAttribute("value").equals("y")||elementt.getAttribute("value").equals("Accept")||elementt.getAttribute("value").equals("Outstanding"))
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
			            	Thread.sleep(2000);
			            	elementt.click();
			                break;
			            case "text": 
			                //specify text value
			            	System.out.println("textbox");
			            	Thread.sleep(2000);
			            	
			            	//driver.findElement(By.xpath("//*[contains(@name,'"+formId+"')]")).sendKeys("test");
			            	elementt.sendKeys("test");
			                break;
			              
			            	
			            //and so on
			        }
			    }
			}*/
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
			
		   
		  /* List<WebElement> allFormChildElements5 = formElement.findElements(By.xpath("//input[@type='file']"));
			System.out.println(allFormChildElements5.size());
			while(allFormChildElements5.size()>0){
			String text=driver.findElement(By.xpath("//input[@type='file']/following::span")).getText();
			System.out.println(text);
			if(text.contains("pdf"))
			{
				java.util.Iterator<WebElement> l = allFormChildElements5.iterator();
			   	while(l.hasNext()) {
			   	    WebElement element5 = l.next();
			   	    if (element5.isDisplayed()) {
				    	System.out.println("choose file pdf");
				    	//driver.findElement(By.xpath("//*[contains(@name,'"+formId+"')]")).sendKeys("test");
				    	element5.sendKeys("C:\\Users\\athira\\Desktop\\testpdf.pdf");
				    }
			   	   }
			}
			else
			{
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
			}*/
			
			
		   	Thread.sleep(2000);
			driver.findElement(By.xpath("//*[contains(@id,'btn_form_')]")).click();
			Thread.sleep(2000);//Move to Editor Decision
			driver.findElement(By.xpath("//button[contains(text(),'Move to Finalise Decision Accept')]")).click();
			Thread.sleep(1000);
			boolean existt=driver.findElements(yesbutton2).size()!=0;
			if(existt==true)
			{
			driver.findElement(yesbutton2).click();
			}
			Thread.sleep(3000);
			driver.findElement(By.xpath("//*[contains(@class,'swal2-cancel swal2-styled')]")).click();
			Thread.sleep(3000);
			driver.findElement(okButton2).click();
			Thread.sleep(3000);
	 }
			


}
