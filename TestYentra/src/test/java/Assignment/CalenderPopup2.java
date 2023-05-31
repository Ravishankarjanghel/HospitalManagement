package Assignment;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CalenderPopup2 {

	public static void main(String[] args) throws Throwable {
WebDriver driver = WebDriverManager.chromedriver().create();
driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
driver.manage().window().maximize();
driver.get("https://www.makemytrip.com/");
Actions actions = new Actions(driver);
actions.moveByOffset(10, 10).click().perform();
driver.findElement(By.xpath("//li[@data-cy='roundTrip']")).click();
//driver.findElement(By.xpath("//img[@alt='Make My Trip']")).click();
driver.findElement(By.xpath("//input[@id='fromCity']")).click();
driver.findElement(By.xpath("//input[@placeholder='From']")).sendKeys("mumbai");
driver.findElement(By.xpath("//p[text()='Mumbai, India']")).click();
driver.findElement(By.xpath("//input[@id='toCity']")).click();
driver.findElement(By.xpath("//input[@placeholder='To']")).sendKeys("delhi");
driver.findElement(By.xpath("//p[text()='New Delhi, India']")).click();

//driver.findElement(By.xpath("//div[@class='DayPicker-Day DayPicker-Day--today']")).click();
//driver.findElement(By.xpath("//a[text()='Search']")).click();
//	}

Date d = new Date();
String[] arr = d.toString().split(" ");
String departuredate=arr[0]+" "+arr[1]+" "+arr[2]+" "+arr[5];Thread.sleep(1000);
Thread.sleep(1000);
driver.findElement(By.xpath("//div[@aria-label='"+departuredate+"']")).click();
Thread.sleep(1000);
//for(int i=0;i<arr.length;i++) {
//	System.out.println(arr[i]);	
//}
String day="Tue";
String month="Nov";
String date="14";
String year="2023";

String returnDate = day+" "+month+" "+date+" "+year;
for (;;) {
	try {
		driver.findElement(By.xpath("//div[@aria-label='"+returnDate+"']")).click();
		break;
	} catch (Exception e) {
		driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
	}
}
Thread.sleep(5000);
}
}
