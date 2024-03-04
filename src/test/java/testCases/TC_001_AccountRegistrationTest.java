package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistraitonPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001_AccountRegistrationTest extends BaseClass {
	
	@Test(groups = {"regression","master"})
	public void verify_account_registration() {
		
		logger.debug("Application logs Started.....");
		logger.info("******  Starting TC_001_AccountRegistrationTest  *******");
		try {
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			logger.info("Clicked on MyAccount link");
			hp.clickRegister();
			logger.info("Clicked on Registration link");
			
			logger.info("Entring Customer details.. ");
			AccountRegistraitonPage regpage = new AccountRegistraitonPage(driver);
			
			regpage.setFirstName(randomString().toUpperCase());
			regpage.setLastName(randomString().toUpperCase());
			regpage.setEmail(randomString()+"@gmail.com");		//randomly generated the email
			regpage.setTelephone(randomNumber());
			
			String password = randomAlphaNumeric();
			
			regpage.setPassword(password);
			regpage.setConfirmPassword(password);
			
			regpage.setPrivacyPolicy();
			regpage.clickContinue();
			logger.info("clicked on Continue..");
			
			String confmsg = regpage.getConfirmationMsg();
			
			logger.info("Validating expected message..");
			Assert.assertEquals(confmsg, "Your Account Has Been Created!","Account creation failed");
			
		} catch (Exception e) {
			
			logger.error("Test Failed..");
			Assert.fail("An exception occurred: " + e.getMessage());
		}
		
		logger.debug("Application logs end.....");
		logger.info("******  Finished TC_001_AccountRegistrationTest  *******");
	}
	
	
}
