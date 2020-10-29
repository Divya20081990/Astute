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
import org.openqa.selenium.support.How;

public class LoginPage {
	
	WebDriver driver;
	
	
	public LoginPage(WebDriver driver) {
		
		this.driver=driver;
	}

	
	@FindBy(how=How.XPATH,using="//form/table/tbody/tr[1]/td[2]/input")
	WebElement userId_textField;

	
	@FindBy(name="password")
	WebElement password_textField;

	
	@FindBy(name="btnLogin")
	WebElement login_button;

	
	public void setUserId() throws IOException {
		
		userId_textField.sendKeys(readExel(1,0,"login"));
	}

	
	public void setPassword() throws IOException {
		
		password_textField.sendKeys(readExel(1,1,"login"));
	}

	
	public void clickOnLoginBtn() {
		
		login_button.click();
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
