package com.mofang.feedweb.service;



import org.json.JSONObject;


public interface FeedForumContentService {
	
	/**
	 * 获取主题列表
	 * @throws Exception
	 */
	public JSONObject getThreadList(long uid, long fid, int p, int pagesize, int type, int tagId) throws Exception;
	
	
	/**
	 * 获取版块信息
	 * @throws Exception
	 */
	public JSONObject getForumInfo(long fid) throws Exception;

	/**
	 * 获取吧主列表信息
	 * @throws Exception
	 */
	public JSONObject getModeratorList(long fid) throws Exception;
	
	/**
	 * 关注版块
	 * @throws Exception
	 */
	public JSONObject ForumFollow(JSONObject followInfo) throws Exception;
	
	/**
	 * 取消关注版块
	 * @throws Exception
	 */
	public JSONObject CancelForumFollow(JSONObject cancelInfo) throws Exception;

	

}
