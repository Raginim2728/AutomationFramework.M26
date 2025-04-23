package GenericUtilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This class contains generic methods related to File operations
 * @author Sowmiya
 */
public class FileUtilities 
{
	/**
	 * This method will read data from property file and return the 
	 * value to Caller
	 * @param key
	 * @return
	 * @throws IOException
	 */
	public String readDataFromPropertyFile(String key) throws IOException
	{
		FileInputStream file1= new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties p= new Properties();
		p.load(file1);
		String value = p.getProperty(key);
		return value;
	
		
	}
	
	public String readDataFromExcel(String sheetname, int rowNo, int cellNo) throws EncryptedDocumentException, IOException
	{
		FileInputStream file =new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		
		Workbook wb= WorkbookFactory.create(file);
		String value = wb.getSheet(sheetname).getRow(rowNo).getCell(cellNo).getStringCellValue();
		return value;
	}
}
