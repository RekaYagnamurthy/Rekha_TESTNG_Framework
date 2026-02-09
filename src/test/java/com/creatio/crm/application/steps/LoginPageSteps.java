package com.creatio.crm.application.steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.creatio.crm.application.elements.LoginPageElements;

public class LoginPageSteps extends LoginPageElements {

	public LoginPageSteps(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// Verify whether login page is displayed

	public void verifyLoginPageIsDisplayed() {
		waitForElement(headerLoginToYourAccount);
		Assert.assertTrue(headerLoginToYourAccount.isDisplayed(), "Login Page is NOT displayed.");
		log("info", "Login Page is displayed successfully.");
	}

	// Enter Business Email
	public void enterBusinessEmail(String businessEmail) {
		waitForElement(txtBusinessEmail);
		Assert.assertTrue(txtBusinessEmail.isDisplayed(), 
				"Business Email textbox is NOT displayed.");
		typeText(txtBusinessEmail, businessEmail);
		log("info", "Entered business email successfully.");
	}

	// Enter Password
	public void enterPassword(String password) {
		waitForElement(txtPassword);
		Assert.assertTrue(txtPassword.isDisplayed(), 
				"Password textbox is NOT displayed.");
		typeText(txtPassword, password);
		log("info", "Entered password successfully.");
	}
	
	// Click Login button 
	public void clickLoginButton() {
	    waitForElement(btnLogin);
	    Assert.assertTrue(btnLogin.isDisplayed(), 
	            "Login button is NOT displayed.");
	    clickElement(btnLogin);
	    log("info", "Clicked Login button successfully.");
	}
	
	// Validate navigation back to Login Page
	public void validateNavigatedBackToLoginPage() {
	    waitForElement(headerLoginToYourAccount);
	    Assert.assertTrue(headerLoginToYourAccount.isDisplayed(),
	            "Did NOT navigate back to Login Page.");
	    log("info", "Navigated back to Login Page successfully.");
	}

	// Click Forgot Password 
	public void clickForgotPassword(String businessEmail) {
		enterBusinessEmail(businessEmail);
	    waitForElement(linkForgotPassword);
	    Assert.assertTrue(linkForgotPassword.isDisplayed(), 
	            "Forgot Password link is NOT displayed.");
	    clickElement(linkForgotPassword);
	    log("info", "Clicked Forgot Password link successfully.");
	}
	
	// Validate Reset Password Confirmation Page Title
	public void validateResetPasswordConfirmation() {
	    waitForElement(resetPasswordConfirmation);
	    Assert.assertTrue(resetPasswordConfirmation.isDisplayed(),
	            "Reset Password Confirmation title is NOT displayed.");
	    log("info", "Reset Password Confirmation title is displayed successfully.");
	}

	// Click LinkedIn Login 
	public void clickLinkedInLogin() {
	    waitForElement(LoginLinkedIn);
	    Assert.assertTrue(LoginLinkedIn.isDisplayed(), 
	            "LinkedIn login icon is NOT displayed.");
	    clickElement(LoginLinkedIn);
	    log("info", "Clicked LinkedIn login icon successfully.");
	}  
	
	// Click Google Login 
	public void clickGoogleLogin() {
	    waitForElement(LoginGoogle);
	    Assert.assertTrue(LoginGoogle.isDisplayed(), 
	            "Google login icon is NOT displayed.");
	    clickElement(LoginGoogle);
	    log("info", "Clicked Google login icon successfully.");
	}
	
	// Validate 'Don't have an account?' text
	public void validateDontHaveAccountText() {
	    waitForElement(textDontHaveAccount);
	    Assert.assertTrue(textDontHaveAccount.isDisplayed(),
	            "'Don't have an account?' text is NOT displayed.");
	    log("info", "'Don't have an account?' text is displayed successfully.");
	}

	// Click Sign Up link 
	    public void clickSignUpLink() {
	        waitForElement(linkSignUp);
	        Assert.assertTrue(linkSignUp.isDisplayed(), 
	                "Sign Up link is NOT displayed.");
	        clickElement(linkSignUp);
	        log("info", "Clicked Sign Up link successfully.");
	    }

	}


