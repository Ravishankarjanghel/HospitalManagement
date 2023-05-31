package Assignment;

import org.testng.annotations.Test;

public class DataPro3 {
	@Test(dataProviderClass = DataProvider3.class,dataProvider ="setData")
		
	public void getData(String src,String dest,int price,String name) {
		System.out.println(src+" "+dest+" "+price+" "+name);
	}
}
