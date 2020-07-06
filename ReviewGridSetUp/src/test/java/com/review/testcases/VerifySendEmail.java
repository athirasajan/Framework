/**
 * 
 */
package com.review.testcases;

import org.testng.annotations.Test;

import com.review.pages.SendEmail;




/**
 * @author athira
 *
 */
public class VerifySendEmail {
	@Test
	public void EmailTest(){
		SendEmail email=new SendEmail();
		email.EmailSend();
		
	}

}
