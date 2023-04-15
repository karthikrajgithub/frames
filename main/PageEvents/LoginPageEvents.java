package PageEvents;

import org.testng.Assert;

import PageObjects.LoginPageElements;
import TestPackage1.BaseTest;
import utils.ElementFeatch;

public class LoginPageEvents {

	
	public void loginPageDisplayedorNot() {
		ElementFeatch elementfeatch=new ElementFeatch();
		BaseTest.logger.info("Verifying Login page displayed or not");
		Assert.assertTrue(elementfeatch.getListWebElements("XPATH", LoginPageElements.signinText).size()>0, "Login page not Opened");
		
	}
	
	public void enterEmailId() {
		ElementFeatch elementfeatch=new ElementFeatch();
		BaseTest.logger.info("Entering Email id to the email id field");
		elementfeatch.getWebElement("ID", LoginPageElements.emailid).sendKeys("lingaiah@gmail.com");
	}

	
	public void clickContinuebutton() {
		
		ElementFeatch elementfeatch=new ElementFeatch();
		BaseTest.logger.info("Click Continue button ");
		elementfeatch.getWebElement("ID", LoginPageElements.continuebutton).click();
		
		
	}
	
}
