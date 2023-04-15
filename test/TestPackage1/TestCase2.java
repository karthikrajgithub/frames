package TestPackage1;

import org.testng.annotations.Test;

import PageEvents.CreateAccountPageElement;
import PageEvents.HomePageEvents;
import PageEvents.LoginPageEvents;

public class TestCase2 extends BaseTest{
	
	@Test
	public void clickCreateAccount() {
		
		HomePageEvents homePageEvents=new HomePageEvents();
		LoginPageEvents loginPageEvents=new LoginPageEvents();
		CreateAccountPageElement createaccountpage=new CreateAccountPageElement(); 
		homePageEvents.clickHomepageSigninbutton();
		loginPageEvents.enterEmailId();
		BaseTest.logger.info("Clicking on Create account Button");
		createaccountpage.clickCreatenewAccountPage();
		
			
	}
	
	@Test
	public void createnewaccount() {
		HomePageEvents homePageEvents=new HomePageEvents();
		LoginPageEvents loginPageEvents=new LoginPageEvents();
		CreateAccountPageElement createaccountpage=new CreateAccountPageElement(); 
		homePageEvents.clickHomepageSigninbutton();
		loginPageEvents.enterEmailId();
		BaseTest.logger.info("Clicking on Create account Button");
		createaccountpage.clickCreatenewAccountPage();
		BaseTest.logger.info("Entering new account details");
		createaccountpage.enternewaccountdetails();
		
		
	}

}
