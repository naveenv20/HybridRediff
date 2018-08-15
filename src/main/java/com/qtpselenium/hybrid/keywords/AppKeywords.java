package com.qtpselenium.hybrid.keywords;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.Status;

public class AppKeywords extends GenericKeywords {

	public void login(){
		test.log(Status.INFO, "Logging in"); 
		getObject("money_xpath").click();
		getObject("signin_xpath").click();
		String username="";
		String password="";
		
		if(data.get("Username") == null){
			username=envProp.getProperty("defaultUsername");
			password=envProp.getProperty("defaultPass");
		}else{
			username=data.get("Username");
			password=data.get("Password");
		}
		getObject("username_id").sendKeys(username);
		getObject("emailsubmit_id").click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(getObject("password_id")));
		
		getObject("password_id").sendKeys(password);
		getObject("continue_id").click();
		// security warining - mozilla
		wait(5);
		
		acceptAlert();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("password_id")));
	}
	
	
	public void validateLogin(){
		test.log(Status.INFO, "Validating Login");
		boolean result = isElementPresent("portfolioSelection_xpath");
		String expectedResult=data.get("ExpectedResult");
		String actualResult="";
		
		if(result)	
			actualResult="Loginsuccess";
		else
			actualResult="Loginfailure";
		if(!actualResult.equals(expectedResult))
			reportFailure("Got  result "+actualResult );

		
		
	}
	
	public void defaultLogin(){
		test.log(Status.INFO, "Logging in with default ID");

		String username=envProp.getProperty("adminusername");
		String password=envProp.getProperty("adminpassword");
		System.out.println("Default username "+username );
		System.out.println("Default password "+password );
	}
	
	
	
}
