package pages;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NewCustomerPage {

	WebDriver driver;


	public NewCustomerPage(WebDriver driver) {

		this.driver=driver;
	}


	@FindBy(linkText = "New Customer")
	WebElement new_customer_link;


	@FindBy(name="name")
	WebElement cust_name_textfield;


	@FindBy(how=How.XPATH,using="//tbody/tr[5]/td[2]/input[1]")
	WebElement m_r_btn;


	@FindBy(how=How.XPATH,using="//tbody/tr[5]/td[2]/input[2]")
	WebElement f_r_btn;


	@FindBy(name="dob")
	WebElement dob;


	@FindBy(name="addr")
	WebElement add_textarea;


	@FindBy(name="city")
	WebElement city_name_textfield;


	@FindBy(name="state")
	WebElement state_name_textfield;


	@FindBy(name="pinno")
	WebElement pin_textfield;


	@FindBy(name="telephoneno")
	WebElement mobile_name_textfield;


	@FindBy(name="emailid")
	WebElement email_textfield;


	@FindBy(name="password")
	WebElement password2_textfield;


	@FindBy(name="sub")
	WebElement submit_button;


	@FindBy(how=How.XPATH,using="//table[@id='customer']/tbody/tr[4]/td[2]")
	WebElement customerID_textfield;


	public void newCustomerOnclick() {

		Assert.assertTrue(new_customer_link.isEnabled());
		new_customer_link.click();
	}


	public void setCustName() throws IOException {

		cust_name_textfield.sendKeys(readExel(0,1,"cust_detail"));
	}


	public void setDobDate() throws IOException {

		dob.sendKeys(readExel(1,1,"cust_detail"));
	}


	public void setDobMonth() throws IOException {

		dob.sendKeys(readExel(2,1,"cust_detail"));
	}


	public void setDobYear() throws IOException {

		dob.sendKeys(readExel(3,1,"cust_detail"));
	}


	public void setArea() throws IOException {

		add_textarea.sendKeys(readExel(4,1,"cust_detail"));
	}


	public void setCity() throws IOException {

		city_name_textfield.sendKeys(readExel(5,1,"cust_detail"));
	}


	public void setState() throws IOException {

		state_name_textfield.sendKeys(readExel(10,1,"cust_detail"));
	}


	public void setPin() throws IOException {

		pin_textfield.sendKeys(readExel(6,1,"cust_detail"));
	}


	public void setMobileNo() throws IOException {

		mobile_name_textfield.sendKeys(readExel(7,1,"cust_detail"));
	}


	public void setEmail() throws IOException {

		email_textfield.sendKeys(readExel(8,1,"cust_detail"));
	}


	public void setPassword() throws IOException {

		password2_textfield.sendKeys(readExel(9,1,"cust_detail"));
	}


	public void submitOnClick() {

		submit_button.click();
		driver.switchTo().defaultContent();

	}


	public void setGender(String gender) {
		
     String  x=m_r_btn.getAttribute("value");
     if(x.equalsIgnoreCase(gender))
     {
    	  	 m_r_btn.click();
			m_r_btn.sendKeys(Keys.TAB);
     }
     String  y=f_r_btn.getAttribute("value");
     if(y.equalsIgnoreCase(gender))
     {
    	 f_r_btn.click();
    	 f_r_btn.sendKeys(Keys.TAB);
     }
     
	
	}
   public void waitForPageLoad() {
	   driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
	   WebDriverWait wait = new WebDriverWait(driver, 50 /*timeout in seconds*/);
	   wait.until(ExpectedConditions.urlContains("CustomerRegMsg"));
   }

	public void acknowledgeRegistration() throws IOException {
		
			WebDriverWait wait = new WebDriverWait(driver, 50 /*timeout in seconds*/);
			driver.switchTo().defaultContent();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("customer")));
			
			

	}
	
	
	public void getCustId() throws IOException {
		//WebElement customerID_textfield=driver.findElement(By.xpath("//table[@id='customer']/tbody/tr[4]/td[2]"));
		String  cust_id=customerID_textfield.getText();
		writeExel(0,1, cust_id, "customerDetail");
		
	}
	
	

	public static String readExel(int row, int col, String  file1) throws IOException {
		
		FileInputStream fs=new FileInputStream(".//TestData//data.xlsx");
		XSSFWorkbook wb =new XSSFWorkbook(fs);
		XSSFSheet  ws = wb.getSheet(file1);
		XSSFCell cell=ws.getRow(row).getCell(col);
		cell.setCellType(CellType.STRING);
		String data=cell.toString();
		return data;
	}

	
	public static void writeExel(int row, int col,String value,String file1) throws IOException {
		
		FileInputStream fs=new FileInputStream(".//TestData/data.xlsx");
		XSSFWorkbook wb =new XSSFWorkbook(fs);
		XSSFSheet  ws = wb.getSheet(file1);
		Row r=ws.getRow(row);
		Cell cell=r.createCell(col);
		cell.setCellValue(value);
		FileOutputStream os= new FileOutputStream(".//TestData/data.xlsx");
		wb.write(os);
		os.close();

	}




}
