package com.genericutility;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

public class WebDriverUtility {

	
		/**
		 * 
		 * @param driver
		 */
		public void maximizeWindow(WebDriver driver) {
			driver.manage().window().maximize();
		}
		
		/**
		 * 
		 * @param driver
		 */
		public void waitForPageLoad(WebDriver driver) {
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);	
		}
		/**
		 * 
		 * @param driver
		 * @param element
		 */
		
		public void waitForElementToBeClickAble(WebDriver driver,WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(element));		
		}
		/**
		 * 
		 * @param driver
		 * @param element
		 * @param pollingTime
		 * @throws InterruptedException
		 */
		public void waitForElementWithCumtomTimeOut(WebDriver driver,WebElement element,int pollingTime) throws InterruptedException {
			FluentWait wait=new FluentWait(driver);
			wait.pollingEvery(pollingTime,TimeUnit.SECONDS);
			wait.wait(20);
			wait.until(ExpectedConditions.elementToBeClickable(element));
		}
		/**
		 * 
		 * @param driver
		 * @param partialWindowTitle
		 */
	public void switchToWindow(WebDriver driver,String partialWindowTitle) {
	Set<String> set=driver.getWindowHandles();
	Iterator<String> it=set.iterator();
	while(it.hasNext()) {
		String WID=it.next();
		driver.switchTo().window(WID);
		String currentWindowTitle = driver.getTitle();
		if(currentWindowTitle.contains(partialWindowTitle)) {
			break;
		}
	}
	}
	/**
	 * 
	 * @param driver
	 */
	public void switchToAlertWindowAndAccept(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	/**
	 * 
	 * @param driver
	 */
	public void swichToAlertWindowAndCancel(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	/**
	 * 
	 * @param driver
	 * @param index
	 */
	public void switchToFrame(WebDriver driver,int index) {
	driver.switchTo().frame(index);	
	}
	/**
	 * 
	 * @param driver
	 * @param id_name_attribute
	 */
	public void switchToFrame(WebDriver driver,String id_name_attribute) {
		driver.switchTo().frame(id_name_attribute);
	}
	/**
	 * 
	 * @param element
	 * @param index
	 */
	public void select(WebElement element,int index) {
		Select sel=new Select(element);
		sel.selectByIndex(index);
	}
	/**
	 * 
	 * @param element
	 * @param text
	 */
	public void select(WebElement element,String text) {
		Select sel=new Select(element);
		sel.selectByVisibleText(text);
	}
	/**
	 * 
	 * @param driver
	 * @param element
	 */
	public void mouseOverOnElement(WebDriver driver,WebElement element) {
		Actions act=new Actions(driver);
		act.moveToElement(element).perform();
	}
	/**
	 * 
	 * @param driver
	 * @param element
	 */
	public void rightClickOnElement(WebDriver driver,WebElement element) {
		Actions act=new Actions(driver);
		act.contextClick(element).perform();
	}
	/**
	 * 
	 * @param driver
	 * @param javaScript
	 */
	public void executeJavaScript(WebDriver driver,String javaScript) {
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeAsyncScript(javaScript, null);
	}
	/**
	 * 
	 * @param element
	 * @throws InterruptedException
	 */
	public void waitAndclick(WebElement element) throws InterruptedException {
		int count=0;
		while(count<20) {
			try {
				element.click();
				break;
			}
			catch(Throwable e) {
				Thread.sleep(1000);
				count++;
			}
		}
	}
	/**
	 * 
	 * @param driver
	 * @param screenshotName
	 * @throws IOException
	 */
	public void takeScreenShot(WebDriver driver,String screenshotName) throws IOException {
		TakesScreenshot ts=(TakesScreenshot)driver;
		 File src = ts.getScreenshotAs(OutputType.FILE);
		 File dest = new File("./screenshot/"+screenshotName+".PNG");
		 Files.copy(src,dest);
	}
	/**
	 * 
	 * @param driver
	 */
	public void passEnterKey(WebDriver driver) {
		Actions act=new Actions(driver);
		act.sendKeys(Keys.ENTER).perform();
	}

	public void waitTillPageGetLoad(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}
	

	}


