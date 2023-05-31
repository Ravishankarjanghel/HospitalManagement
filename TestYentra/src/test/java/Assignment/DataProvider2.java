package Assignment;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvider2 {
	@Test(dataProvider="data")
	
	public void getdata(String src,String dest,int price) {
		System.out.println("from---->"+src+"To----->"+dest+"--->"+price);
	}
@DataProvider
public Object[][]data(){
	Object[][] arr = new Object[3][3];
	arr[0][0]="Testyantra";
	arr[0][1]="Qspider";
	arr[0][2]=400;
	
	arr[1][0]="jspider";
	arr[1][1]="btm";
	arr[1][2]=600;
	
	arr[2][0]="bengaluru";
	arr[2][1]="marathahalli";
	arr[2][2]=500;
	return arr;
}
}
