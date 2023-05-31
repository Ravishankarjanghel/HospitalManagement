package Assignment;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExtractingTravelDetails {
	public static void main(String[] args) throws Throwable {
		WebDriver driver = WebDriverManager.chromedriver().create();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.makemytrip.com/");
		Actions actions = new Actions(driver);
		actions.moveByOffset(10, 10).click().perform();
//driver.findElement(By.xpath("//img[@alt='Make My Trip']")).click();
		driver.findElement(By.xpath("//input[@id='fromCity']")).click();
		driver.findElement(By.xpath("//input[@placeholder='From']")).sendKeys("mumbai");
		driver.findElement(By.xpath("//p[text()='Mumbai, India']")).click();
		driver.findElement(By.xpath("//input[@id='toCity']")).click();
		driver.findElement(By.xpath("//input[@placeholder='To']")).sendKeys("delhi");
		driver.findElement(By.xpath("//p[text()='New Delhi, India']")).click();
		driver.findElement(By.xpath("//div[@class='DayPicker-Day DayPicker-Day--today']")).click();
		driver.findElement(By.xpath("//a[text()='Search']")).click();
		List<WebElement> allFlights = driver.findElements(By.xpath("//p[@class='fliCode']/.."));
		ArrayList<String> flights = new ArrayList<String>();
		for (WebElement oneFlight : allFlights) {
			flights.add(oneFlight.getText());
		}
		for (String string : flights) {
			System.out.println(string);
		}
		List<WebElement> prices = driver.findElements(By.xpath("//div[@class='blackText fontSize18 blackFont white-space-no-wrap']"));
		ArrayList<String> flightsPrices = new ArrayList<String>();
		for (WebElement oneFlightPrice : prices) {
			flightsPrices.add(oneFlightPrice.getText());
		}
		for (String string : flights) {
			System.out.println(string);
		}
		for (int i = 0; i < flights.size(); i++) {
			System.out.println(flights.get(i)+"---->"+flightsPrices.get(i));
		}
	}
}
