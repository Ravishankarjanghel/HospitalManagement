package typractice;

import org.openqa.selenium.WebDriver;

import com.genericutility.FileUtility;
import com.genericutility.WebDriverUtility;
import com.pageobjectory.HomePage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AdminLogin2 {
	public static void main(String[] args) throws IOException {
		FileUtility fileUtility = new FileUtility();
		String URL = fileUtility.getPropertyKeyValue("url");
		String BROWSER = fileUtility.getPropertyKeyValue("browser");
		String ADMINLOGINID = fileUtility.getPropertyKeyValue("adminLoginID");
		String ADMINPASSWORD = fileUtility.getPropertyKeyValue("adminPassword");
		String PTLOGINID = fileUtility.getPropertyKeyValue("ptLoginID");
		String PTPASSWORD = fileUtility.getPropertyKeyValue("ptPassword");
		String DOCLOGINID = fileUtility.getPropertyKeyValue("docLoginID");

		String DOCPASSWORD = fileUtility.getPropertyKeyValue("docPassword");

		// open the chrome browser.
		WebDriver driver = WebDriverManager.chromedriver().create();

		// Maximize the window.
		WebDriverUtility webDriverUtility = new WebDriverUtility();
		driver.manage().window().maximize();
		// Giving implicitly wait.
		webDriverUtility.waitTillPageGetLoad(driver);

		// enter the url.
		driver.get(URL);

		// Varifing weather home page is displayed or not.
		String homePageUrl = driver.getCurrentUrl();
		if (homePageUrl.contains("Hospital_Management_System")) {
			System.out.println("Hospital_Management_System web applications home page is displayed.");
		}

		HomePage homePage = new HomePage(driver);
		homePage.getAdminGotoPageButton().click();

		String adminLoginPageUrl = driver.getCurrentUrl();
		if (adminLoginPageUrl.contains("Hospital_Management_System/hms/admin")) {
			System.out.println("Admin Login page is displayed.");
		}

		AdminLogInPage adminLogInPage = new AdminLogInPage(driver);
		adminLogInPage.getAdminUserNameTextField().sendKeys(ADMINLOGINID);
		adminLogInPage.getAdminPasswordTextfield().sendKeys(ADMINPASSWORD);
		adminLogInPage.getAdminLoginButton().click();

		String adminDashBoardPageUrl = driver.getCurrentUrl();

		if (adminDashBoardPageUrl.contains("Hospital_Management_System/hms/admin/dashboard")) {
			System.out.println("Admin dashboard page is displayed.");
		}
	}

}
}
