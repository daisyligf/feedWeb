package com.mofang.feedweb.service;



import org.json.JSONObject;


public interface FeedHomeService {
	
	/**
	 * 获取搜索关键字
	 * @throws Exception
	 */
	public JSONObject getSearchKey() throws Exception;
	
	
	/**
	 * 获取轮播海报
	 * @throws Exception
	 */
	public JSONObject getTickers() throws Exception;

	/**
	 * 获取大标题小标题信息
	 * @throws Exception
	 */
	public JSONObject getSubjects() throws Exception;

	/**
	 * 获取热门版块排行榜信息
	 * @throws Exception
	 */
	public JSONObject getHotForumRank() throws Exception;

	/**
	 * 获取新游推荐排行榜信息
	 * @throws Exception
	 */
	public JSONObject getGameRecommendRank() throws Exception;

	/**
	 * 获取热门游戏版块信息
	 * @throws Exception
	 */
	public JSONObject getHotForumList() throws Exception;

	/**
	 * 获取新游推荐版块信息
	 * @throws Exception
	 */
	public JSONObject getRecommendGameList() throws Exception;

	/**
	 * 获取综合专区版块信息
	 * @throws Exception
	 */
	public JSONObject getOffical() throws Exception;

}
