package com.genericutility.Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.bouncycastle.asn1.cmc.GetCert;

import com.genericutility.IPathConstant;

public class ExcelUtility {
	
	public Object[][] getDataFromExcel(String sheetName) throws Throwable, Throwable{
	FileInputStream fis = new FileInputStream(IPathConstant.ExcelPath);
	Workbook wb = WorkbookFactory.create(fis);
	Sheet sh = wb.getSheet("sheetName");
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
	public HashMap<String,String> getMultipleData(String sheetName) throws Throwable{
		FileInputStream fis=new FileInputStream(IPathConstant.ExcelPath);
		Workbook wb = WorkbookFactory.create(fis);
		 Sheet sh = wb.getSheet(sheetName);
		 int count = sh.getLastRowNum();
		 HashMap<String,String> map=new HashMap<String, String>();
		 for(int i=0;i<count;i++) {
			 String key = sh.getRow(i).getCell(0).getStringCellValue();
			 String value = sh.getRow(i).getCell(1).getStringCellValue();
			 map.put(key, value);
		 }
		 return map;
	}
}

