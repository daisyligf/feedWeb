//package com.mofang.feedweb.service.impl;
//
//
//
//import org.json.JSONObject;
//
//import com.mofang.feedweb.global.Constant;
//import com.mofang.feedweb.global.GlobalObject;
//import com.mofang.feedweb.service.FeedThreadInfoService;
//import com.mofang.feedweb.util.StringUtil;
//import com.mofang.feedweb.util.Tools;
//
//
//public class FeedThreadInfoServiceImpl implements FeedThreadInfoService {
//	
//	/**
//	 * 搜索楼层list
//	 * @throws Exception
//	 */
//	public JSONObject getPostList(long uid, long tid, int p, int pagesize, int type) throws Exception {
//		try
//		{
//			StringBuffer name = new StringBuffer();
//			StringBuffer content = new StringBuffer();
//			
//			name.append("uid");
//			name.append(Constant.STR_COMMA);
//			name.append("tid");
//			name.append(Constant.STR_COMMA);
//			name.append("p");
//			name.append(Constant.STR_COMMA);
//			name.append("pagesize");
//			name.append(Constant.STR_COMMA);
//			name.append("type");
//			content.append(uid);
//			content.append(Constant.STR_COMMA);
//			content.append(tid);
//			content.append(Constant.STR_COMMA);
//			content.append(p);
//			content.append(Constant.STR_COMMA);
//			content.append(pagesize);
//			content.append(Constant.STR_COMMA);
//			content.append(type);
//			
//			String parameterURL = Tools.editURLParameter(name.toString(),content.toString());
//			String result = Tools.getHttpInfo(Constant.THREAD_POSTLIST_GET_URL.concat(Constant.STR_QUESTION_MARK).concat(parameterURL));
//			if(StringUtil.isNullOrEmpty(result))
//				return null;
//			
//			return new JSONObject(result);
//		}
//		catch(Exception e)
//		{
//			GlobalObject.ERROR_LOG.error("at FeedThreadInfoServiceImpl.getPostList throw an error.", e);
//			return null;
//		}
//	}
//	
//	/**
//	 * 搜索评论list
//	 * @throws Exception
//	 */
//	public JSONObject getCommentList(long postid, int p, int pagesize) throws Exception {
//		try
//		{
//			StringBuffer name = new StringBuffer();
//			StringBuffer content = new StringBuffer();
//			
//			name.append("postid");
//			name.append(Constant.STR_COMMA);
//			name.append("p");
//			name.append(Constant.STR_COMMA);
//			name.append("pagesize");
//			content.append(postid);
//			content.append(Constant.STR_COMMA);
//			content.append(p);
//			content.append(Constant.STR_COMMA);
//			content.append(pagesize);
//			
//			String parameterURL = Tools.editURLParameter(name.toString(),content.toString());
//			String result = Tools.getHttpInfo(Constant.THREAD_COMMENTLIST_GET_URL.concat(Constant.STR_QUESTION_MARK).concat(parameterURL));
//			if(StringUtil.isNullOrEmpty(result))
//				return null;
//			
//			return new JSONObject(result);
//		}
//		catch(Exception e)
//		{
//			GlobalObject.ERROR_LOG.error("at FeedThreadInfoServiceImpl.getCommentList throw an error.", e);
//			return null;
//		}
//	}
//	
//	/**
//	 * 新增楼层
//	 * @throws Exception
//	 */
//	public JSONObject createPost(JSONObject postInfo) throws Exception {
//		try
//		{
//			String result = Tools.postHttpInfo(Constant.POST_CREATE_URL, postInfo);
//			if(StringUtil.isNullOrEmpty(result))
//				return null;
//			
//			return new JSONObject(result);
//		}
//		catch(Exception e)
//		{
//			GlobalObject.ERROR_LOG.error("at FeedThreadInfoServiceImpl.createPost throw an error.", e);
//			return null;
//		}
//	}
//	
//	/**
//	 * 回复指定楼层
//	 * @throws Exception
//	 */
//	public JSONObject replyPost(JSONObject commentInfo) throws Exception {
//		try
//		{
//			String result = Tools.postHttpInfo(Constant.POST_REPLY_URL, commentInfo);
//			if(StringUtil.isNullOrEmpty(result))
//				return null;
//			
//			return new JSONObject(result);
//		}
//		catch(Exception e)
//		{
//			GlobalObject.ERROR_LOG.error("at FeedThreadInfoServiceImpl.applyPost throw an error.", e);
//			return null;
//		}
//	}
//	
//	/**
//	 * 帖子管理 编辑
//	 * @throws Exception
//	 */
//	public JSONObject threadEdit(JSONObject threadInfo) throws Exception {
//		try
//		{
//			String result = Tools.postHttpInfo(Constant.THREAD_EDIT_URL, threadInfo);
//			if(StringUtil.isNullOrEmpty(result))
//				return null;
//			
//			return new JSONObject(result);
//		}
//		catch(Exception e)
//		{
//			GlobalObject.ERROR_LOG.error("at FeedThreadInfoServiceImpl.threadEdit throw an error.", e);
//			return null;
//		}
//	}
//	
//	/**
//	 * 帖子管理 删除
//	 * @throws Exception
//	 */
//	public JSONObject threadDelete(JSONObject threadDeleteInfo) throws Exception {
//		try
//		{
//			String result = Tools.postHttpInfo(Constant.THREAD_DELETE_URL, threadDeleteInfo);
//			if(StringUtil.isNullOrEmpty(result))
//				return null;
//			
//			return new JSONObject(result);
//		}
//		catch(Exception e)
//		{
//			GlobalObject.ERROR_LOG.error("at FeedThreadInfoServiceImpl.threadDelete throw an error.", e);
//			return null;
//		}
//	}
//	
//	/**
//	 * 帖子管理 加精
//	 * @throws Exception
//	 */
//	public JSONObject threadSetElite(JSONObject setEliteInfo) throws Exception {
//		try
//		{
//			String result = Tools.postHttpInfo(Constant.THREAD_SETELITE_URL, setEliteInfo);
//			if(StringUtil.isNullOrEmpty(result))
//				return null;
//			
//			return new JSONObject(result);
//		}
//		catch(Exception e)
//		{
//			GlobalObject.ERROR_LOG.error("at FeedThreadInfoServiceImpl.threadSetElite throw an error.", e);
//			return null;
//		}
//	}
//	
//	/**
//	 * 帖子管理-取消加精
//	 * @throws Exception
//	 */
//	public JSONObject threadCancelElite(JSONObject CancelEliteInfo) throws Exception {
//		try
//		{
//			String result = Tools.postHttpInfo(Constant.THREAD_CANCELELITE_URL, CancelEliteInfo);
//			if(StringUtil.isNullOrEmpty(result))
//				return null;
//			
//			return new JSONObject(result);
//		}
//		catch(Exception e)
//		{
//			GlobalObject.ERROR_LOG.error("at FeedThreadInfoServiceImpl.threadCancelElite throw an error.", e);
//			return null;
//		}
//	}
//	
//	/**
//	 * 帖子管理-置顶
//	 * @throws Exception
//	 */
//	public JSONObject threadSetTop(JSONObject setTopInfo) throws Exception {
//		try
//		{
//			String result = Tools.postHttpInfo(Constant.THREAD_SETTOP_URL, setTopInfo);
//			if(StringUtil.isNullOrEmpty(result))
//				return null;
//			
//			return new JSONObject(result);
//		}
//		catch(Exception e)
//		{
//			GlobalObject.ERROR_LOG.error("at FeedThreadInfoServiceImpl.threadSetTop throw an error.", e);
//			return null;
//		}
//	}
//	
//	/**
//	 * 帖子管理-取消置顶
//	 * @throws Exception
//	 */
//	public JSONObject threadCancelTop(JSONObject cancelTopInfo) throws Exception {
//		try
//		{
//			String result = Tools.postHttpInfo(Constant.THREAD_CANCELTOP_URL, cancelTopInfo);
//			if(StringUtil.isNullOrEmpty(result))
//				return null;
//			
//			return new JSONObject(result);
//		}
//		catch(Exception e)
//		{
//			GlobalObject.ERROR_LOG.error("at FeedThreadInfoServiceImpl.threadCancelTop throw an error.", e);
//			return null;
//		}
//	}
//	
//	/**
//	 * 帖子管理-锁帖
//	 * @throws Exception
//	 */
//	public JSONObject threadClose(JSONObject closeInfo) throws Exception {
//		try
//		{
//			String result = Tools.postHttpInfo(Constant.THREAD_CLOSE_URL, closeInfo);
//			if(StringUtil.isNullOrEmpty(result))
//				return null;
//			
//			return new JSONObject(result);
//		}
//		catch(Exception e)
//		{
//			GlobalObject.ERROR_LOG.error("at FeedThreadInfoServiceImpl.threadClose throw an error.", e);
//			return null;
//		}
//	}
//	
//	/**
//	 * 帖子管理-取消锁帖
//	 * @throws Exception
//	 */
//	public JSONObject threadOpen(JSONObject openInfo) throws Exception {
//		try
//		{
//			String result = Tools.postHttpInfo(Constant.THREAD_OPEN_URL, openInfo);
//			if(StringUtil.isNullOrEmpty(result))
//				return null;
//			
//			return new JSONObject(result);
//		}
//		catch(Exception e)
//		{
//			GlobalObject.ERROR_LOG.error("at FeedThreadInfoServiceImpl.threadOpen throw an error.", e);
//			return null;
//		}
//	}
//	
//	/**
//	 * 帖子管理-楼层删除
//	 * @throws Exception
//	 */
//	public JSONObject postDelete(JSONObject postDeleteInfo) throws Exception {
//		try
//		{
//			String result = Tools.postHttpInfo(Constant.POST_DELETE_URL, postDeleteInfo);
//			if(StringUtil.isNullOrEmpty(result))
//				return null;
//			
//			return new JSONObject(result);
//		}
//		catch(Exception e)
//		{
//			GlobalObject.ERROR_LOG.error("at FeedThreadInfoServiceImpl.postDelete throw an error.", e);
//			return null;
//		}
//	}
//	
//	/**
//	 * 帖子管理-楼层点赞
//	 * @throws Exception
//	 */
//	public JSONObject postRecommend(JSONObject recommendInfo) throws Exception {
//		try
//		{
//			String result = Tools.postHttpInfo(Constant.POST_COMMEND_URL, recommendInfo);
//			if(StringUtil.isNullOrEmpty(result))
//				return null;
//			
//			return new JSONObject(result);
//		}
//		catch(Exception e)
//		{
//			GlobalObject.ERROR_LOG.error("at FeedThreadInfoServiceImpl.postRecommend throw an error.", e);
//			return null;
//		}
//	}
//	
//
//	@Override
//	public JSONObject getForumRecommendInfo(long fid) throws Exception {
//		// TODO Auto-generated method stub
//		return null;
//	}
//	
//	
//	
//
//}
