package Assignment;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OlympicMedal2 {

	public static void main(String[] args) {
WebDriver driver = WebDriverManager.chromedriver().create();
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
driver.get("https://olympics.com/en/olympic-games/tokyo-2020/medals");
ArrayList<String>countryDetails=new ArrayList<String>();

List<WebElement> allcountryName = driver.findElements(By.xpath("//span[@data-cy='country-name']"));
Iterator<WebElement> arr1 = allcountryName.iterator();
while(arr1.hasNext()) {
	String countryname = arr1.next().getText();
	countryDetails.add(countryname);
}
ArrayList<String> goldDetails=new ArrayList<String>();
List<WebElement> allGold = driver.findElements(By.xpath("//div[@title='Gold']"));
Iterator<WebElement> arr2 = allGold.iterator();
while(arr2.hasNext()) {
	String allgolds = arr2.next().getText();
	goldDetails.add(allgolds);
}
ArrayList<String> bronzeDetails = new ArrayList<String>();
List<WebElement> allBronzeMedals = driver.findElements(By.xpath("//div[@title='Bronze']"));
Iterator<WebElement> ite3 = allBronzeMedals.iterator();
while(ite3.hasNext()) {
	String bronzeMedals = ite3.next().getText();
	bronzeDetails.add(bronzeMedals);
	}
for(int i=0;i<countryDetails.size();i++) {
	System.out.println(countryDetails.get(i)+" "+goldDetails.get(i)+" "+bronzeDetails.get(i));
}
}
}
