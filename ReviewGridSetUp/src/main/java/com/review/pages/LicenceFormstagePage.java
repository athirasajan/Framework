/**
 * 
 */
package com.review.pages;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;



import org.openqa.selenium.By;
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
public class LicenceFormstagePage {
	WebDriver driver;

	By Decision=By.id("manage-final-decision");
	By loading=By.xpath("//*[@id='ajax_loader']/img");
	By Start=By.xpath("//*[@id='action_btns_div']/div/button");
	By yesButton=By.xpath("//*[contains(@class,'btn-small btn-primary')]");
	By yesbutton2=By.xpath("//*[contains(@class,'btn-small btn-primary')]");
	By okButton2=By.xpath("//*[contains(@class,'btn-primary btn_nxt_stage_details_modal')]");
	 public LicenceFormstagePage(WebDriver driver){
			this.driver=driver;
		}
	 public void licenceForm() throws Exception{
		 
		 String journal=driver.findElement(By.xpath("//a/h1/strong")).getText();
			Assert.assertTrue(journal.equals(Utility.getData(0,1,0)));
			System.out.println(journal);
			
		 Thread.sleep(1000);
		 driver.findElement(By.linkText("Author")).click();
		 Thread.sleep(2000);
		 WebDriverWait wait3 = new WebDriverWait(driver,15);
			wait3.until(ExpectedConditions.invisibilityOfElementLocated(loading));
			Thread.sleep(2000);
			String ID=Utility.getData(0,0,0);
			driver.findElement(By.name("search_value")).sendKeys(ID);
			Thread.sleep(1000);
		 	/*driver.findElement(Decision).click();
			Thread.sleep(3000);
			boolean last=driver.findElements(By.linkText("Last ›")).size()!=0;
			if(last==true){
				driver.findElement(By.linkText("Last ›")).click();	
				Thread.sleep(3000);
			}
			else{
			
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
			}*/
			
			
			WebElement t2=driver.findElement(By.xpath("//*[contains(text(), '"+ID.trim()+"')]/ancestor::div[contains(@class,'box box-')]"));
			System.out.println(t2.getText());
			Utility.highLightElement(driver, t2);
			WebElement t3=t2.findElement(By.linkText("View article"));
			System.out.println(t3.getText());
			Thread.sleep(1000);
			t3.click();
			Thread.sleep(1000);
			//driver.findElement(Start).click();
			//Thread.sleep(1000);
			//driver.findElement(yesButton).click();
			//Thread.sleep(3000);
			
			List<WebElement>forms=driver.findElements(By.xpath("//*[contains(@class,'form-horizontal generic')]"));
			System.out.println("form"+forms.size());
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
			            	//if(!elementt.isSelected())
			            		
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
			    	elementtt.sendKeys("testtesttest");
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
			    	/*else if(element4.getAttribute("name").contains("date")){
			    		element4.click();
			    		Thread.sleep(3000);
			   		 DateFormat dateFormat2 = new SimpleDateFormat("d"); 
			            Date date2 = new Date();

			            String today = dateFormat2.format(date2);
			            System.out.println("date"+today);

			            //find the calendar
			            WebElement dateWidget = driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/table"));  
			            List<WebElement> columns=dateWidget.findElements(By.tagName("td"));  

			            //comparing the text of cell with today's date and clicking it.
			            for (WebElement cell : columns)
			            {
			               if (cell.getText().equals(today))
			               {
			            	   System.out.println("if loop");
			            	   System.out.println(cell.getText());
			            	   System.out.println(today);
			                  cell.click();
			                  break;
			               }
			            }
			    		
			    	}*/
			    	else
			    	{
			    	element4.sendKeys("test btest test");
			    	}
			    	
			    	
			    }
			}
			

		   	Thread.sleep(1000);
		   	
		   /*	List<WebElement> allFormChildElements5 = driver.findElements(By.xpath("//*[contains(@id,'_group_element_')]/div/span[1]"));
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
		   	}*/
		   	
			/*List<WebElement> allFormChildElements7 = driver.findElements(By.xpath("//input[@type='radio']"));
			System.out.println(allFormChildElements7.size());
			if(allFormChildElements7.size()>0)
			{
			java.util.Iterator<WebElement> n = allFormChildElements7.iterator();
		   	while(n.hasNext()) {
		   	    WebElement radiobutton1 = n.next();
		   	    if (radiobutton1.isDisplayed()) {
			    	System.out.println("Radio button");
			    	//driver.findElement(By.xpath("//*[contains(@name,'"+formId+"')]")).sendKeys("test");
			    	if(radiobutton1.getAttribute("value").equals("CC-BY"))
			    	{
			    		Thread.sleep(2000);
			    		radiobutton1.click();
			    	}
			    }
		   	}
			}*/
		   	
		   	
			
		   
			Thread.sleep(1000);
			driver.findElement(By.xpath("//*[contains(text(),'Save ')]")).click();
			}
			Thread.sleep(1000);
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

			WebElement radio=driver.findElement(By.xpath("//*[@id='option_2']/label/input"));
			if(!radio.isSelected()){
				radio.click();
			}
			Thread.sleep(1000);
			driver.findElement(By.name("copyright[copyright_date]")).click();
			Thread.sleep(3000);
	   		 DateFormat dateFormat2 = new SimpleDateFormat("d"); 
	            Date date2 = new Date();

	            String today = dateFormat2.format(date2);
	            System.out.println("date"+today);

	            //find the calendar
	            WebElement dateWidget = driver.findElement(By.xpath("//*[@class='datepicker-days']/table"));  
	            List<WebElement> columns=dateWidget.findElements(By.tagName("td"));  

	            //comparing the text of cell with today's date and clicking it.
	            for (WebElement cell : columns)
	            {
	               if (cell.getText().equals(today))
	               {
	            	   System.out.println("if loop");
	            	   System.out.println(cell.getText());
	            	   System.out.println(today);
	                  cell.click();
	                  break;
	               }
	            }
	    		
	            Thread.sleep(2000);
			driver.findElement(By.id("save_copyright")).click();
			
			Thread.sleep(3000);
			
			
			
			driver.findElement(By.xpath("//button[contains(text(),'Submit')]")).click();
			Thread.sleep(2000);
			driver.findElement(yesbutton2).click();
			Thread.sleep(3000);
			//driver.findElement(okButton2).click();
	 }
			


}
