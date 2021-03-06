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
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DeleteCustomerPage {
	WebDriver driver;
	public DeleteCustomerPage(WebDriver driver) {
		this.driver=driver;
	}
	
	
	@FindBy(linkText = "Delete Customer")
	WebElement delete_customer_link;
	
	
	@FindBy(name="cusid")
	WebElement cust_id_textfield;
	
	
	@FindBy(name="AccSubmit")
	WebElement delete_submit_btn;
	
	
	public void deleteCustomerOnClick() {
		delete_customer_link.click();
	}
	
	
	public void setCustId() throws IOException {
		cust_id_textfield.sendKeys(readExel(0, 1, "customerDetail"));
	}
	
	
	public void  onClickDeleteSubmit() {
		delete_submit_btn.click();
	}
	
	public void handleAlert() throws Throwable {
		Alert alert1=driver.switchTo().alert();
		Thread.sleep(2000);
		alert1.accept();
		Thread.sleep(2000);
		Alert alert2=driver.switchTo().alert();
		Thread.sleep(2000);
		alert2.accept();

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
