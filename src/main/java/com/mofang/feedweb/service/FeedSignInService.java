package com.mofang.feedweb.service;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONObject;

public interface FeedSignInService {
	
	public JSONObject getSignInstate(HttpServletRequest request)  throws Exception;
	
	public JSONObject addSignIn(HttpServletRequest request)  throws Exception;

}
