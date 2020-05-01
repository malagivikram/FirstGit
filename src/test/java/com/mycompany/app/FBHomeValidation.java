package com.mycompany.app;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.mycompany.pageObjects.FBHomeElemPage;
import com.mycompany.pageObjects.FBLandingPage;
import com.mycompany.resources.Base;

import junit.framework.Assert;

public class FBHomeValidation extends FBLandingPage {
	public static org.apache.logging.log4j.Logger log=LogManager.getLogger(Base.class.getName());
	
	FBHomeElemPage elems;
	
	@BeforeTest
	public void openHomePage() throws IOException {
		enterURL();
	}
	
	@Test
	public void valTitle() throws IOException {
		
		elems=new FBHomeElemPage(driver);
		//Validate the Title of the page
		Assert.assertEquals("Facebook – log in or ", driver.getTitle());
		
	}
	
	
	@Test
	public void valCreateaccntText() throws IOException {
		elems=new FBHomeElemPage(driver);
		//Validate text of Create an acccount
		Assert.assertEquals("Create an account", elems.getAccntText().getText());
	}
	
	@Test
	public void valSignupbtn() {
		elems=new FBHomeElemPage(driver);
		//Validate signup button
		Assert.assertTrue(elems.getSignUp().isDisplayed());
		log.info("All the assertions got passed");
	}
	
	@Test
	public void valGender() {
		elems=new FBHomeElemPage(driver);
		//Validate Gender
		Assert.assertNotNull(elems.getGender());
		
	}
	
	@AfterTest
	public void closeBrowser() {
		driver.close();
	}
}
