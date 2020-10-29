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

public class DepositePage {

	WebDriver driver;
	public DepositePage(WebDriver driver) {
		this.driver=driver;
	}
	
	
	@FindBy(linkText = "Deposit")
	WebElement deposite_link;
	
	
	@FindBy(name="accountno")
	 WebElement acc_no_textfield;
	
	
	@FindBy(name="ammount")
	WebElement amount_textfield;
	
	
	@FindBy(name="desc")
	WebElement description_textfield;
	
	
	@FindBy(name="AccSubmit")
	WebElement depo_submit_btn;
	
	
	public void depositeOnclick() {
		
		deposite_link.click();
	}
	
	
	public void setAccountNo() throws IOException {
		 acc_no_textfield.clear();
		 acc_no_textfield.sendKeys(readExel(2, 1,"customerDetail"));
	}
	
	
	public void setAmount() {
		 amount_textfield.clear();
		 amount_textfield.sendKeys("10000");
	}
	
	
	public void setDescription() {
		description_textfield.clear();
		 description_textfield.sendKeys("Amount_deposite");
	}
	
	
	public void DeposubmitOnClick() {

		depo_submit_btn.click();

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
