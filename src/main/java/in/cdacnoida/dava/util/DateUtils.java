package in.cdacnoida.dava.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public interface DateUtils {
	
	  public static String dateToDateTimeString(Date date){
			DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm a");
			return dateFormat.format(date);						
	  }
	  
	  
}
