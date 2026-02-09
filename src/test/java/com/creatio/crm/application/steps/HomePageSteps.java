package com.creatio.crm.application.steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.creatio.crm.application.elements.HomePageElements;

public class HomePageSteps extends HomePageElements{
	
	public HomePageSteps(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	// Click Application Hub link
	public void clickApplicationHub() {
	    waitForElement(applicationHubLink);
	    Assert.assertTrue(applicationHubLink.isDisplayed(),
	            "Application Hub link is NOT displayed.");
	    clickElement(applicationHubLink);
	    log("info", "Clicked Application Hub link successfully.");
	}

	// Click Users link
	public void clickUsersLink() {
	    waitForElement(usersLink);
	    Assert.assertTrue(usersLink.isDisplayed(),
	            "Users link is NOT displayed.");
	    clickElement(usersLink);
	    log("info", "Clicked Users link successfully.");
	}

	// Click User Profile Icon
	public void clickUserProfileIcon() {
		waitForElement(userProfileIcon);
	    Assert.assertTrue(userProfileIcon.isDisplayed(),
	            "User Profile Icon is NOT displayed.");
	    clickElement(userProfileIcon);
	    log("info", "Clicked User Profile Icon successfully.");
	}
    
	// Click Logout 
	public void clickLogout() {
	    waitForElement(logout);
	    Assert.assertTrue(logout.isDisplayed(),
	            "Logout option is NOT displayed.");
	    clickElement(logout);
	    log("info", "Clicked Logout option successfully.");
	}

}
