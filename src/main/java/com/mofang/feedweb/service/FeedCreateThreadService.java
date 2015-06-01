package com.mofang.feedweb.service;



import org.json.JSONObject;


public interface FeedCreateThreadService {
	
	/**
	 * 创建新帖
	 * @throws Exception
	 */
	public JSONObject threadCreate(JSONObject createThreadInfo) throws Exception;
	
	/**
	 * 编辑帖子
	 * @throws Exception
	 */
	public JSONObject editThread(JSONObject editThreadInfo) throws Exception;
	
	
	/**
	 * 获取楼主信息
	 * @throws Exception
	 */
	public JSONObject getThreadStarterInfo(long tid) throws Exception;
	
	/**
	 * 获取发帖的版块标签
	 * @throws Exception
	 */
	public JSONObject getForumTagInfo(long fid) throws Exception;
	
	/**
	 * 获取帖子编辑信息
	 * @throws Exception
	 */
	public JSONObject getEditThreadInfo(long tid) throws Exception;
	
	

}
