package Vtiger.Practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import 	org.apache.poi.ss.usermodel.Cell;

public class ExcelFilePractice {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// TODO Auto-generated method stub
		
		//Step 1 : load the file in java readable formate
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\Test Data.xlsx");
		
		//step 2 : create a workbook
		Workbook wb = WorkbookFactory.create(fis);
		
		//Step 3 : get control over sheet
		Sheet ss = wb.getSheet("Organizations");
		
		//Step 4 : get control over row
		Row rw = ss.getRow(1);
	
		//Step 5 : get control over cell
		Cell cell = rw.getCell(2);
		
		//Step 6 : read the data inside a cell
		String value = cell.getStringCellValue();
		System.out.println(value);

	}

}
