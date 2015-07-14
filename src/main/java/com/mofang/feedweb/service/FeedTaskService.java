package com.mofang.feedweb.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;


public interface FeedTaskService {
	public Map<String, Object> getTaskState(HttpServletRequest request)  throws Exception;
}
