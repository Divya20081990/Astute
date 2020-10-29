package pages;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NewAccountPage {
	WebDriver driver;
	
	public NewAccountPage(WebDriver driver) {
		this.driver=driver;
	}
	
	
	@FindBy(linkText = "New Account")
	WebElement new_account_link;


	@FindBy(name="cusid")
	WebElement cust_id_textfield;


	@FindBy(name="inideposit")
	WebElement initial_depo__textfield;


	@FindBy(name="button2")
	WebElement submit_btn;
	
	
	@FindBy(how=How.XPATH,using="//table[@id=\"account\"]/tbody/tr[4]/td[2]")
	WebElement accountID_textfield;


	@FindBy(name="selaccount")
	WebElement acc_type_dropdown;
	
	
	public void newAccountLinkOnClick() {
		new_account_link.click();
	
	}

	public void setCustId() throws IOException {
		cust_id_textfield.clear();
		 cust_id_textfield.sendKeys(readExel(0, 1, "customerDetail"));
	}


	public void setInitialdeposite() {

		initial_depo__textfield.clear();
		 initial_depo__textfield.sendKeys("1000");

	}

	
	public void selectAccount() {

		Select s=new Select(acc_type_dropdown);
		s.selectByValue("Savings");
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

  public void getAccountId() throws IOException {
	  
	 // WebElement accountID_textfield=driver.findElement(By.xpath("//table[@id=\"account\"]/tbody/tr[4]/td[2]"));
      String  account_id=accountID_textfield.getText();
  
      writeExel(2,1, account_id, "customerDetail");
	  
  }
	public void acknowledgeAccCreate() throws Throwable {
		//Thread.sleep(5000);
		//WebDriverWait wait = new WebDriverWait(driver, 50 /*timeout in seconds*/);  
	//	try 
		//{ 
			WebDriverWait wait = new WebDriverWait(driver, 50 /*timeout in seconds*/);
			//wait.until(ExpectedConditions.invisibilityOf(submit_btn));
			driver.switchTo().defaultContent();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("account")));
			
			 WebElement accountID_textfield=driver.findElement(By.xpath("//table[@id=\"account\"]/tbody/tr[4]/td[2]"));
	         String  account_id=accountID_textfield.getText();
	     
	         writeExel(2,1, account_id, "customerDetail");
	        // System.out.println(account_id);

	
		//}
		
		/*catch(Exception e) 
		{
			 driver.navigate().refresh();
				 
	     }*/
	 
	
	}

	public void submitOnClick() {
		submit_btn.click();
		
	}




}
