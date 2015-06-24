package com.mofang.feedweb.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import com.mofang.feedweb.component.UserComponent;

public class LoginInterceptor extends HandlerInterceptorAdapter {

	@Autowired
	private UserComponent userComp;

	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object arg2) throws Exception {

		if (!userComp.validate(request)) {
			response.sendRedirect("http://u.mofang.com/home/account/index");
			return false;
		}
		// JSONObject result = new JSONObject();
		// result.put("code", -1) ;
		// result.put("message", "please login!");
		// response.getWriter().print(result);
		return true;
	}
	
	

}
