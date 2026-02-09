package com.creatio.crm.application.elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.creatio.crm.framework.web.commons.WebCommons;

public class LoginPageElements extends WebCommons { 
	
	    @FindBy(xpath = "//span[@class='form-title']")
	    public WebElement headerLoginToYourAccount;
	    
	    @FindBy (xpath = "//input[@aria-label='Business email']")
		public WebElement txtBusinessEmail;
	    
	    @FindBy (xpath = "//input[@type='password']")
		public WebElement txtPassword;
	    
	    @FindBy(xpath = "//a[contains(text(),'Forgot password')]") 
	    public WebElement linkForgotPassword;
	    
	    @FindBy(xpath = "//title[contains(normalize-space(),'Reset password')]") 
	    public WebElement resetPasswordConfirmation; 
	        
	    @FindBy (xpath = "//span[contains(@class,'btn')][normalize-space()='LOG IN']")
	    public WebElement btnLogin;
	    
	 	@FindBy(xpath = "//img[@class='icon-LinkedIn']") 
	    public WebElement LoginLinkedIn; 
	    
	    @FindBy(xpath = "//img[@class='icon-google']") 
	    public WebElement LoginGoogle;
	       
	    @FindBy(xpath = "//span[@class='login-question']")
	    public WebElement textDontHaveAccount;
	    
	    @FindBy(xpath = "//a[contains(text(),'SIGN UP')]") 
	    public WebElement linkSignUp; 
	    
	    
	    
}

	   