package com.creatio.crm.application.steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.creatio.crm.application.elements.CookiesPopupPageElements;

public class CookiesPopupPageSteps extends CookiesPopupPageElements {

	public CookiesPopupPageSteps(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// Verify cookies pop-up is displayed.
	public void verifyCookiePopUpIsDisplayed() {
		waitForElement(cookiePopUpHeader);
		log("info", "Cookie pop-up is displayed successfully.");
	}

	// Verify that the cookies pop-up header is displayed

	public void verifyCookiesPopUpHeader() {
		waitForElement(cookiePopUpHeader);

		String expectedHeader = "This website uses cookies";
		String actualHeader = getText(cookiePopUpHeader);

		Assert.assertEquals(actualHeader, expectedHeader, "Cookies pop-up header text is incorrect.");
		log("info", "Cookies pop-up header is displayed with correct text: " + actualHeader);
	}

	// Verify cookies pop-up content message.
	public void verifyCookiesPopUpContentMessage(String expMessage) {
		waitForElement(cookieContentMsg);
		Assert.assertTrue(cookieContentMsg.isDisplayed(), "Cookies pop-up content message is NOT displayed.");

		String actualMessage = getText(cookieContentMsg);

		Assert.assertEquals(actualMessage, expMessage, "Cookies pop-up content message is not as expected.");
		log("info", "Cookies pop-up content message is as expected.");
	}

	// Verify that the Creatio logo is displayed on the cookies pop-up.
	public void verifyCreatioLogoIsDisplayed() {
		waitForElement(creatioLogo);
		log("info", "Creatio logo on the cookies pop-up is displayed successfully.");
	}

	// Verify that the Cookiebot logo is displayed on the cookies pop-up.
	public void verifyCookieBotLogoIsDisplayed() {
		waitForElement(cookieBotLogo);
		log("info", "Cookiebot logo on the cookies pop-up is displayed successfully.");
	}

	// Verify all cookie category labels are displayed on the cookies pop-up.
	public void verifyAllLabelsAreDisplayed() {
		waitForElement(labelNecessary);
		waitForElement(labelPreferences);
		waitForElement(labelStatistics);
		waitForElement(labelMarketing);
		log("info", "All cookie category labels are displayed successfully.");

	}

	// Verify that the 'Necessary' label is disabled/unclickable and that only the toggle bar is clickable.
	public void verifyNecessaryToggleFunctionality(String expectedAlertMessage) {
		waitForElement(labelNecessary);
		Assert.assertFalse(labelNecessary.isEnabled(), "'Necessary' label SHOULD be disabled but is enabled.");
		log("info", "'Necessary' label is disabled and unclickable as expected.");

		waitForElement(necessaryToggleBar);
		log("info", "'Necessary' toggle bar is displayed.");

		necessaryToggleBar.click();
		log("info", "Clicked 'Necessary' toggle bar.");

		// Capture the alert message and close it
		String actualAlertMessage = captureAlertTextAndClose(true);
		Assert.assertEquals(actualAlertMessage, expectedAlertMessage, "Popup alert message is NOT as expected.");
		log("info", "Popup alert message validated: " + actualAlertMessage);
	}

	// Verify check/uncheck functionality for 'Preferences' by clicking the label.
	public void verifyPreferencesToggleFunctionality() {

		waitForElement(labelPreferences);
		// Toggle ON
		labelPreferences.click();
		log("info", "'Preferences' toggle turned ON by clicking the label.");

		// Toggle OFF
		labelPreferences.click();
		log("info", "'Preferences' toggle turned OFF by clicking the label.");
	}

	// Verify check/uncheck functionality for 'Statistics' by clicking the label.
	public void verifyStatisticsToggleFunctionality() {

		waitForElement(labelStatistics);
		// Toggle ON
		labelStatistics.click();
		log("info", "'Statistics' toggle turned ON by clicking the label.");

		// Toggle OFF
		labelStatistics.click();
		log("info", "'Statistics' toggle turned OFF by clicking the label.");

	}

	// Verify check/uncheck functionality for 'Statistics' by clicking the label.
	public void verifyMarketingToggleFunctionality() {

		waitForElement(labelMarketing);
		// Toggle ON
		labelMarketing.click();
		log("info", "'Marketing' toggle turned ON by clicking the label.");

		// Toggle OFF
		labelStatistics.click();
		log("info", "'Marketing' toggle turned OFF by clicking the label.");

	}
	//verify showDetails link is displayed 
		public void verifyShowDetailsLink() { 
			waitForElement(showDetailsLink); 
		log("info", "Show details link is displayed successfully."); 
		}
		
		//Method to click on Show Details link and verify expanded view tabs 
		public void clickOnShowDetailsLink() { 
			waitForElement(showDetailsLink); 
			showDetailsLink.click();
			log("info", "Clicked on show details link successfully."); 
			
		// Verify expanded view - Details tab 
		waitForElement(cokkiesPopUpExpandedViewDetails); 
		log("info", "Expanded view 'Details' tab is displayed successfully."); 
		
		// Verify expanded view - About tab 
		waitForElement(cokkiesPopUpExpandedViewAbout); 
		log("info", "Expanded view 'About' tab is displayed successfully."); }
		

	//Verify all cookie selection buttons and links are displayed and clickable
	public void clickOnSelectionButton(String buttonName) {
	    String name = buttonName.toLowerCase();

	    if ("allow all".equals(name) || "allowall".equals(name)) {
	        waitForElement(allowAllBtn);
	        Assert.assertTrue(allowAllBtn.isDisplayed(), "Allow All button is not displayed.");
	        allowAllBtn.click();
	        log("info", "Clicked on Allow All button successfully.");
	    } else if ("allow selection".equals(name) || "allowSelectionBtn".equals(name)) {
	        waitForElement(allowSelectionBtn);
	        Assert.assertTrue(allowSelectionBtn.isDisplayed(), "Allow Selection button is not displayed.");
	        allowSelectionBtn.click();
	        log("info", "Clicked on Allow Selection button successfully.");
	    } else {
	        log("error", "Invalid button name provided: " + buttonName);
	        Assert.fail("Invalid button name provided: " + buttonName);
	    }
	}
	    
	//Method to verify that cookies pop-up is closed
	public void verifyCookiesPopUpIsClosed()  {
		waitForElementToBeDisappear(cookiePopUpHeader);
		log("info","Cookies pop-up is closed successfully.");		
	}

}