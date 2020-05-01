package com.mycompany.app;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.mycompany.pageObjects.FBLandingPage;
import com.mycompany.pageObjects.FBLoginPage;
import com.mycompany.resources.Base;

public class FBLogin extends FBLandingPage{
	public static org.apache.logging.log4j.Logger log=LogManager.getLogger(Base.class.getName());
	@BeforeTest
	public void openHomePage() throws IOException {
		enterURL();
	}
	
	@Test(dataProvider = "getData")
	public void loginTest(String username, String password) {
		FBLoginPage fb=new FBLoginPage(driver);
		fb.getEmail().sendKeys(username);
		fb.getPassword().sendKeys(password);
		fb.getLogin().click();
		log.info("Data insertes with help of DataProvider and passed");
	}
	
	@DataProvider
	public Object[][] getData() {
		
		Object[][] data=new Object[1][2];
		data[0][0]="Restricted.user";
		data[0][1]="vikram.malagi";
		
		//We can send multiple set of datas for valid and invalid scenarios
		//data[1][0]="Non.Restricted.user";
		//data[1][1]="malagivikram";
		
		return data;
	}
	

	@AfterTest
	public void closeBrowser() {
		driver.close();
	}
}
