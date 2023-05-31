package Assignment;

import org.testng.annotations.DataProvider;

import com.genericutility.Practice.ExcelUtility;

public class DataProviderGenericWay {
@DataProvider
public Object[][] getDataFromExcel() throws Throwable {
	ExcelUtility eu=new ExcelUtility();
	
	
	Object[][] data = eu.getDataFromExcel("DataProvider");
	return data;
}
}
