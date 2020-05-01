package com.mycompany.pageObjects;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;

import com.mycompany.resources.Base;

public class FBLandingPage extends Base {
	public static org.apache.logging.log4j.Logger log=LogManager.getLogger(Base.class.getName());
	public void enterURL() throws IOException {
		driver=initBrowsers();
		driver.get(prop.getProperty("url"));
		
	}
	
}
