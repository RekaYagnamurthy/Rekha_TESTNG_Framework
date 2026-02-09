package com.creatio.crm.framework.web.commons;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.creatio.crm.framework.base.BasePage;
import com.creatio.crm.framework.constants.Constants;
import com.creatio.crm.framework.reports.Reports;
import com.creatio.crm.framework.utilities.PropUtil;

public class WebCommons {

//This class will contain all the common methods related to web application by using selenium. 

	public WebDriver driver = BasePage.getDriver();
	public Properties prop = PropUtil.readData("config.propeties");

// Common method to enter URL and launch the Application and verify the application title.
	public void launchApplication() throws InterruptedException {
		driver.get(prop.getProperty("app.url"));
		wait(3);
		String expectedTitle = prop.getProperty("app.title");
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle, "Page title verification failed!");
	}

// Common method to scroll the element.
	public void scrollToElement(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}

//Common method to click on element.
	public void clickElement(WebElement element) {
		scrollToElement(element);
		element.click();
	}

// Common method to click on hidden element

	public void clickHiddenElement(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
	}

	// Common method to double click an element

	public void doubleClickElement(WebElement element) {
		Actions actions = new Actions(driver);
		actions.doubleClick(element).perform();
	}

	// Common method to right click an element
	public void rightClickElement(WebElement element) {
		Actions actions = new Actions(driver);
		actions.contextClick(element).perform();
	}

	// Common method to hover over the element.
	public void hoverOverElement(WebElement element) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element).perform();
	}

	// Common method to type the text in to a text box.
	public void typeText(WebElement element, String text) {
		scrollToElement(element);
		element.clear();
		element.sendKeys(text);
	}

	// Common method to check if element is selected
	public boolean isElementSelected(WebElement element) {
		try {
			scrollToElement(element);
			return element.isSelected();
		} catch (Exception e) {
			return false;
		}
	}

	// Common method to select the option from drop-down.
	public void selectOptionByVisibleText(WebElement dropdownElement, String option, String selectBy) {
		scrollToElement(dropdownElement);
		Select select = new Select(dropdownElement);
		switch (selectBy.toLowerCase()) {
		case "visibletext":
			select.selectByVisibleText(option);
			break;

		case "value":
			select.selectByValue(option);
			break;

		case "index":
			try {
				int index = Integer.parseInt(option);
				select.selectByIndex(index);
			} catch (NumberFormatException e) {
				Assert.fail("Option must be an integer for selectBy='index'");
			}
			break;

		default:
			Assert.fail("Invalid Select option");
		}
	}

	// Common method to get text from an element.
	public String getText(WebElement element) {
		scrollToElement(element);
		return element.getText();
	}

	// Common method to select the check box
	public void selectCheckbox(WebElement checkboxElement, boolean status) {
		scrollToElement(checkboxElement);
		if (!checkboxElement.isSelected() == status)
			checkboxElement.click();
	}

	// Common method to get attribute value from an element.
	public String getAttribute(WebElement element, String attribute) {
		scrollToElement(element);
		return element.getAttribute(attribute);
	}

	// Common method to get current browser URL
	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}

	// Common method to refresh the page
	public void refreshPage() {
		driver.navigate().refresh();
	}

	// Common method to Navigate back
	public void navigateBack() {
		driver.navigate().back();
	}

	// Common method to Navigate forward
	public void navigateForward() {
		driver.navigate().forward();
	}

	// Common method to check if element is displayed
	public boolean isElementDisplayed(WebElement element) {
		scrollToElement(element);
		return element.isDisplayed();
	}

	// Common method to check if element is enabled
	public boolean isElementEnabled(WebElement element) {
		scrollToElement(element);
		return element.isEnabled();

	}

	// Common method to wait using java wait.
	public void javaWait(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	// Common method to wait using implicit wait.
	public void setImplicitWait() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Constants.IMPLICIT_WAIT));
	}

	// Common method to wait for the element or locator
	public void waitForElement(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.EXPLICIT_WAIT));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	// Common method to wait for the locator
	public void waitForElement(By locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.EXPLICIT_WAIT));
		wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(locator, 0));
	}

	// Common method to wait until element disappears.
	public void waitForElementToBeDisappear(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.EXPLICIT_WAIT));
		wait.until(ExpectedConditions.invisibilityOf(element));
	}

	// Common method to switch to the frame from the main browser window.
	public void switchToFrame(WebElement frameElement) {
		driver.switchTo().frame(frameElement);
	}

	// Common method to switch to the frame from the main browser window.
	public void switchToFrame(String idOrName) {
		driver.switchTo().frame(idOrName);
	}

	// Common method to switch back to the main browser window from the frame.
	public void switchToDefaultContent() {
		driver.switchTo().defaultContent();
	}
	
	

	// Common method to accept or dismiss alert based on status
	public void handleAlert(boolean accept) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.EXPLICIT_WAIT));
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert = driver.switchTo().alert();
		if (accept) {
			alert.accept();
		} else {
			alert.dismiss();
		}
	}
	
	public String captureAlertTextAndClose(boolean accept) { 
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.EXPLICIT_WAIT));
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert = driver.switchTo().alert(); 
	    String alertText = alert.getText(); 
	    if (accept) { alert.accept(); }
	    else { alert.dismiss(); 
	    } 
	    return alertText; }

	// Common method to take the screenshot of entire browser window with parameters
	// as driver and screenshot name.
	public static String takeScreenshot(WebDriver driver, String screenshotName) throws IOException {
		String filePath = System.getProperty("user.dir") + "\\Screenshots\\" + screenshotName + ".png";
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile, new File(filePath));
		return filePath;
	}

	// Common method to take the screenshot of webelement with parameters as driver
	// and screenshot name.
	public static String takeScreenshot(WebElement element, String screenshotName) throws IOException {
		String filePath = System.getProperty("user.dir") + "\\Screenshots\\" + screenshotName + ".png";
		File screenshotFile = element.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile, new File(filePath));
		return filePath;
	}

	// Methods to generate random data
	public String randomeString() {
		String generatedString = RandomStringUtils.randomAlphabetic(5);
		return generatedString;
	}

	public String randomeNumber() {
		String generatedString = RandomStringUtils.randomNumeric(10);
		return generatedString;
	}

	public String randomAlphaNumeric() {
		String str = RandomStringUtils.randomAlphabetic(3);
		String num = RandomStringUtils.randomNumeric(3);

		return (str + "@" + num);
	}

	// Common method to print the message within the extent report.
	public void log(String status, String message) {
		if (status.equalsIgnoreCase("info")) {
			Reports.logger.info(message);
		} else if (status.equalsIgnoreCase("pass")) {
			Reports.logger.pass(message);
		} else if (status.equalsIgnoreCase("fail")) {
			Reports.logger.fail(message);
		} else if (status.equalsIgnoreCase("warning")) {
			Reports.logger.warning(message);
		}
	}

}
