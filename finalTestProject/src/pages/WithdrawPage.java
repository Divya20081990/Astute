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
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WithdrawPage {
	WebDriver driver;
	public WithdrawPage(WebDriver driver) {
		this.driver=driver;
	}
	
	
	
	
	@FindBy(name="accountno")
	 WebElement acc_no_textfield;
	
	
	@FindBy(name="ammount")
	WebElement amount_textfield;
	
	
	@FindBy(name="desc")
	WebElement description_textfield;
	
	
	@FindBy(name="AccSubmit")
	WebElement submit_btn;
	
	
	@FindBy(linkText = "Withdrawal")
	WebElement withdraw_link;
	
	
	public void setAccountNo() throws IOException {
		  acc_no_textfield.sendKeys(readExel(2, 1,"customerDetail"));
	}
	
	
	public void setWithdrawAmount() {
			 amount_textfield.sendKeys("1000");
	}
	
	
	public void setDescription() {
		 description_textfield.sendKeys("Amount_withdraw");
	}
	
	
	public void withdrawSubmitOnClick() {

		submit_btn.click(); 

	}
	
	
	public void withdrawOnclick() {
		Assert.assertTrue(withdraw_link.isEnabled());
		withdraw_link.click();
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
