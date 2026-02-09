package com.creatio.crm.application.elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.creatio.crm.framework.web.commons.WebCommons;

public class CookiesPopupPageElements extends WebCommons {

	@FindBy(xpath = "//div[@id='CybotCookiebotDialogBodyContentTitle']")
	public WebElement cookiePopUpHeader;

	@FindBy(xpath = "//span[contains(text(),'We may use cookies')]")
	public WebElement cookieContentMsg;
	
	@FindBy(xpath = "//img[contains(@id,'PoweredbyImage')]")
	public WebElement creatioLogo;
	
	@FindBy(xpath = "//a[@id='CybotCookiebotDialogPoweredbyCybot']")
	public WebElement cookieBotLogo;
	
	@FindBy(xpath = "//strong[normalize-space()='Necessary']")
	public WebElement labelNecessary;

	@FindBy(xpath = "//strong[normalize-space()='Necessary']/following::div[contains(@class,'CybotCookiebotDialogBodyLevelButton')][1]")
	public WebElement necessaryToggleBar;

	@FindBy(xpath = "//strong[normalize-space()='Preferences']")
	public WebElement labelPreferences;
	
	@FindBy(xpath = "  //strong[normalize-space()='Statistics']")
	public WebElement labelStatistics;
	
	@FindBy(xpath = "  //strong[normalize-space()='Marketing']")
	public WebElement labelMarketing;
	
	@FindBy(xpath = "//button[contains(@id,'ButtonLevelOptinAllowAll')]")
	public WebElement allowAllBtn;

	@FindBy(xpath = "//button[contains(@id,'ButtonLevelOptinAllowallSelection')]")
	public WebElement allowSelectionBtn;

	@FindBy(xpath = "//a[contains(@id,'EdgeMoreDetailsLink')]")
	public WebElement showDetailsLink;
	
	@FindBy(xpath = "//a[@id='CybotCookiebotDialogNavDetails']")
	public WebElement cokkiesPopUpExpandedViewDetails;
	
	@FindBy(xpath = "//a[@id='CybotCookiebotDialogNavAbout']")
	public WebElement cokkiesPopUpExpandedViewAbout;
	
	
	
	
	

}
