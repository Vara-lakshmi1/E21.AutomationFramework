package genericutilities;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * This class consist of generic methods related to specific to java 
 * @author Vara
 *
 */

public class JavaUtility 

{
	/**
	 * This method will capture the current system date and return to caller 
	 * @return Date
	 */
  public String getSystemDate()//screenshot name,report name
  {
	  Date d=new Date();
	  SimpleDateFormat s=new SimpleDateFormat("dd-mm-yyyy_hh-mm-ss");
	  String date = s.format(d);
	  return date;
  }
}
