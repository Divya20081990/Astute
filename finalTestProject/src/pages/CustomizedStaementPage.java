package pages;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

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

public class CustomizedStaementPage {

	WebDriver driver;


	public CustomizedStaementPage(WebDriver driver) {
		this.driver=driver;
	}
	
	
	@FindBy(linkText = "Customised Statement")
	WebElement customizedStatement_link;

	@FindBy(name="accountno")
	WebElement customizedAccountNumber;


	@FindBy(name="fdate")
	WebElement fromDate;


	@FindBy(name="tdate")
	WebElement toDate;


	@FindBy(name="amountlowerlimit")
	WebElement minTransValue;


	@FindBy(name="numtransaction")
	WebElement numberOfTrans;


	@FindBy(name="AccSubmit")
	WebElement customSubmit;
	
	
	public void customisedStatementOnclick() {
		Assert.assertTrue(customizedStatement_link.isEnabled());
		customizedStatement_link.click();
	}


	public void setAccNo() throws IOException {
		customizedAccountNumber.sendKeys(readExel(2, 1,"customerDetail"));
	}


	public void setFromDate() {
		fromDate.sendKeys("01-09-2020");
	}


	public void setToDate() {
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy ");
		Date date = new Date();
		String date1= dateFormat.format(date);
		toDate.sendKeys(date1);
	}


	public void setMinTransferValue() {
		minTransValue.sendKeys("100");
	}


	public void setnumberOfTrans() {
		numberOfTrans.sendKeys("1");
	}


	public void onClickSubmit() {
		customSubmit.click();
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
