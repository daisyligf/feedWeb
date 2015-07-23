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
import com.mofang.feedweb.util.StringUtil;
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
		//带版块ID的帖子页面
		if (uri.indexOf("/p/") != -1 ) {
			LogConsole.log("/p/:老版帖子urL:" + uri);
			int index = uri.indexOf("/p/");
			String strRight = uri.substring(index + 3, uri.length() - 5);
			String[] ids = strRight.split("-");
			if (StringUtil.isLong(ids[1])) {
				if (ids.length == 2 ) {// [/p/352-888833.html]带版块ID不带页码
					
					long threadId = Long.valueOf(ids[1]);
					if (threadId > 938054) {
						threadId = threadId + 50000;
					}
					response.sendRedirect(CommonUrl.bbsHomeUrl + "/thread_info?thread_id=" + threadId);
					LogConsole.log("帖子RedirectURL:" + CommonUrl.bbsHomeUrl + "/thread_info?thread_id=" + threadId);
					return false;
					
				} else if (ids.length > 2) {// [/p/352-888833-2.html]带版块ID和页码
					long threadId = Long.valueOf(ids[1]);
					if (threadId > 938054) {
						threadId = threadId + 50000;
					}
					
					if (StringUtil.isInteger(ids[2])) {
						int currentPage = Integer.valueOf(ids[2]);
						response.sendRedirect(CommonUrl.bbsHomeUrl + "/thread_info?currentPage=" + currentPage + "&thread_id=" + threadId + "&type=0");
						LogConsole.log("帖子RedirectURL:" + CommonUrl.bbsHomeUrl + "/thread_info?currentPage=" + currentPage + "&thread_id=" + threadId + "&type=0");
					} else {
						response.sendRedirect(CommonUrl.bbsHomeUrl + "/thread_info?thread_id=" + threadId);
						LogConsole.log("帖子RedirectURL:" + CommonUrl.bbsHomeUrl + "/thread_info?thread_id=" + threadId);
					}
					return false;
				}
			}
		}
		//不带版块ID的帖子页面
		if (uri.indexOf("/t/") != -1 ) {
			LogConsole.log("/t/:老版版块urL:" + uri);
			int index = uri.indexOf("/t/");
			String strRight = uri.substring(index + 3, uri.length() - 5);
			String[] ids = strRight.split("-");
			if (StringUtil.isLong(ids[0])) {
				if (ids.length == 1) {// [/t/35222.html]不带页码
					long threadId = Long.valueOf(ids[0]);
					if (threadId > 938054) {
						threadId = threadId + 50000;
					}
					response.sendRedirect(CommonUrl.bbsHomeUrl + "/thread_info?thread_id=" + threadId);
					LogConsole.log("帖子RedirectURL:" + CommonUrl.bbsHomeUrl + "/thread_info?thread_id=" + threadId);
					return false;
				} else if (ids.length == 2) {// [/t/35222-2.html]带页码
					long threadId = Long.valueOf(ids[0]);
					if (threadId > 938054) {
						threadId = threadId + 50000;
					}
					if (StringUtil.isInteger(ids[1])) {
						int currentPage = Integer.valueOf(ids[1]);
						response.sendRedirect(CommonUrl.bbsHomeUrl + "/thread_info?currentPage=" + currentPage + "&thread_id=" + threadId + "&type=0");
						LogConsole.log("帖子RedirectURL:" + CommonUrl.bbsHomeUrl + "/thread_info?currentPage=" + currentPage + "&thread_id=" + threadId + "&type=0");
					} else {
						response.sendRedirect(CommonUrl.bbsHomeUrl + "/thread_info?thread_id=" + threadId);
						LogConsole.log("帖子RedirectURL:" + CommonUrl.bbsHomeUrl + "/thread_info?thread_id=" + threadId);
					}
					return false;
				}
			}
		}
		
		//版块详情页面跳转
		if (uri.indexOf("/f/") != -1 ) {
			LogConsole.log("/f/:老版版块urL:" + uri);
			int index = uri.indexOf("/f/");
			String strRight = uri.substring(index + 3, uri.length() - 5);// [/f/10-2.html]的10部分
			String[] ids = strRight.split("-");
			if (StringUtil.isLong(ids[0])) {
				if (ids.length == 1) {
					long forumId = Long.valueOf(ids[0]);
					response.sendRedirect(CommonUrl.bbsHomeUrl + "/forum/" + forumId + "/0/0/1/0.html");
					LogConsole.log("老版版块RedirectURL:" + CommonUrl.bbsHomeUrl + "/forum/" + forumId + "/0/0/1/0.html");
					return false;
				} else if (ids.length == 2) {
					long forumId = Long.valueOf(ids[0]);
					if (StringUtil.isInteger(ids[1])) {
						int currentPage = Integer.valueOf(ids[1]);
						response.sendRedirect(CommonUrl.bbsHomeUrl + "/forum/" + forumId + "/0/0/" + currentPage + "/0.html");
						LogConsole.log("老版版块RedirectURL:" + CommonUrl.bbsHomeUrl + "/forum/" + forumId + "/0/0/" + currentPage + "/0.html");
					} else {
						response.sendRedirect(CommonUrl.bbsHomeUrl + "/forum/" + forumId + "/0/0/1/0.html");
						LogConsole.log("老版版块RedirectURL:" + CommonUrl.bbsHomeUrl + "/forum/" + forumId + "/0/0/1/0.html");
					}
					
					return false;
				}
			}
		}
		
		return true;
		
	}
	
    
}
