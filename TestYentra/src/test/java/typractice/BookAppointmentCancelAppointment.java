package typractice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.genericutility.ExcelUtility;
import com.genericutility.FileUtility;
import com.pageobjectory.BookAppointment;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BookAppointmentCancelAppointment {

	public static void main(String[] args) throws Throwable {
	
	
		
				FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\common.properties");
				Properties p = new Properties();
				p.load(fis);
				String URL = p.getProperty("url");
				String BROWSER = p.getProperty("browser");
				String ADMINLOGINID = p.getProperty("adminLoginID");
				String ADMINPASSWORD = p.getProperty("adminPassword");
				String PTLOGINID = p.getProperty("ptLoginID");
				String PTPASSWORD = p.getProperty("ptPassword");
				
//				FileInputStream fis1 = new FileInputStream("C:\\Users\\RAVISHANKAR\\OneDrive\\Desktop\\hmsTestData.xlsx");
//				Workbook wb = WorkbookFactory.create(fis1);
//				 Row row = wb.getSheet("BookAppointmentCancelAppointmen").getRow(1);
//				int day = (int)row.getCell(0).getNumericCellValue();
//				String time = row.getCell(1).toString();
//				String h = time.split(":")[0];
//				String m = time.split(":")[1].replaceAll("[^0-9]", "");
//				String ampm = time.replace("[^A-Za-z]", "");
				ExcelUtility eu=new ExcelUtility();
				String doctorSpecialization = eu.getDataFromExcel("sheet3", 1, 0);
				String doctorsname = eu.getDataFromExcel("sheet3", 1, 1);
				
			
				
				
				// open the chrome browser.
				WebDriver driver = WebDriverManager.chromedriver().create();

				// Maximize the window.
				driver.manage().window().maximize();

				// Giving implicitly wait.
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

				// enter the url.
				driver.get(URL);

				// Varifing weather home page is displayed or not.
				String homePageUrl = driver.getCurrentUrl();
				if (homePageUrl.contains("Hospital_Management_System")) {
					System.out.println("Hospital_Management_System web applications home page is displayed.");
				}

				// clicking to the patients module
				driver.findElement(By.xpath("//h3[text()='Patients']/..//a")).click();

				String url1 = driver.getCurrentUrl();
				if (url1.contains("s/user-login.php")) {
					System.out.println("Booking appionment is displayed");
				} else
					System.out.println("Booking appionment is displayed");
				// giving valid credentials
				driver.findElement(By.name("username")).sendKeys(PTLOGINID);
				driver.findElement(By.name("password")).sendKeys(PTPASSWORD);
				driver.findElement(By.xpath("//button[@class='btn btn-primary pull-right']")).click();
				// click on book appionment
				driver.findElement(By.xpath("//span[text()=' Book Appointment ']")).click();
				
				// fill up all the data
				BookAppointment bp=new BookAppointment(driver);
				
				//WebElement source = driver.findElement(By.xpath("//select[@name='Doctorspecialization']"));
				Select s = new Select(bp.getDoctorSpecialization());
				s.selectByValue(doctorSpecialization);
				Select s1 = new Select(bp.getSelectDoctorTextField());
				s1.selectByValue(doctorsname);
				
				bp.getDateTextField().sendKeys(keysToSend);
//				driver.findElement(By.name("appdate")).click(); 
//				driver.findElement(By.xpath("//td[@class='day' and text()='"+day+"']")).click();
//				driver.findElement(By.id("timepicker1")).click();
//				driver.findElement(By.xpath("//input[@class='bootstrap-timepicker-hour form-control']")).sendKeys(h);
//				driver.findElement(By.xpath("//input[@class='bootstrap-timepicker-minute form-control']")).sendKeys(m);
//				driver.findElement(By.xpath("//input[@class='bootstrap-timepicker-meridian form-control']")).sendKeys(ampm);
//				driver.findElement(By.name("submit")).submit();
				// click on appiontment history
				driver.findElement(By.xpath("//span[text()=' Appointment History ']")).click();
				driver.findElement(By.xpath("(//a[text()='Cancel'])[1]")).click();
				Alert a = driver.switchTo().alert();
				a.accept();
				// logout the application
				driver.findElement(By.xpath("//a[@class='dropdown-toggle']")).click();
				driver.findElement(By.xpath("//a[contains(text(),'Log Out')]")).click();

				// Checking weather homepage is displayed or not.
				String homePageUrl2 = driver.getCurrentUrl();
				if (homePageUrl2.contains("Hospital_Management_System")) {
					System.out.println("Hospital_Management_System web applications home page is displayed.");
				}

			}

		}

	


