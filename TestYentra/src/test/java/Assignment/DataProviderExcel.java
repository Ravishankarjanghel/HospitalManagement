package Assignment;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.genericutility.IPathConstant;

public class DataProviderExcel {
	@Test(dataProvider="setData")
	public void getData(String src,String dest,String price) {
		System.out.println(src+" "+dest+" "+price);
	}
	
	@DataProvider
public Object[][] setData() throws Throwable{
	
	FileInputStream fis = new FileInputStream(IPathConstant.ExcelPath);
	Workbook wb = WorkbookFactory.create(fis);
	Sheet sh = wb.getSheet("DataProvider");
	int lastRow = sh.getLastRowNum()+1;
	short lastcell = sh.getRow(0).getLastCellNum();
	Object[][] obj = new Object[lastRow][lastcell];
	for(int i=0;i<lastRow;i++) {//Row
		for(int j=0;j<lastcell;j++) {//column
			obj[i][j]=sh.getRow(i).getCell(j).getStringCellValue();
		}
	}
	return obj;
}
}
