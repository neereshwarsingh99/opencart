package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_003_LoginDDT extends BaseClass{

	@Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class)
	public void verify_loginDDT(String email, String password, String exp) {
		
		logger.info("****  Starting TC_003_LoginDDT  ****");
		
		try {
			//Home Page
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			logger.info("Clicked on MyAccount link on the home page");
			hp.clickLogin();
			logger.info("Clicked on Login link under myaccount");
			
			//Login Page
			LoginPage lp = new LoginPage(driver);
			lp.setEmail(email);
			lp.setPassword(password);
			lp.clickLogin(); 	//Login Button
			
			//My Account Page
			MyAccountPage ap = new MyAccountPage(driver);
			
			boolean targetPage = ap.isMyAccountPageExists();
			
			if(exp.equalsIgnoreCase("Valid")) {
				if(targetPage == true) {
					ap.clickLogout();
					Assert.assertTrue(true);		//Test Case
				} else {
					Assert.assertTrue(false);
				}
			}
			if(exp.equalsIgnoreCase("Invalid")) {
				if(targetPage == true) {
					ap.clickLogout();
					Assert.assertTrue(false);		//Test Case
				} else {
					Assert.assertTrue(true);
				}
			}
			
		} catch (Exception e) {
			Assert.fail();
		}
		
		logger.info("**** Finished TC_002_LoginDDT  ****");
	}
}
