package com.mofang.feedweb.util;

import javax.servlet.http.HttpServletResponse;

public class RenderUtil {

	public static void render(HttpServletResponse response, String result) throws Exception {
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(result);
	}
	
}
