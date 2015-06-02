package com.mofang.feedweb.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtil {

	private static final SimpleDateFormat format = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm");
	
	public static String format(long time){
		return format.format(new Date(time));
	}
	
	
}
