package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//span[normalize-space()='My Account']")
	WebElement lnkMyaccout;
	
	@FindBy(xpath="(//a[normalize-space()='Register'])[1]")
	WebElement lnkRegister;
	
	@FindBy(xpath="//a[normalize-space()='Login']")		//Login link added in step 5
	WebElement linkLogin;
	
	@FindBy(xpath="//input[@placeholder='Search']")		//For Search Product Test
	WebElement txtSearchbox;
	
	@FindBy(xpath="//div[@id='search']//button[@type='button']")	//For Search Product Test
	WebElement btnSearch;
	
	
	public void clickMyAccount() {
		lnkMyaccout.click();
	}
	
	public void clickRegister() {
		lnkRegister.click();
	}
	
	public void clickLogin() {		//added in step 5
		linkLogin.click();
	}
	
	public void enterProductName(String pName) {
		txtSearchbox.sendKeys(pName);
	}
	
	public void clickSearch() {
		btnSearch.click();
	}
}
