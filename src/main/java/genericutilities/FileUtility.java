package genericutilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FileUtility 

{
	/**
	 * This method will read data from property file and return the value to caller 
	 * @param Key
	 * @return value
	 * @throws IOException
	 */
	public static String readDataFromPropertyFile(String Key) throws IOException 
	{
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties p=new Properties();
		p.load(fis);
		String value = p.getProperty(Key);
		return value;	
	}
	
	/**
	 * This method will read String Data from the given row and cell and return the value to caller
	 * @param sheetName
	 * @param rowNo
	 * @param celNo
	 * @return String_value
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public static String readDataFromExcelFile(String sheetName,int rowNo,int celNo) throws EncryptedDocumentException, IOException
    {
  	  FileInputStream fi=new FileInputStream(".\\src\\test\\resources\\TestDataAdSele.xlsx");
  	 Workbook wb = WorkbookFactory.create(fi);
  	 String num_value = wb.getSheet(sheetName).getRow(rowNo).getCell(celNo).getStringCellValue();
  	 return num_value;
    }
	/**
	 * This method will read the Numeric Data from the Excel File
	 * @param sheetName
	 * @param rowNo
	 * @param celNo
	 * @return Num_value
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
      public static double readNumericDataFromExcelFile(String sheetName,int rowNo,int celNo) throws EncryptedDocumentException, IOException
      {
    	  FileInputStream fi=new FileInputStream(".\\src\\test\\resources\\TestDataAdSele.xlsx");
    	 Workbook wb = WorkbookFactory.create(fi);
    	 double num_value = wb.getSheet(sheetName).getRow(rowNo).getCell(celNo).getNumericCellValue();
    	 return num_value;
      }

}
