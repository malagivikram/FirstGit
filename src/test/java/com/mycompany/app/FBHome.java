package com.mycompany.app;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.mycompany.pageObjects.FBLandingPage;
import com.mycompany.resources.Base;

public class FBHome extends FBLandingPage {
	public static org.apache.logging.log4j.Logger log=LogManager.getLogger(Base.class.getName());
	@BeforeTest
	public void openHomePage() throws IOException {
		enterURL();
		log.debug("Browser opened and URL entered");
	}
	
	@AfterTest
	public void closeBrowser() {
		driver.close();
	}
}
