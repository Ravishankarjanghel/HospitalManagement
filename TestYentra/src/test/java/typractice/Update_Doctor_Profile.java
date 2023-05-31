package typractice;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import com.mysql.cj.result.Row;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Update_Doctor_Profile {

	public static void main(String[] args) {

				FileInputStream fis = new FileInputStream("./src/test/resources/comman.properties");
				Properties p = new Properties();
				p.load(fis);
				String URL = p.getProperty("url");
				String BROWSER = p.getProperty("browser");
				String ADMINLOGINID = p.getProperty("adminLoginID");
				String ADMINPASSWORD = p.getProperty("adminPassword");
				String PTLOGINID = p.getProperty("ptLoginID");
				String PTPASSWORD = p.getProperty("ptPassword");
				String DOCLOGINID = p.getProperty("docLoginID");
				String DOCPASSWORD = p.getProperty("docPassword");
				
				FileInputStream fish=new FileInputStream("./\\src\\test\\resources\\hmsTestData.xlsx");
				Workbook wb = WorkbookFactory.create(fish);
				 row = wb.getSheet("Update_Doctor_Profile").getRow(1);
				 
				 
				 
				 
				 
				
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

				driver.findElement(By
						.xpath("//h3[text()='Doctors Login']/following-sibling::div[@class='button']//a[text()='Click Here']"))
						.click();
				driver.findElement(By.name("username")).sendKeys(DOCLOGINID);
				driver.findElement(By.name("password")).sendKeys(DOCPASSWORD);
				driver.findElement(By.name("submit")).click();

				driver.findElement(By.xpath("//span[@class='username']")).click();
				driver.findElement(By.xpath("//a[contains(text(),'My Profile')]")).click();

				Select s = new Select(driver.findElement(By.name("Doctorspecialization")));

				s.selectByVisibleText(dcSp);
				
				driver.findElement(By.name("docname")).clear();
				driver.findElement(By.name("docname")).sendKeys(doctor);
				
				driver.findElement(By.name("clinicaddress")).clear();
				driver.findElement(By.name("clinicaddress")).sendKeys(cliAdd);
				
				driver.findElement(By.name("docfees")).clear();
				driver.findElement(By.name("docfees")).sendKeys(docFee);
				
				driver.findElement(By.name("doccontact")).clear();
				driver.findElement(By.name("doccontact")).sendKeys(docContact);
				
				driver.findElement(By.name("submit")).click();
				
				driver.switchTo().alert().accept();
				
				String editDocPage = driver.getCurrentUrl();

				if (editDocPage.contains("Hospital_Management_System/hms/doctor/edit-profile")) {
					System.out.println("Edit doctor page is displayed.");
				}

			}

		}

	


