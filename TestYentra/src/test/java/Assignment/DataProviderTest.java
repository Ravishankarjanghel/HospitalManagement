package Assignment;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest {
	@Test(dataProvider="data")
	
	public void getData(String src,String dst,int price) {
		System.out.println("from---->"+src+" To---->"+dst+"price--->"+price);
	}
@DataProvider
public Object[][]data(){
	Object[][] arr = new Object[2][3];
	arr[0][0]="banglore";
	arr[0][1]="Mysore";
	arr[0][2]=100;
	
	arr[1][0]="qspider";
	arr[1][1]="testyantra";
	arr[1][2]=200;
	return arr;
}
}
