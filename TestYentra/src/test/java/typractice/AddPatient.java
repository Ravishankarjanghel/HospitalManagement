package typractice;

import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.genericutility.ExcelUtility;
import com.genericutility.FileUtility;
import com.genericutility.JavaUtility;
import com.genericutility.WebDriverUtility;
import com.pageobjectory.DoctorsAddPatients;
import com.pageobjectory.DoctorsHomePage;
import com.pageobjectory.DoctorsLoginPage;
import com.pageobjectory.DoctorsManagePatients;
import com.pageobjectory.HomePage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AddPatient {

	@Test(groups="regression")
	public  void addPatient() throws Throwable {
		WebDriver driver = WebDriverManager.chromedriver().create();
				FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\common.properties");
				Properties p = new Properties();
				p.load(fis);
				String URL = p.getProperty("url");
				String BROWSER = p.getProperty("browser");
				String ADMINLOGINID = p.getProperty("adminLoginID");
				String ADMINPASSWORD = p.getProperty("adminPassword");
				String PTLOGINID = p.getProperty("ptLoginID");
				String PTPASSWORD = p.getProperty("ptPassword");
				String DOCLOGINID = p.getProperty("username");
				String DOCPASSWORD = p.getProperty("pwd");
		
		
				
//				FileInputStream fis1 = new FileInputStream("C:\\Users\\RAVISHANKAR\\OneDrive\\Desktop\\hms\\hmsTestData.xlsx");
//				Workbook wb = WorkbookFactory.create(fis1);
//				 Row row = wb.getSheet("AddPatient").getRow(1);
//				String pName = row.getCell(0).toString();
//				long pContact = (long)row.getCell(1).getNumericCellValue();
//				String pEmail = row.getCell(2).toString();
//				String pGender = row.getCell(3).toString();
//				String pAddress = row.getCell(4).toString();
//				String pAge = row.getCell(5).toString();
//				String pMH = row.getCell(6).toString();
		
		
		
		JavaUtility ju=new JavaUtility();
		
//				Random ran = new Random();
//				int r = (int)ran.nextInt(1000);
		int rm = ju.getRandomNo();
				
				// open the chrome browser.
				//WebDriver driver = WebDriverManager.chromedriver().create();

				// Maximize the window.
				//driver.manage().window().maximize();
		WebDriverUtility wu=new WebDriverUtility();
		wu.maximizeWindow(driver);
		
				// Giving implicitly wait.
				//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		wu.waitForPageLoad(driver);

				// enter the url.
				driver.get(URL);

				// Varifing weather home page is displayed or not.
				String homePageUrl = driver.getCurrentUrl();
				if (homePageUrl.contains("Hospital_Management_System")) {
					System.out.println("Hospital_Management_System web applications home page is displayed.");
				}

//				driver.findElement(By
//						.xpath("//h3[text()='Doctors Login']/following-sibling::div[@class='button']//a[text()='Click Here']"))
//						.click();
//				driver.findElement(By.name("username")).sendKeys(DOCLOGINID);
//				driver.findElement(By.name("password")).sendKeys(DOCPASSWORD);
//				driver.findElement(By.name("submit")).click();
				
				HomePage hp=new HomePage(driver);
				hp.getDoctorsbtn().click();
				
				FileUtility fl=new FileUtility();
				String username = fl.getPropertyKeyValue("username");
				String pwd = fl.getPropertyKeyValue("pwd");
				
				DoctorsLoginPage dlp=new DoctorsLoginPage(driver);
				dlp.getUsernametxbox().sendKeys(username);
				dlp.getPwdbox().sendKeys(pwd);
				dlp.getLogintxbox().click();
				
				

				//driver.findElement(By.xpath("//div[@class='item-inner']/span[text()=' Patients ']")).click();

				//driver.findElement(By.xpath("//a/span[text()=' Add Patient']")).click();
				
				DoctorsAddPatients dap=new DoctorsAddPatients(driver);
				dap.getPatientDropDown().click();
				dap.getAddPatientsListOpption().click();
				
				//driver.findElement(By.name("patname")).sendKeys(pName+r);

//				DataFormatter d = new DataFormatter();
//				String s = d.formatCellValue(row.getCell(1));
//				String s = Long.toString(pContact);
//				driver.findElement(By.name("patcontact")).sendKeys(s);
//
//				String[] temp = pEmail.split("@");
//				pEmail = temp[0]+r+"@"+temp[1];
//				
//				driver.findElement(By.name("patemail")).sendKeys(pEmail);
//
//				pGender = pGender.toLowerCase();
//				
//				driver.findElement(By.xpath("//label[@for='rg-"+pGender+"']")).click();
//
//				driver.findElement(By.name("pataddress")).sendKeys(pAddress+r);
//
//				driver.findElement(By.name("patage")).sendKeys(pAge);
//
//				driver.findElement(By.name("medhis")).sendKeys(pMH);
//				Thread.sleep(3000);
//				driver.findElement(By.name("submit")).click();
				ExcelUtility es=new ExcelUtility();
				String patientName = es.getDataFromExcel("Sheet1", 1, 0);
				String patientcontact = es.getDataFromExcel("sheet1", 1, 1);
				patientcontact = patientcontact.replaceAll("[.Ee]", "");
				String patientemail = es.getDataFromExcel("sheet1", 1, 2);
				patientemail = patientemail+rm;
				String patientAddress = es.getDataFromExcel("sheet1", 1, 3);
				String patientAge = es.getDataFromExcel("sheet1", 1, 4);
				String medicalHtry = es.getDataFromExcel("sheet1", 1, 5);
				
				DoctorsAddPatients daps=new DoctorsAddPatients(driver);
				
				daps.getPatientNameTextBox().sendKeys(patientName);
				daps.getPatientContactNumTxBox().sendKeys(patientcontact);
				daps.getPatientEmailIdTxBox().sendKeys(patientemail);
				daps.getMaleRadioButton().click();
				daps.getPatientAddressTxBox().sendKeys(patientAddress);
				daps.getPatientAgeTxBox().sendKeys(patientAge);
				daps.getPatientMedicalHistorybtx().sendKeys(medicalHtry);
				daps.getAddButton().click();
				
//				driver.findElement(By.xpath("//div[@class='item-inner']/span[text()=' Patients ']")).click();
//				
//				driver.findElement(By.xpath("//a/span[text()=' Manage Patient ']")).click();
				
				DoctorsManagePatients dmp=new DoctorsManagePatients(driver);
				dmp.getManagePatientTxtField();
				
				Thread.sleep(3000);
				 List<WebElement> ptName = driver.findElements(By.xpath("//td[@class='hidden-xs']"));
				
				for(WebElement i : ptName) {
					if(i.getText().contains(patientName+rm)) {
						System.out.println("Patient present in the list.");
						break;
					}
				}
				// logout the application
//				driver.findElement(By.xpath("//a[@class='dropdown-toggle']")).click();
//				driver.findElement(By.xpath("//a[contains(text(),'Log Out')]")).click();
				DoctorsHomePage dhp=new DoctorsHomePage(driver);
				dhp.getDoctorsDropDown().click();
				dhp.getLogoutTextButton().click();

				// Checking weather homepage is displayed or not.
				String homePageUrl2 = driver.getCurrentUrl();
				if (homePageUrl2.contains("Hospital_Management_System")) {
					System.out.println("Hospital_Management_System web applications home page is displayed.");
				}
			}

		}

	


