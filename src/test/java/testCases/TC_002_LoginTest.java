package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_002_LoginTest extends BaseClass{

	@Test(groups = {"sanity","master"})
	public void Verify_login() {
		
		logger.info("****  Starting TC_002_LoginTest  ****");
		logger.debug("Capturing Application debug logs......");
		
		try {
			//Home Page
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			logger.info("Clicked on MyAccount link on the home page");
			hp.clickLogin();
			logger.info("Clicked on Login link under myaccount");
			
			//Login Page
			LoginPage lp = new LoginPage(driver);
			logger.info("Entering valid email and password");
			lp.setEmail(p.getProperty("email"));
			lp.setPassword(p.getProperty("password"));
			lp.clickLogin(); 	//Login Button
			logger.info("clicked on login button...");
			
			//My Account Page
			MyAccountPage ap = new MyAccountPage(driver);
			
			boolean targetPage = ap.isMyAccountPageExists();
			
			if(targetPage == true) {
				logger.info("Login test Passed...");
				Assert.assertTrue(true);
			} else {
				logger.error("Login test Failed...");
				Assert.fail();
			}
		} catch (Exception e) {
			Assert.fail();
		}
		
		logger.info("**** Finished TC_002_LoginTest  ****");
	}
}
