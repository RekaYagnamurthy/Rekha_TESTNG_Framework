package com.creatio.crm.application.elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.creatio.crm.framework.web.commons.WebCommons;

public class HomePageElements extends WebCommons {
	
	@FindBy (xpath = "//span[contains(text(),'Application Hub')]")
    public WebElement applicationHubLink;
    
    @FindBy (xpath = "//span[contains(text(),'Users')]")
    public WebElement usersLink;
    		
	@FindBy (xpath = "//span[contains(@class,'contact-photo')]")
    public WebElement userProfileIcon;
    
    @FindBy (xpath = "//span[contains(text(),'Log out')]")
    public WebElement logout;
    

}
