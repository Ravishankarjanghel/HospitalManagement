package typractice;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameters;
import com.genericutility.ExcelUtility;
import com.genericutility.FileUtility;
import com.pageobjectory.AddMedicalHistory;
import com.pageobjectory.DoctorsAddPatients;
import com.pageobjectory.DoctorsHomePage;
import com.pageobjectory.DoctorsLoginPage;
import com.pageobjectory.DoctorsManagePatients;
import com.pageobjectory.HomePage;

import io.github.bonigarcia.wdm.WebDriverManager;
@Listeners(com.genericutility.ListnerImp.class)
@Parameters
public class AddingPatientMadicalHistory {
	@Test(groups="regression")
	public void AddingPatientMdedicalHistory() throws Throwable {
		WebDriver driver = WebDriverManager.chromedriver().create();
		Random radNum = new Random();
		int ranNum = radNum.nextInt(1000);

		// Maximize the browser.
		driver.manage().window().maximize();

		// Provide implicit wait of 5 seconds.
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Trigger the main URL.
		FileUtility fileUtility = new FileUtility();
		String URL = fileUtility.getPropertyKeyValue("url");
		driver.get(URL);

		// Check whether home page is displayed or not.
		String homePageUrl = driver.getCurrentUrl();
//				if (homePageUrl.contains("Hospital_Management_System")) {
//					System.out.println("The homepage is displayed");
//				} else {
//					System.out.println("The homepage is not displayed");				}
		Assert.assertTrue(homePageUrl.contains("Hospital_Management_System"));
		Reporter.log("The home page is display", true);
//				
		// Click on Doctor login button
		// driver.findElement(By.xpath("//h3[text()='Doctors Login']/..//a")).click();
		HomePage hp = new HomePage(driver);
		hp.getDoctorsbtn().click();

		// Check whether Doctor Login page is displayed or not.
		String doctorLoginPageUrl = driver.getCurrentUrl();
//				if (doctorLoginPageUrl.contains("hms/doctor")) {
//					System.out.println("The Doctor Login page is displayed");
//				} else {
//					System.out.println("The Doctor Login page is not displayed");
//				}
		Assert.assertTrue(doctorLoginPageUrl.contains("hms/doctor"));
		Reporter.log("The doctorsLoginPage is display", true);

		// Filling credentials of doctor.
//				driver.findElement(By.name("username")).sendKeys("sagar@outlook.com");
//				driver.findElement(By.name("password")).sendKeys("Sagar@123");
//				driver.findElement(By.name("submit")).click();
		FileUtility fl = new FileUtility();
		String username = fl.getPropertyKeyValue("username");
		String pwd = fl.getPropertyKeyValue("pwd");

		DoctorsLoginPage dlp = new DoctorsLoginPage(driver);
		dlp.getUsernametxbox().sendKeys(username);
		dlp.getPwdbox().sendKeys(pwd);
		dlp.getLogintxbox().click();
		Assert.fail();

		// Check whether doctor dash board page is displayed or not.
		String doctorDashBoardPageUrl = driver.getCurrentUrl();
//				if (doctorDashBoardPageUrl.contains("hms/doctor/dashboard")) {
//					System.out.println("The Doctor dash board page is displayed");
//				} else {
//					System.out.println("The Doctor dash board page is not displayed");
//				}
		Assert.assertTrue(doctorDashBoardPageUrl.contains("hms/doctor/dashboard"));
		Reporter.log("The Doctor dash board page is not displayed", true);

		// Navigate to add patient page.
//				driver.findElement(By.xpath("//span[contains(.,'Patients')]/../..")).click();
//				driver.findElement(By.xpath("//span[contains(.,'Add Patient')]/../..")).click();
		DoctorsAddPatients dap = new DoctorsAddPatients(driver);
		dap.getPatientDropDown().click();
		dap.getAddPatientsListOpption().click();

		// Check whether add patient page is displayed or not.
		String addPatientPageUrl = driver.getCurrentUrl();
//				if (addPatientPageUrl.contains("hms/doctor/add-patient")) {
//					System.out.println("The add patient page is displayed");
//				} else {
//					System.out.println("The add patient page is not displayed");
//				}
		Assert.assertTrue(addPatientPageUrl.contains("hms/doctor/add-patient"));
		Reporter.log("The add patient page is displayed");

		// Fill in all details in add patient page.
//				driver.findElement(By.name("patname")).sendKeys("Mani");
//				driver.findElement(By.name("patcontact")).sendKeys("1234567890");
//				driver.findElement(By.name("patemail")).sendKeys("mani" + ranNum + "@outlook.com");
//				driver.findElement(By.xpath("//label[@for='rg-male']")).click();
//				driver.findElement(By.name("pataddress")).sendKeys("Bangalore");
//				driver.findElement(By.name("patage")).sendKeys("30");
//				driver.findElement(By.name("medhis")).sendKeys("Skin Inflation");
//				Thread.sleep(2000);
//				driver.findElement(By.name("submit")).click();
		ExcelUtility es = new ExcelUtility();
		String patientName = es.getDataFromExcel("Sheet1", 1, 0);
		String patientcontact = es.getDataFromExcel("sheet1", 1, 1);
		String patientemail = es.getDataFromExcel("sheet1", 1, 2);
		String patientAddress = es.getDataFromExcel("sheet1", 1, 3);
		String patientAge = es.getDataFromExcel("sheet1", 1, 4);
		String medicalHtry = es.getDataFromExcel("sheet1", 1, 5);

		DoctorsAddPatients daps = new DoctorsAddPatients(driver);

		daps.getPatientNameTextBox().sendKeys(patientName);
		daps.getPatientContactNumTxBox().sendKeys(patientcontact);
		daps.getPatientEmailIdTxBox().sendKeys(ranNum+patientemail);
		daps.getMaleRadioButton().click();
		daps.getPatientAddressTxBox().sendKeys(patientAddress);
		daps.getPatientAgeTxBox().sendKeys(patientAge);
		daps.getPatientMedicalHistorybtx().sendKeys(medicalHtry);
		Thread.sleep(5000);
		daps.getAddButton().click();

		// Check whether add patient page is displayed or not.
		addPatientPageUrl = driver.getCurrentUrl();
//				if (addPatientPageUrl.contains("hms/doctor/add-patient")) {
//					System.out.println("The add patient page is displayed");
//				} else {
//					System.out.println("The add patient page is not displayed");
//				}
		Assert.assertTrue(addPatientPageUrl.contains("hms/doctor/add-patient"));
		Reporter.log("The add patient page is displayed");

		// Navigate to manage patients page.
//				driver.findElement(By.xpath("//span[contains(.,'Patients')]/../..")).click();
//				driver.findElement(By.xpath("//span[contains(.,'Manage Patient')]/../..")).click();

		DoctorsManagePatients dmp = new DoctorsManagePatients(driver);
		dmp.getPatientDropDow().click();
		dmp.getManagePatientTxtField().click();

		// Check whether manage patient page is displayed or not.
		String managePatientPageUrl = driver.getCurrentUrl();
//				if (managePatientPageUrl.contains("hms/doctor/manage-patient")) {
//					System.out.println("The manage patient page is displayed");
//				} else {
//					System.out.println("The manage patient page is not displayed");
//				}

		Assert.assertTrue(managePatientPageUrl.contains("hms/doctor/manage-patient"));

		Reporter.log("The manage patient page is displayed ", true);

		// Check for the created patient and click on view patient icon
//				driver.findElement(
//						By.xpath("//table[@id='sample-table-1']//td[text()='1234567890']/..//a[contains(@href,'view')]"))
//						.click();
		DoctorsManagePatients dmps = new DoctorsManagePatients(driver);
		dmps.getViewPointIcon().click();

		// Check whether the view patient page is displayed or not.
		String viewPatientPageUrl = driver.getCurrentUrl();
		if (viewPatientPageUrl.contains("hms/doctor/view-patient.php")) {
			System.out.println("The view patient page is displayed");
		} else {
			System.out.println("The view patient page is not displayed");
		}

		// Click on add medical history button.
		driver.findElement(By.xpath("//button[@data-toggle='modal']")).click();
		Thread.sleep(1000);

		// Check whether add medical history popup is displayed or not.
		/*
		 * String medicalHistoryPopupTitle =
		 * driver.findElement(By.id("exampleModalLabel")).getText(); if
		 * (medicalHistoryPopupTitle.contains("Add Medical History")) {
		 * System.out.println("The add medical history popup is displayed"); } else {
		 * System.out.println("The add medical history popup is not displayed"); }
		 */

		// Fill in all details and click on submit button.
//				driver.findElement(By.name("bp")).sendKeys("110/70 mm Hg");
//				driver.findElement(By.name("bs")).sendKeys("100 mg/dL");
//				driver.findElement(By.name("weight")).sendKeys("65 Kg");
//				driver.findElement(By.name("temp")).sendKeys("99° F");
//				driver.findElement(By.name("pres")).sendKeys("Gris ODT Tablets");
//
//				driver.findElement(By.xpath("//div[@class='modal-content']//button[@class='btn btn-primary']")).click();

		ExcelUtility ex = new ExcelUtility();
		String bloodPressure = ex.getDataFromExcel("sheet2", 1, 0);
		String bloodSugar = es.getDataFromExcel("sheet2", 1, 1);

		String weight = ex.getDataFromExcel("sheet2", 1, 2);
		String temperature = ex.getDataFromExcel("sheet2", 1, 3);
		String prescription = ex.getDataFromExcel("sheet2", 1, 4);

		AddMedicalHistory amh = new AddMedicalHistory(driver);
		amh.getBloodPressureTextField().sendKeys(bloodPressure);
		amh.getBloodSugarTextField().sendKeys(bloodSugar);
		amh.getWeightTextField().sendKeys(weight);
		amh.getTemperatureTextField().sendKeys(temperature);
		amh.getPrescriptionTextField().sendKeys(prescription);
		amh.getSubmitButton().click();

		// Check whether the Medical history has been added alert popup is displayed or
		// not.
		String medicalHistoryAlertPopupText = driver.switchTo().alert().getText();
		if (medicalHistoryAlertPopupText.contains("Medicle history has been added.")) {
			System.out.println("The Medical history has been added alert popup is displayed");
		} else {
			System.out.println("The Medical history has been added alert popup is not displayed");
		}

		// Confirm the alert popup.
		driver.switchTo().alert().accept();

		// Logout as doctor.
//				driver.findElement(By.xpath("//li[@class='dropdown current-user']")).click();
//				driver.findElement(By.xpath("//a[contains(.,'Log Out')]")).click();

		DoctorsHomePage dhp = new DoctorsHomePage(driver);
		dhp.getDoctorsDropDown().click();
		dhp.getLogoutTextButton().click();

		// Check whether home page is displayed or not?
		homePageUrl = driver.getCurrentUrl();
		if (homePageUrl.contains("Hospital_Management_System")) {
			System.out.println("The homepage is displayed");
		} else {
			System.out.println("The homepage is not displayed");
		}

		// Click on patient login.

		HomePage homep = new HomePage(driver);
		homep.getPatientsbtn().click();
		// driver.findElement(By.xpath("//h3[text()='Patients']/..//a")).click();

		// Check whether patient login page is displayed or not.
		String patientLoginPageUrl = driver.getCurrentUrl();
		if (patientLoginPageUrl.contains("hms/user-login")) {
			System.out.println("The patient login page is displayed");
		} else {
			System.out.println("The patient login page is not displayed");
		}

		// Click on create an account link.

		driver.findElement(By.xpath("//a[contains(text(),'Create an account')]")).click();

		// Check whether patient registration page is displayed or not.
		String patientRegistrationLoginPageUrl = driver.getCurrentUrl();
		if (patientRegistrationLoginPageUrl.contains("hms/registration")) {
			System.out.println("The patient registration page is displayed");
		} else {
			System.out.println("The patient registration page is not displayed");
		}

		// Fill in all details and click on submit button.
		driver.findElement(By.name("full_name")).sendKeys("Mani");
		driver.findElement(By.name("address")).sendKeys("Bangalore");
		driver.findElement(By.name("city")).sendKeys("Basavanagudi");
		driver.findElement(By.cssSelector("label[for='rg-male']")).click();
		driver.findElement(By.id("email")).sendKeys(ranNum+patientemail);
		driver.findElement(By.id("password")).sendKeys("Mani@123");
		driver.findElement(By.id("password_again")).sendKeys("Mani@123");
		/*
		 * if (driver.findElement(By.xpath("//label[@for='agree']")).isSelected()) {
		 * 
		 * } else { driver.findElement(By.xpath("//label[@for='agree']")).click(); }
		 */
		Thread.sleep(2000);
		driver.findElement(By.name("submit")).click();

		// Check whether successfully registered alert popup is displayed or not
		String successfullyRegisteredAlertPopup = driver.switchTo().alert().getText();
		if (successfullyRegisteredAlertPopup.contains("Successfully Registered. You can login now")) {
			System.out.println("The successfully registered alert popup is displayed");
		} else {
			System.out.println("The successfully registered alert popup is not displayed");
		}

		// Accept the successfully registered alert popup
		driver.switchTo().alert().accept();

		// Check whether patient registration page is displayed or not.
		patientRegistrationLoginPageUrl = driver.getCurrentUrl();
		if (patientRegistrationLoginPageUrl.contains("hms/registration")) {
			System.out.println("The patient registration page is displayed");
		} else {
			System.out.println("The patient registration page is not displayed");
		}

		// Click on Login Button.
		driver.findElement(By.xpath("//a[contains(text(),'Log-in')]")).click();

		// Check whether patient login page is displayed or not.
		patientLoginPageUrl = driver.getCurrentUrl();
		if (patientLoginPageUrl.contains("hms/user-login")) {
			System.out.println("The patient login page is displayed");
		} else {
			System.out.println("The patient login page is not displayed");
		}

		// Fill in the patient credentials and click on submit button.
		driver.findElement(By.name("username")).sendKeys(ranNum+patientemail);
		driver.findElement(By.name("password")).sendKeys("Mani@123");
		driver.findElement(By.name("submit")).click();

		// Check whether the patient dash board page is displayed or not.
		String patientDashBoardPageUrl = driver.getCurrentUrl();
		if (patientDashBoardPageUrl.contains("hms/dashboard")) {
			System.out.println("The patient dash board page is displayed");
		} else {
			System.out.println("The patient dash board page is not displayed");
		}

		// Click on medical history.
		driver.findElement(By.xpath("//span[contains(.,'Medical History')]/../..")).click();

		// Click on view patient icon in actions column
		driver.findElement(
				By.xpath("//table[@id='sample-table-1']//td[text()='1234567890']/..//a[contains(@href,'view')]"))
				.click();

		// Check whether the view medical history page is displayed or not.
		String viewMedicalHistoryPage = driver.getCurrentUrl();
		if (viewMedicalHistoryPage.contains("hms/view-medhistory")) {
			System.out.println("The view medical history page is displayed");
		} else {
			System.out.println("The view medical history page is not displayed");
		}

		// Check whether the medical history is added or not.
		ArrayList<String> expectedMedicalHistory = new ArrayList<String>();
		ArrayList<String> actualMedicalHistory = new ArrayList<String>();
		expectedMedicalHistory.add("1");
		expectedMedicalHistory.add("110/70 mm Hg");
		expectedMedicalHistory.add("100 mg/dL");
		expectedMedicalHistory.add("65 Kg");
		expectedMedicalHistory.add("99° F");
		expectedMedicalHistory.add("Gris ODT Tablets");
		java.util.List<WebElement> medicalHistoryDetails = driver
				.findElements(By.xpath("//table[@id='datatable']//td"));
		for (WebElement oneMedicalHistory : medicalHistoryDetails) {
			actualMedicalHistory.add(oneMedicalHistory.getText());
		}
		if (expectedMedicalHistory.equals(actualMedicalHistory)) {
			System.out.println("The medical history is added");
		} else {
			System.out.println("The medical history is not added");
		}

		// Logout as patient.
		driver.findElement(By.xpath("//li[@class='dropdown current-user']")).click();
		driver.findElement(By.xpath("//a[contains(.,'Log Out')]")).click();

		// Check whether home page is displayed or not.
		homePageUrl = driver.getCurrentUrl();
		if (homePageUrl.contains("Hospital_Management_System")) {
			System.out.println("The homepage is displayed");
		} else {
			System.out.println("The homepage is not displayed");
		}

		// Post conditions.
		driver.quit();
	}

}
