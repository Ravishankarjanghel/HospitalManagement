package Assignment;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvider3 {
	@Test(dataProvider="setData")
	public void getdata(String src,String dest,int price,String name) {
		System.out.println(src+" "+dest+" "+price+" "+name);
	}
@DataProvider
public Object[][]setData(){
	Object[][] arr = new Object[4][4];
	
	arr[0][0]="Testyantra";
	arr[0][1]="Qspider";
	arr[0][2]=400;
	arr[0][3]="sarada";
	
	arr[1][0]="jspider";
	arr[1][1]="btm";
	arr[1][2]=600;
	arr[1][3]="sarada";
	
	arr[2][0]="bengaluru";
	arr[2][1]="marathahalli";
	arr[2][2]=500;
	arr[2][3]="sarada";
	
	arr[3][0]="pySpider";
	arr[3][1]="basabantgudi";
	arr[3][2]=800;
	arr[3][3]="sarada";
	return arr;
}
}
