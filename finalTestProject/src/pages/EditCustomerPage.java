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
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditCustomerPage {
	
	
WebDriver driver;
	
	
	public EditCustomerPage(WebDriver driver) {
		this.driver=driver;
	}
	
	
	@FindBy(linkText = "Edit Customer")
	WebElement edit_customer_link;
	
	
	@FindBy(name="cusid")
	WebElement cust_id_textfield;
	
	
	@FindBy(name="AccSubmit")
	WebElement submit_btn;
	
	
	@FindBy(name="city")
	WebElement city_name_textfield;
	
	
	@FindBy(name="sub")
	WebElement submit_btn2;
	
	
	public void editCustomerLinkOnClick() {
		edit_customer_link.click();
	}
	
	
	public void setCustId() throws IOException {
		 	cust_id_textfield.sendKeys(readExel(0, 1, "customerDetail"));
	}
	
	
	public void setCity() {
		city_name_textfield.clear();
		 city_name_textfield.sendKeys("London");
}
	
	
	public void OnClickSubmit_btn1() {
			submit_btn.click();
	}
	
	
	public void OnClickSubmit_btn2() {
	   	    submit_btn2.click();
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
