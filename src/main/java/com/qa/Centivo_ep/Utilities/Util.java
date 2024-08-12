package com.qa.Centivo_ep.Utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Util {
	
	public static final int IMPLICIT_WAIT_TIME = 10;
	public static final int PAGE_LOAD_TIME = 200;
	public static final int SCRIPT_TIME= 1000;
	
	
	public static String dateTimeStamp() {
		Date date = new Date();
		System.out.println(date); // Sun Aug 11 12:02:06 EDT 2024
		                         // 8/9/2024, 1:33:06 PM
        SimpleDateFormat desiredDateFormat = new SimpleDateFormat("M/dd/yyyy, hh:mm:ss a");
		String actualDateFormat = desiredDateFormat.format(date);
		System.out.println(actualDateFormat);
		return actualDateFormat;
	}
}
