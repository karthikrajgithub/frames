package PageEvents;

import PageObjects.CreateAccountPageElements;
import PageObjects.LoginPageElements;
import utils.ElementFeatch;

public class CreateAccountPageElement {
	
	public void clickCreatenewAccountPage() {
		ElementFeatch elementfeatch=new ElementFeatch();
		elementfeatch.getWebElement("ID", LoginPageElements.createaccount).click();
		
	}

	public void enternewaccountdetails() {
		ElementFeatch elementfeatch=new ElementFeatch();
		elementfeatch.getWebElement("XPATH", CreateAccountPageElements.firstandLastname).sendKeys("Lingaiah");
		elementfeatch.getWebElement("XPATH", CreateAccountPageElements.mobilenumber).sendKeys("9182531460");
		elementfeatch.getWebElement("ID", CreateAccountPageElements.creataccountcontinuebutton).click();
	}
}
