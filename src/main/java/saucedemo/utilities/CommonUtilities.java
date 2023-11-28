package saucedemo.utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CommonUtilities {
	
	public static String getCurrentDateTimeStamp() {
		return new SimpleDateFormat("ddMMyyyyHHmmss").format(new Date());
	}

}
