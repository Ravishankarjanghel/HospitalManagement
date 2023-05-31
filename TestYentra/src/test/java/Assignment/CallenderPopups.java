package Assignment;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;
import okio.Timeout;

public class CallenderPopups {

	public static void main(String[] args) throws Throwable {
WebDriver driver=WebDriverManager.chromedriver().create();
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
driver.get("https://www.makemytrip.com/flights");
Actions a=new Actions(driver);
a.moveByOffset(10, 10).click().perform();
driver.findElement(By.xpath("//li[@data-cy='roundTrip']")).click();
driver.findElement(By.xpath("//input[@id='fromCity']")).click();
driver.findElement(By.xpath("//input[@placeholder='From']")).sendKeys("mumbai");
driver.findElement(By.xpath("//p[text()='Mumbai, India']")).click();
driver.findElement(By.xpath("//input[@id='toCity']")).click();
driver.findElement(By.xpath("//input[@placeholder='To']")).sendKeys("delhi");
driver.findElement(By.xpath("//p[text()='New Delhi, India']")).click();

Thread.sleep(5000);
driver.findElement(By.xpath("//div[@class='DayPicker-Day DayPicker-Day--today']")).click();
	}

}
