package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {
	
	WebDriver driver;
	
	
	public HomePage() {
		
		this.driver=driver;
	}

	@FindBy(linkText = "New Customer")
	WebElement new_customer_link;


	@FindBy(linkText = "Edit Customer")
	WebElement edit_customer_link;


	@FindBy(linkText = "Delete Customer")
	WebElement delete_customer_link;


	@FindBy(linkText = "New Account")
	WebElement new_account_link;


	@FindBy(linkText = "Edit Account")
	WebElement edit_account_link;

	@FindBy(linkText = "Deposit")
	WebElement deposite_link;	


	@FindBy(linkText = "Withdrawal")
	WebElement withdraw_link;


	@FindBy(linkText = "Delete Account")
	WebElement DeleteAccount_link;


	@FindBy(linkText = "Fund Transfer")
	WebElement fundTransfer_link;


	@FindBy(linkText = "Balance Enquiry")
	WebElement balanceEnquiry_link;


	@FindBy(linkText = "Mini Statement")
	WebElement MiniStatement_link;

	
	@FindBy(linkText = "Customised Statement")
	WebElement customizedStatement_link;

	
	public void miniStatementOnclick() {
		
		Assert.assertTrue(MiniStatement_link.isEnabled());
		MiniStatement_link.click();
	}


	public void balanceEnquiryOnclick() {
		
		Assert.assertTrue(balanceEnquiry_link.isEnabled());
		balanceEnquiry_link.click();
	}


	public void newCustomerOnclick() {
		
		Assert.assertTrue(new_customer_link.isEnabled());
		new_customer_link.click();
	}


	public void editCustomerOnclick() {
		Assert.assertTrue(edit_customer_link.isEnabled());
		edit_customer_link.click();
	}


	public void deleteCustomerOnclick() {
		Assert.assertTrue(delete_customer_link.isEnabled());
		delete_customer_link.click();
	}


	public void newAccountOnclick() {
		Assert.assertTrue(new_account_link.isEnabled());
		new_account_link.click();
	}


	public void editAccountOnclick() {
		Assert.assertTrue(edit_account_link.isEnabled());
		edit_account_link.click();
	}


	public void depositeOnclick() {
		Assert.assertTrue(deposite_link.isEnabled());
		deposite_link.click();
	}


	public void withdrawOnclick() {
		Assert.assertTrue(withdraw_link.isEnabled());
		withdraw_link.click();
	}



	public void deleteAccountOnclick() {
		Assert.assertTrue(DeleteAccount_link.isEnabled());
		DeleteAccount_link.click();

	}



	public void fundTransferOnclick() {
		Assert.assertTrue(fundTransfer_link.isEnabled());
		fundTransfer_link.click();

	}


	public void customisedStatementOnclick() {
		Assert.assertTrue(customizedStatement_link.isEnabled());
		customizedStatement_link.click();


	}



}
