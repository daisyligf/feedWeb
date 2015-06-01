package com.mofang.feedweb.service;

import org.json.JSONObject;

public interface FeedForumListService {

	/**
	 * 获取版块列表list
	 * @throws Exception
	 */
	public JSONObject getForumListByLetterGroup(int p, int pagesize, int type, String letterGroup) throws Exception;
	
		
}
