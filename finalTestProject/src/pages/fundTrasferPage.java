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

public class fundTrasferPage {
	WebDriver driver;
	public fundTrasferPage(WebDriver driver) {
		this.driver=driver;
	}
	
	
	@FindBy(linkText = "Fund Transfer")
	WebElement fundTransfer_link;
	
	@FindBy(name="payersaccount")
	WebElement payersAccount_textfield;
	
	
	@FindBy(name="payeeaccount")
	WebElement payeesAccount_textfield;
	
	
	@FindBy(name="ammount")
	WebElement transferAmount_textfield;
	
		
	@FindBy(name="desc")
	WebElement desc_textfield;
	
	
	@FindBy(name="AccSubmit")
	WebElement acc_submit;
	
	
	public void fundTransferOnclick() {
		
		fundTransfer_link.click();

	}
	
	
	public void setPayersAccount() throws IOException {
		payersAccount_textfield.sendKeys(readExel(2, 1, "customerDetail"));
	}
	
	
	
	public void setTransferAmount() {
		transferAmount_textfield.sendKeys("1000");
	}
	
	
	public void setDesc() {
		desc_textfield.sendKeys("family");
	}
	
	
	public void onclickSubmit() {
		acc_submit.click();
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


	public void setPayeesAccount() {
		payeesAccount_textfield.sendKeys("83538");
		
	}
	

}
