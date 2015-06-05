package com.mofang.feedweb.interceptor;

import java.net.URLDecoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.mofang.feedweb.component.HttpComponent;
import com.mofang.feedweb.properties.annotation.ExternalUrlInfo;


public class LoginInterceptor extends HandlerInterceptorAdapter {

	@Autowired
	private ExternalUrlInfo externalUrlInfo;
	
	@Autowired
	private HttpComponent httpComp;
	
    @SuppressWarnings("deprecation")
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,  
            Object arg2) throws Exception {  
		Cookie[] cookies=request.getCookies();//从request中获得cookie对象的集合  
		String user="";//登录用户   
		if(cookies!=null){  
		    for(int i=0;i<cookies.length;i++){  
		        if(cookies[i].getName().equals("mf_scis")){  
		            user = URLDecoder.decode(cookies[i].getValue());//获取用户名                                                                
		        }  
		    }  
		}
        String strResult = httpComp.get(externalUrlInfo.getUser_loginstatus_url() + "?user=" + user);
        JSONObject json = new JSONObject(strResult);
        int code = json.optInt("code", -1);
        
        if(code == 0) {
        	return true;
        }
//        JSONObject result = new JSONObject();
//        result.put("code", -1) ;
//        result.put("message", "please login!");
//        response.getWriter().print(result);
        return true;  
    }  
    
}
