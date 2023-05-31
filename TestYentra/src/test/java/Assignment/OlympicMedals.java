package Assignment;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OlympicMedals {
public static void main(String[] args) throws Throwable {
	WebDriver driver = WebDriverManager.chromedriver().create();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.get("https://olympics.com/en/olympic-games/tokyo-2020/medals");
	ArrayList<String> countryDetails = new ArrayList<String>();
	driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']")).click();
	List<WebElement> allCountryName = driver.findElements(By.xpath("//span[@data-cy='country-name']"));
	Iterator<WebElement> ite = allCountryName.iterator();
	while(ite.hasNext()) {
		String countryName = ite.next().getText();
		countryDetails.add(countryName);
	}
	ArrayList<String> goldDetails = new ArrayList<String>();
	List<WebElement> allGoldMedals = driver.findElements(By.xpath("//div[@title='Gold']"));
	Iterator<WebElement> ite1 = allGoldMedals.iterator();
	while(ite1.hasNext()) {
		String goldMedals = ite1.next().getText();
		goldDetails.add(goldMedals);
	}
	
	ArrayList<String> silverDetails = new ArrayList<String>();
	List<WebElement> allSilverMedals = driver.findElements(By.xpath("//div[@title='Silver']"));
	Iterator<WebElement> ite2 = allSilverMedals.iterator();
	while(ite2.hasNext()) {
		String silverMedals = ite2.next().getText();
		silverDetails.add(silverMedals);
	}
	
	ArrayList<String> bronzeDetails = new ArrayList<String>();
	List<WebElement> allBronzeMedals = driver.findElements(By.xpath("//div[@title='Bronze']"));
	Iterator<WebElement> ite3 = allBronzeMedals.iterator();
	while(ite3.hasNext()) {
		String bronzeMedals = ite3.next().getText();
		bronzeDetails.add(bronzeMedals);
	}
	
	ArrayList<String> totalDetails = new ArrayList<String>();
	List<WebElement> allMedals = driver.findElements(By.xpath("//div[contains(@data-medal-id,'total-medals')]"));
	Iterator<WebElement> ite4 = allMedals.iterator();
	while(ite4.hasNext()) {
		String totalMedals = ite4.next().getText();
		totalDetails.add(totalMedals);
	}
	
	for (int i = 0; i < countryDetails.size() ; i++) {
		System.out.println(countryDetails.get(i)+"  "+goldDetails.get(i)+"  "+silverDetails.get(i)+"  "+bronzeDetails.get(i)+"  "+totalDetails.get(i));
	}
}
}
