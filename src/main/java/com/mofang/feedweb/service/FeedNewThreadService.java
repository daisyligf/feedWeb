package com.mofang.feedweb.service;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.json.JSONObject;

public interface FeedNewThreadService {

	public Map<String, Object> userMap(String requestParam, HttpServletRequest request) throws Exception;
	
	public Map<String, Object> tagMap(String requestParam, HttpServletRequest request) throws Exception;
	
	public Map<String, Object> threadInfoMap(String requestParam, HttpServletRequest request) throws Exception;
	
	public JSONObject newThread(JSONObject json, HttpServletRequest request) throws Exception;
	
	public JSONObject editThread(JSONObject json, HttpServletRequest request) throws Exception;
}
