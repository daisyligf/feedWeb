package com.mofang.feedweb.interceptor;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Request;
import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.mofang.feedweb.global.CommonUrl;
import com.mofang.feedweb.global.Constant;
import com.mofang.feedweb.util.LogConsole;
@Repository
public class UrlRedirectInterceptor extends HandlerInterceptorAdapter{

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
	}
	
	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	}
	
	@Override 
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handle) throws Exception {
		
		String uri = request.getRequestURI();
		if (uri.indexOf("/p/") != -1 ) {
			LogConsole.log("/p/:老版帖子urL:" + uri);
			int index = uri.indexOf("/p/");
			String strRight = uri.substring(index + 3, uri.length() - 5);// [/p/352-888833.html]的352-888833部分
			String[] ids = strRight.split("-");
			if (ids.length == 2) {
				int threadId = Integer.valueOf(ids[1]);
				if (threadId > 938054) {
					threadId = threadId + 50000;
					response.sendRedirect(CommonUrl.bbsHomeUrl + "/thread_info?thread_id=" + threadId);
					LogConsole.log("老版帖子RedirectURL:" + CommonUrl.bbsHomeUrl + "/thread_info?thread_id=" + threadId);
					return false;
				}
			}
		}
		
		return true;
		
	}
	
    
}
