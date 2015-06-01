package com.mofang.feedweb.service;



import org.json.JSONObject;


public interface FeedSearchPageService {
	
	/**
	 * 搜索版块
	 * @throws Exception
	 */
	public JSONObject forumSearch(String keyword, int p, int pagesize) throws Exception;
	
	/**
	 * 搜索帖子
	 * @throws Exception
	 */
	public JSONObject threadSearch(long fid, String author, int status, String keyword, int p, int pagesize) throws Exception;
	
	
	

}
