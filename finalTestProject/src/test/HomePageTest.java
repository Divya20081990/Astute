package test;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import pages.HomePage;

public class HomePageTest extends BaseTest  {
	
	@Test
	public void home() {
		HomePage hp=PageFactory.initElements(driver, HomePage.class);
		hp.newCustomerOnclick();	
		hp.newAccountOnclick();
		hp.depositeOnclick();
		hp.withdrawOnclick();
		
	}

}
