package com.creatio.crm.application.tests;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import com.creatio.crm.application.steps.CookiesPopupPageSteps;
import com.creatio.crm.application.steps.HomePageSteps;
import com.creatio.crm.application.steps.LoginPageSteps;
import com.creatio.crm.framework.base.BasePage;
import com.creatio.crm.framework.utilities.ExcelUtil;


	public class BaseTest extends BasePage {

		public LoginPageSteps loginPage;
		public CookiesPopupPageSteps cookiesPage;
		public HomePageSteps homePage;
		
		@BeforeMethod(alwaysRun = true, dependsOnMethods = { "setupBrowser" })
		public void initializePages() {
			WebDriver driver = BasePage.getDriver();
			loginPage = new LoginPageSteps(driver);
			cookiesPage = new CookiesPopupPageSteps(driver);
			homePage = new HomePageSteps(driver);
			
		}

		@DataProvider(name = "data")
		public String[][] testData(Method method) {
			String[][] data = ExcelUtil.readData("TestData.xlsx", method.getName());
			return data;
		}

	}
	

