//package com.mofang.feedweb.service.impl;
//
//import org.json.JSONObject;
//
//import com.mofang.feedweb.global.Constant;
//import com.mofang.feedweb.global.GlobalObject;
//import com.mofang.feedweb.service.FeedForumContentService;
//import com.mofang.feedweb.util.StringUtil;
//import com.mofang.feedweb.util.Tools;
//
//public class FeedForumContentServiceImpl implements FeedForumContentService {
//	
//	
//	
//	@Override
//	public JSONObject getThreadList(long uid, long fid, int p, int pagesize, int type, int tagId) throws Exception {
//		
//		try
//		{
//			StringBuffer name = new StringBuffer();
//			StringBuffer content = new StringBuffer();
//			
//			name.append("uid");
//			name.append(Constant.STR_COMMA);
//			name.append("fid");
//			name.append(Constant.STR_COMMA);
//			name.append("p");
//			name.append(Constant.STR_COMMA);
//			name.append("pagesize");
//			name.append(Constant.STR_COMMA);
//			name.append("type");
//			name.append(Constant.STR_COMMA);
//			name.append("tagId");
//			content.append(uid);
//			content.append(Constant.STR_COMMA);
//			content.append(fid);
//			content.append(Constant.STR_COMMA);
//			content.append(p);
//			content.append(Constant.STR_COMMA);
//			content.append(pagesize);
//			content.append(Constant.STR_COMMA);
//			content.append(type);
//			content.append(Constant.STR_COMMA);
//			content.append(tagId);
//			
//			String parameterURL = Tools.editURLParameter(name.toString(),content.toString());
//			String result = Tools.getHttpInfo(Constant.LIST_THREAD_GET_URL.concat(Constant.STR_QUESTION_MARK).concat(parameterURL));
//			if(StringUtil.isNullOrEmpty(result))
//				return null;
//			
//			return new JSONObject(result);
//		}
//		catch(Exception e)
//		{
//			GlobalObject.ERROR_LOG.error("at FeedForumContentServiceImpl.getThreadList throw an error.", e);
//			return null;
//		}
//	}
//
//	@Override
//	public JSONObject getForumInfo(long fid) throws Exception {
//
//		try
//		{
//			StringBuffer name = new StringBuffer();
//			StringBuffer content = new StringBuffer();
//			
//			name.append("fid");
//			content.append(fid);
//			
//			String parameterURL = Tools.editURLParameter(name.toString(),content.toString());
//			String result = Tools.getHttpInfo(Constant.FORUM_INFO_GET_URL.concat(Constant.STR_QUESTION_MARK).concat(parameterURL));
//			if(StringUtil.isNullOrEmpty(result))
//				return null;
//			
//			return new JSONObject(result);
//		}
//		catch(Exception e)
//		{
//			GlobalObject.ERROR_LOG.error("at FeedForumContentServiceImpl.getForumInfo throw an error.", e);
//			return null;
//		}
//	}
//
//	@Override
//	public JSONObject getModeratorList(long fid) throws Exception {
//		
//		try
//		{
//			StringBuffer name = new StringBuffer();
//			StringBuffer content = new StringBuffer();
//			
//			name.append("fid");
//			content.append(fid);
//			
//			String parameterURL = Tools.editURLParameter(name.toString(),content.toString());
//			String result = Tools.getHttpInfo(Constant.LIST_MODERATOR_GET_URL.concat(Constant.STR_QUESTION_MARK).concat(parameterURL));
//			if(StringUtil.isNullOrEmpty(result))
//				return null;
//			
//			return new JSONObject(result);
//		}
//		catch(Exception e)
//		{
//			GlobalObject.ERROR_LOG.error("at FeedForumContentServiceImpl.getModeratorList throw an error.", e);
//			return null;
//		}
//	}
//
//	@Override
//	public JSONObject ForumFollow(JSONObject followInfo) throws Exception {
//		try
//		{
//			String result = Tools.postHttpInfo(Constant.FORUM_FOLLOW_URL, followInfo);
//			if(StringUtil.isNullOrEmpty(result))
//				return null;
//			
//			return new JSONObject(result);
//		}
//		catch(Exception e)
//		{
//			GlobalObject.ERROR_LOG.error("at FeedForumContentServiceImpl.ForumFollow throw an error.", e);
//			return null;
//		}
//	}
//
//	@Override
//	public JSONObject CancelForumFollow(JSONObject cancelInfo) throws Exception {
//		try
//		{
//			String result = Tools.postHttpInfo(Constant.FORUM_CANCELFOLLOW_URL, cancelInfo);
//			if(StringUtil.isNullOrEmpty(result))
//				return null;
//			
//			return new JSONObject(result);
//		}
//		catch(Exception e)
//		{
//			GlobalObject.ERROR_LOG.error("at FeedForumContentServiceImpl.CancelForumFollow throw an error.", e);
//			return null;
//		}
//	}
//
//	
//
//}
