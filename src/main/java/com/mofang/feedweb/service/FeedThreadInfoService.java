package com.mofang.feedweb.service;



import org.json.JSONObject;


public interface FeedThreadInfoService {
	
	/**
	 * 楼层list
	 * @throws Exception
	 */
	public JSONObject getPostList(long uid, long tid, int p, int pagesize, int type) throws Exception;
	
	/**
	 * 评论list
	 * @throws Exception
	 */
	public JSONObject getCommentList(long postid, int p, int pagesize) throws Exception;
	
	/**
	 * 新增楼层
	 * @throws Exception
	 */
	public JSONObject createPost(JSONObject postInfo) throws Exception;
	
	/**
	 * 回复指定楼层
	 * @throws Exception
	 */
	public JSONObject replyPost(JSONObject commentInfo) throws Exception;
	
	/**
	 * 帖子管理 编辑
	 * @throws Exception
	 */
	public JSONObject threadEdit(JSONObject threadInfo) throws Exception;
	
	/**
	 * 帖子管理 删除
	 * @throws Exception
	 */
	public JSONObject threadDelete(JSONObject threadDeleteInfo) throws Exception;
	
	/**
	 * 帖子管理 加精
	 * @throws Exception
	 */
	public JSONObject threadSetElite(JSONObject setEliteInfo) throws Exception;
	
	/**
	 * 帖子管理-取消加精
	 * @throws Exception
	 */
	public JSONObject threadCancelElite(JSONObject CancelEliteInfo) throws Exception;
	
	/**
	 * 帖子管理-置顶
	 * @throws Exception
	 */
	public JSONObject threadSetTop(JSONObject setTopInfo) throws Exception;
	
	/**
	 * 帖子管理-取消置顶
	 * @throws Exception
	 */
	public JSONObject threadCancelTop(JSONObject cancelTopInfo) throws Exception;
	
	/**
	 * 帖子管理-锁帖
	 * @throws Exception
	 */
	public JSONObject threadClose(JSONObject closeInfo) throws Exception;
	
	/**
	 * 帖子管理-取消锁帖
	 * @throws Exception
	 */
	public JSONObject threadOpen(JSONObject openInfo) throws Exception;
	
	/**
	 * 帖子管理-楼层删除
	 * @throws Exception
	 */
	public JSONObject postDelete(JSONObject postDeleteInfo) throws Exception;
	
	/**
	 * 帖子管理-楼层点赞
	 * @throws Exception
	 */
	public JSONObject postRecommend(JSONObject recommendInfo) throws Exception;
	
	
	/**
	 * 最热推荐
	 * @throws Exception
	 */
	public JSONObject getForumRecommendInfo(long fid) throws Exception;
	
	
	

}
