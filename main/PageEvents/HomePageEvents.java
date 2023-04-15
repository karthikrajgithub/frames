package PageEvents;

import PageObjects.HomePageElements;
import TestPackage1.BaseTest;
import utils.ElementFeatch;

public class HomePageEvents {
	
	public void clickHomepageSigninbutton()
	{
		ElementFeatch elementfeatch=new ElementFeatch();
		BaseTest.logger.info("Clicking on Sign in Button");
		elementfeatch.getWebElement("XPATH", HomePageElements.homepagesigninbutton).click();
		
	}

}
