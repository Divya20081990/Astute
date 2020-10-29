package test;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import pages.DepositePage;
import pages.HomePage;
import pages.LoginPage;
import pages.NewAccountPage;
import pages.NewCustomerPage;
import pages.WithdrawPage;

public class WithdrawTest extends BaseTest {
	
	
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

	
	@Test(priority=3)
	public void deposite() throws IOException {
		DepositePage dp=PageFactory.initElements(driver, DepositePage.class);
		dp.depositeOnclick();
		dp.setAccountNo();
		dp.setAmount();
		dp.setDescription();
		dp.DeposubmitOnClick();
		
	}

	@Test(priority=4)
	public void withdraw() throws IOException {
		WithdrawPage wp=PageFactory.initElements(driver, WithdrawPage.class);
	    wp.withdrawOnclick();
		wp.setAccountNo();
		wp.setWithdrawAmount();
		wp.setDescription();	
		wp.withdrawSubmitOnClick();
		
	}

}
