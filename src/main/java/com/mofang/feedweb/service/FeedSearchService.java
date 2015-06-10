package com.mofang.feedweb.service;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONObject;

public interface FeedSearchService {

	public JSONObject searchForum(String requestParam, HttpServletRequest request) throws Exception;
	
	public JSONObject searchThread(String requestParam, HttpServletRequest request) throws Exception;
	
}
