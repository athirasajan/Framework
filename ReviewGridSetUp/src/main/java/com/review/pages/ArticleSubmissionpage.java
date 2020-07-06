/**
 * 
 */
package com.review.pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;



import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;



/**
 * @author athira
 *
 */
public class ArticleSubmissionpage {
	
	WebDriver driver;
	String ID1;
	
	By submitArticle=By.xpath("//*[@id='article_submit']/div/span[2]");
	//By articleType=By.xpath("//*[@id='artcicle_select_820']/a/b");
	By articleType=By.linkText("Test Article Type for Automation");
	
	By articleTitle=By.id("tinymce");
	By articleAbstract=By.id("tinymce");
	By browse=By.id("browse_article_keywords");
	By checkbox=By.xpath("//*[@id='article_keyword_browse_modal_contents']/div/div[1]/label/input");
	By checkbox2=By.xpath("//*[@id='article_keyword_browse_modal_contents']/div/div[2]/label/input");
	By select=By.id("btn_selct_art_kywrd");
	By continueButton=By.id("btn_article_save");
	By author=By.xpath("//*[@id='view_user_as']/li/a");
	By draft=By.xpath("//*[@id='manage-draft']/div/div[1]");
	By viewArticle=By.xpath("//*[@id='art-detail-5568']/div/span/a");
	//*[@id="art-detail-5568"]/div/span/a
	//*[@id="art-detail-5556"]/div/span/a
	//*[@id="art-detail-5232"]/div/span/a
	//*[@id="second_content_5192"]/div/span[1]/a
	By continueButton2=By.id("btn_co_author_proceed");
	By uploadFile=By.xpath("//*[@id='files']");
	By description=By.xpath("//*[contains(@id,'file_desc_opt_')]");
	//*[@id="file_desc_opt_10033"]
	By generatePDF=By.id("art_pdf");
	By previewPDF=By.xpath("//*[contains(@class,'swal2-confirm')]");
	
	By continueButton3=By.id("btn_save_attachment");
	By submit=By.xpath("//*[@id='sidebar-mini_id']/div[1]/div[1]/section[2]/div[2]/div/div/div/div[3]/button");
	By okButton=By.xpath("//*[contains(@class,'swal2-confirm')]");
	By articleID=By.xpath("//*[@id='article_details']/div/div[1]/div[2]/table/tbody/tr[1]/td");
	By loading=By.xpath("//*[@id='ajax_loader']/img");
	
	public ArticleSubmissionpage(WebDriver driver){
		this.driver=driver;
		
	}
	public void ArticleSubmission(String Type,String AType,String AAbstract,String FLocation) throws Exception{
		
		
		Thread.sleep(1000);
		String journal=driver.findElement(By.xpath("//a/h1/strong")).getText();
		//Assert.assertTrue(journal.equals(Utility.getData(0,1,0)));
		System.out.println(journal);
		
		Thread.sleep(2000);
		driver.findElement(By.linkText("Author")).click();
		Thread.sleep(1000);
		driver.findElement(submitArticle).click();
		Thread.sleep(1000);
		driver.findElement(By.linkText(Type)).click();
		Thread.sleep(1000);
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='article_title_ifr']")));

		 //Do not use path body/p you need to send text to body tag

		 (new WebDriverWait(driver, 10)) .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body[@id='tinymce']")));

		 driver.findElement(By.xpath("//body[@id='tinymce']")).sendKeys(AType);

		 driver.switchTo().defaultContent();
		 
		 driver.manage().timeouts().implicitlyWait(0, TimeUnit.MILLISECONDS);
		 boolean exists = driver.findElements( By.xpath("//*[@id='article_topic_chosen']/ul/li/input") ).size() != 0;
		 
			 if(exists==true)
			 {
				 driver.findElement(By.xpath("//*[@id='article_topic_chosen']/ul/li/input")).sendKeys("primary",Keys.ENTER);
			 }
			 boolean exist = driver.findElements( By.xpath("//*[@id='article_keyword_chosen']/ul/li/input") ).size() != 0;
			 
			 if(exist==true)
			 {
				 driver.findElement(By.xpath("//*[@id='article_keyword_chosen']/ul/li/input")).sendKeys("secondary",Keys.ENTER);
			 }
			 //driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		 driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='article_abstract_ifr']")));

		 //Do not use path body/p you need to send text to body tag

		 (new WebDriverWait(driver, 10)) .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body[@id='tinymce']")));

		 driver.findElement(By.xpath("//body[@id='tinymce']")).sendKeys(AAbstract);

		 driver.switchTo().defaultContent();
		 Thread.sleep(2000);
		 boolean browseB=driver.findElements(browse).size()!=0;
		 if(browseB==true){
		
		
		driver.findElement(browse).click();
		Thread.sleep(1000);
		driver.findElement(checkbox).click();
		Thread.sleep(1000);
		//driver.findElement(browse).click();
		//Thread.sleep(1000);
		driver.findElement(checkbox2).click();
		Thread.sleep(1000);
		//driver.findElement(select).click();
		List<WebElement> SelectButtons = driver.findElements(select);

        for(WebElement button : SelectButtons) {
         if(button.isDisplayed()) {
             button.click();
          }
        }
		Thread.sleep(1000);
		
		 }
		 
		 else
		 {
			 driver.findElement(By.xpath("//*[@id='art_keywords_chosen']/ul/li/input")).click();
			 Thread.sleep(1000);
			// driver.findElement(By.xpath("//*[contains(@class,'col-sm-2 control-label')]")).click();
			 //Thread.sleep(1000);
			// driver.findElement(By.id("art_keywords_chosen")).click();
			 Thread.sleep(1000);
			 driver.findElement(By.xpath("//*[@id='art_keywords_chosen']/ul/li/input")).sendKeys("hibiscus",Keys.ENTER,"1-butanol",Keys.ENTER);
			 Thread.sleep(1000);
			 
		 }
		 
		driver.findElement(continueButton).click();
		//Thread.sleep(3000);
		//driver.findElement(author).click();
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,250)", "");
		// WebDriverWait wait = new WebDriverWait(driver, 30);
		 //WebElement select = wait.until(ExpectedConditions.visibilityOfElementLocated(continueButton2));
		 //select.click();
		Thread.sleep(3000);
		WebElement ele=driver.findElement(continueButton2);
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", ele);
		Thread.sleep(3000);
		//driver.findElement(continueButton2).click();
		driver.findElement(uploadFile).sendKeys(FLocation);
		Thread.sleep(3000);
		
		boolean drop=driver.findElements(description).size()!=0;
		if(drop==true){
			System.out.println("drop");
			
			
		
			
			boolean edit=driver.findElement(By.xpath("//*[contains(@id,'file_desc_edit_')]")).isDisplayed();
			if(edit==true){
				
				System.out.println("edit");
				//driver.findElement(By.xpath("//*[contains(@id,'file_desc_edit_')]")).click();
				
			}
			else
			{
			
		Select dropdown1=new Select(driver.findElement(description));
		dropdown1.selectByVisibleText("Figure");
		Thread.sleep(1000);
			}
		}
		driver.findElement(generatePDF).click();
		Set<String> windows = driver.getWindowHandles();
		Thread.sleep(2000);
		WebElement pdf=driver.findElement(previewPDF);
		JavascriptExecutor executor1 = (JavascriptExecutor)driver;
		executor1.executeScript("arguments[0].click();", pdf);
		Thread.sleep(2000);
		//driver.findElement(previewPDF).click();
		 for (String window : windows) {
	            driver.switchTo().window(window);
	            System.out.println(driver.getTitle());
	        }
			
			Thread.sleep(2000);
			driver.findElement(continueButton3).click();
			Thread.sleep(1000);
			 boolean continueButton = driver.findElements( By.id("btn_oppose_reviewer_proceed")).size() != 0;
			 
			 if(continueButton==true)
			 {
				 driver.findElement(By.id("btn_oppose_reviewer_proceed")).click();
			 }
			
		List<WebElement>forms=driver.findElements(By.xpath("//*[contains(@class,'collapse-div')]"));
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
		Thread.sleep(1000);
		List<WebElement>button=driver.findElements(By.xpath("//*[contains(@class,'swal2-confirm')]"));
		System.out.println(button.size());
	     button.get(0).click();
		Thread.sleep(1000);
		
		String ID=driver.findElement(articleID).getText();
		
		
		
		ID1=ID.replace("Preview PDF", "");
		
		System.out.println("Article id is"+ID1);
		//Thread.sleep(2000);
		  
			  
			  // Specify the file path which you want to create or write
			 
			  File src=new File("C:/Users/athira/workspace/ReviewNew/src/main/java/com/Review/qa/testdata/test.xlsx");
			 
			  // Load the file
			 
			  FileInputStream fis=new FileInputStream(src);
			 
			   // load the workbook
			 
			   XSSFWorkbook wb=new XSSFWorkbook(fis);
			 
			  // get the sheet which you want to modify or create
			 
			   XSSFSheet sh1= wb.getSheetAt(0);
			   sh1.getRow(0).createCell(0).setCellValue(ID1);
			   FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				fout.close();
				
		
				
				Thread.sleep(2000);		
				WebElement submitB=driver.findElement(By.name("final_submit"));
				JavascriptExecutor executor11 = (JavascriptExecutor)driver;
				executor11.executeScript("arguments[0].click();", submitB);
				Thread.sleep(1000);
				boolean existt = driver.findElements(By.xpath("//*[contains(@class,'btn-small btn-primary')]") ).size() != 0;
				 
				 if(existt==true)
				 {
					 driver.findElement(By.xpath("//*[contains(@class,'btn-small btn-primary')]")).click();
				 }
				 WebDriverWait wait3 = new WebDriverWait(driver,15);
					wait3.until(ExpectedConditions.invisibilityOfElementLocated(loading));
					
		Thread.sleep(3000);
		String alertText=driver.findElement(By.xpath("//h2[@class='swal2-title']")).getText();
		Assert.assertTrue(alertText.contains("Thank you! Your paper has now been submitted"));
		System.out.println(alertText);
		Thread.sleep(1000);
		driver.findElement(okButton).click();
		Thread.sleep(2000);
		driver.findElement(author).click();
		Thread.sleep(3000);
		
	
	
	

	
	}
	
	
	
	
	
	

}
