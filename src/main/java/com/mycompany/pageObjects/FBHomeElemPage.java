package com.mycompany.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FBHomeElemPage {

	public WebDriver driver;
	public FBHomeElemPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@class='_5iyz rfloat _ohf']/div/div/div[1]/span[text()='Create an account']")
	WebElement createaccnt;
	
	@FindBy(id="u_0_7")
	WebElement gender;
	
	@FindBy(name="websubmit")
	WebElement signUp;
	
	public WebElement getAccntText() {
		 return createaccnt;
	}
	
	public WebElement getGender() {
		 return gender;
	}
	
	public WebElement getSignUp() {
		 return signUp;
	}
	
}
