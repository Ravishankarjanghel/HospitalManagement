package Assignment;

import org.testng.annotations.Test;

public class DataProviderExcelOtherClass {
@Test(dataProviderClass=DataProviderExcel.class,dataProvider="setData")

public void getData(String src,String dest,String price) {
	System.out.println(src+" "+dest+" "+price);
}
}
