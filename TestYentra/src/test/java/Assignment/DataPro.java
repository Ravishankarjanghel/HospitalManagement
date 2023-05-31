package Assignment;

import org.testng.annotations.Test;

public class DataPro {
@Test(dataProviderClass = DataProvider2.class,dataProvider ="data")

public void getData(String src,String dest,int price) {
	System.out.println(src+""+dest+" "+price);
}
}
