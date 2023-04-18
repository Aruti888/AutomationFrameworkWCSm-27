package Vtiger.GenericUtilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This class consist of Generic methods related to excel sheet
 * @author Dell
 *
 */

public class ExcelFileUtility {
	/**
	 * This method will read data from excel sheet
	 * @param SheetName
	 * @param rowNo
	 * @param celNo
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public String readDataFromExcel(String SheetName, int rowNo, int celNo) throws EncryptedDocumentException, IOException
	{
		FileInputStream fise = new FileInputStream(".\\src\\test\\resources\\Test Data.xlsx");
		Workbook wb = WorkbookFactory.create(fise);
		String value=wb.getSheet(SheetName).getRow(rowNo).getCell(celNo).getStringCellValue();
		return value;
	}
	public void writeIntoExcel(String SheetName, int rowNo, int celNo, String value) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\Test Data.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh= wb.getSheet(SheetName);
		Row rw = sh.createRow(rowNo);
		Cell ce = rw.createCell(celNo);
		ce.setCellValue(value);
		
		FileOutputStream fos = new FileOutputStream(".\\src\\test\\resources\\Test Data.xlsx");
		wb.write(fos);
		wb.close();
	}
    public Object[][] readDataFromExcelToDataProvider(String SheetName) throws EncryptedDocumentException, IOException
    {
    	FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\Testdata.xlsx");
    	Workbook wb=WorkbookFactory.create(fis);
    	Sheet sh=wb.getSheet(SheetName);
    	int lastRow=sh.getLastRowNum();
    	int lastCell=sh.getRow(0).getLastCellNum();
    	
    	Object[][] data = new Object[lastRow][lastCell];
    	
    	for(int i=0; i<lastRow; i++) //row
    	{
    		for(int j=0; j<lastCell; j++) //cell
    		{
    			data[i][j] = sh.getRow(i+1).getCell(j).getStringCellValue();
    		}
    	}
         return data;
    }
		
	

}
