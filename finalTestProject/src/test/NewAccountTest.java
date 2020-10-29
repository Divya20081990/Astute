package test;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.NewAccountPage;
import pages.NewCustomerPage;

public class NewAccountTest extends BaseTest {
	
	@Test(priority=0)
	public void login() throws IOException {
		LoginPage lp=PageFactory.initElements(driver, LoginPage.class);
		lp.setUserId();
		lp.setPassword();
		lp.clickOnLoginBtn();

	}
	
	
	@Test(priority=1)
	public void newCustomer() throws Throwable  {
		
		NewCustomerPage ncp=PageFactory.initElements(driver, NewCustomerPage.class);
		ncp.newCustomerOnclick();
		ncp.setCustName();
		ncp.setGender("m");
		ncp.setDobDate();
		ncp.setDobMonth();
		ncp.setDobYear();
		ncp.setArea();
		ncp.setCity();
		ncp.setState();
		ncp.setPin();
		ncp.setMobileNo();
		ncp.setEmail();
		ncp.setPassword();
		ncp.submitOnClick();
		ncp.waitForPageLoad();
		ncp.acknowledgeRegistration();
		ncp.getCustId();
		
	}
	
	
		
	@Test(priority=2)
	public void newAccount() throws Throwable {
	
		NewAccountPage naccp=PageFactory.initElements(driver, NewAccountPage.class);
		naccp.newAccountLinkOnClick();
		naccp.setCustId();
		naccp.setInitialdeposite();
		naccp.selectAccount();
		naccp.submitOnClick();
		naccp.getAccountId();
		naccp.acknowledgeAccCreate();
	}

}
