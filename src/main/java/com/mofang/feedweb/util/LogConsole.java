package com.mofang.feedweb.util;

import com.mofang.feedweb.global.GlobalObject;

public class LogConsole {

	public static void log(String result) {
		GlobalObject.INFO_LOG.info("response data: " + result);
	}
	
}
