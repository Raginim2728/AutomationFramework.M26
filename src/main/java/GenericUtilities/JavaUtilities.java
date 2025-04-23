package GenericUtilities;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * This class contains generic methods related to java
 * @author Sowmiya
 */
public class JavaUtilities 
{
	/**
	 * This method contains system date in specific format
	 * @return
	 */
	public String getSystemDateInFormat()
	{
		Date d= new Date();
		SimpleDateFormat sf= new SimpleDateFormat("dd-MM-yyyy_hh-mm-ss");
		String date = sf.format(d);
		return date;
	}
}
