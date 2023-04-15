package TestPackage1;

import org.testng.annotations.Test;

import PageEvents.*;

public class TestCase1 extends BaseTest{
	
	@Test
	public void SampleMethodforEmailEntering()
	{
	
	HomePageEvents homePageEvents=new HomePageEvents();
	homePageEvents.clickHomepageSigninbutton();
	
	LoginPageEvents loginPageEvents=new LoginPageEvents();
	
	loginPageEvents.loginPageDisplayedorNot();
	loginPageEvents.enterEmailId();
	 
	}
	@Test
	public void clickContniueButtoon() {
		HomePageEvents homePageEvents=new HomePageEvents();
		LoginPageEvents loginPageEvents=new LoginPageEvents();
		homePageEvents.clickHomepageSigninbutton();
		//loginPageEvents.enterEmailId();
		loginPageEvents.clickContinuebutton();
	}
}
