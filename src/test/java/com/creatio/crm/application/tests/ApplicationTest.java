package com.creatio.crm.application.tests;

import org.testng.annotations.Test;

public class ApplicationTest extends BaseTest {

	@Test(priority=1)
	public void verifyCookiePopupDisplayed() throws InterruptedException  {
		loginPage.launchApplication();
		cookiesPage.verifyCookiePopUpIsDisplayed();
	}
		
			
	}
		
