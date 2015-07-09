package com.mofang.feedweb.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtil {

	private static final SimpleDateFormat format = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm");
	
	public static String format(long time){
		return format.format(new Date(time));
	}
	
	public static String getFormat(Date date) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy");
		String year = dateFormat.format(date);
		String thisYear = dateFormat.format(new Date());
		
		if (year.equals(thisYear)) {
			return "MM-dd HH:mm";
		} else {
			return "yyyy-MM-dd HH:mm";
		}
	}
}
