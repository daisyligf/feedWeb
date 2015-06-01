//package com.mofang.feedweb.service.impl;
//
//import org.json.JSONObject;
//
//import com.mofang.feedweb.global.Constant;
//import com.mofang.feedweb.global.GlobalObject;
//import com.mofang.feedweb.service.FeedCreateThreadService;
//import com.mofang.feedweb.service.FeedForumContentService;
//import com.mofang.feedweb.service.FeedForumListService;
//import com.mofang.feedweb.util.StringUtil;
//import com.mofang.feedweb.util.Tools;
//
//public class FeedCreateThreadServiceImpl implements FeedCreateThreadService {
//	
//	
//	@Override
//	public JSONObject threadCreate(JSONObject createThreadInfo) throws Exception {
//		try
//		{
//			String result = Tools.postHttpInfo(Constant.THREAD_CREATE_URL, createThreadInfo);
//			if(StringUtil.isNullOrEmpty(result))
//				return null;
//			
//			return new JSONObject(result);
//		}
//		catch(Exception e)
//		{
//			GlobalObject.ERROR_LOG.error("at FeedCreateThreadServiceImpl.threadCreate throw an error.", e);
//			return null;
//		}
//	}
//
//	@Override
//	public JSONObject getThreadStarterInfo(long tid) throws Exception {
//		try
//		{
//			StringBuffer name = new StringBuffer();
//			StringBuffer content = new StringBuffer();
//			
//			name.append("tid");
//			content.append(tid);
//			
//			String parameterURL = Tools.editURLParameter(name.toString(),content.toString());
//			String result = Tools.getHttpInfo(Constant.THREAD_MODERATOR_INFO_URL.concat(Constant.STR_QUESTION_MARK).concat(parameterURL));
//			if(StringUtil.isNullOrEmpty(result))
//				return null;
//			
//			return new JSONObject(result);
//		}
//		catch(Exception e)
//		{
//			GlobalObject.ERROR_LOG.error("at FeedCreateThreadServiceImpl.getModeratorInfo throw an error.", e);
//			return null;
//		}
//	}
//
//	@Override
//	public JSONObject getForumTagInfo(long fid) throws Exception {
//		try
//		{
//			StringBuffer name = new StringBuffer();
//			StringBuffer content = new StringBuffer();
//			
//			name.append("fid");
//			content.append(fid);
//			
//			String parameterURL = Tools.editURLParameter(name.toString(),content.toString());
//			String result = Tools.getHttpInfo(Constant.FORUM_TAGINFO_URL.concat(Constant.STR_QUESTION_MARK).concat(parameterURL));
//			if(StringUtil.isNullOrEmpty(result))
//				return null;
//			
//			return new JSONObject(result);
//		}
//		catch(Exception e)
//		{
//			GlobalObject.ERROR_LOG.error("at FeedCreateThreadServiceImpl.getForumTagInfo throw an error.", e);
//			return null;
//		}
//	}
//
//	@Override
//	public JSONObject getEditThreadInfo(long tid) throws Exception {
//		try
//		{
//			StringBuffer name = new StringBuffer();
//			StringBuffer content = new StringBuffer();
//			
//			name.append("tid");
//			content.append(tid);
//			
//			String parameterURL = Tools.editURLParameter(name.toString(),content.toString());
//			String result = Tools.getHttpInfo(Constant.THREAD_INFO_URL.concat(Constant.STR_QUESTION_MARK).concat(parameterURL));
//			if(StringUtil.isNullOrEmpty(result))
//				return null;
//			
//			return new JSONObject(result);
//		}
//		catch(Exception e)
//		{
//			GlobalObject.ERROR_LOG.error("at FeedCreateThreadServiceImpl.getEditThreadInfo throw an error.", e);
//			return null;
//		}
//	}
//
//	@Override
//	public JSONObject editThread(JSONObject editThreadInfo) throws Exception {
//		try
//		{
//			String result = Tools.postHttpInfo(Constant.THREAD_EDIT_URL, editThreadInfo);
//			if(StringUtil.isNullOrEmpty(result))
//				return null;
//			
//			return new JSONObject(result);
//		}
//		catch(Exception e)
//		{
//			GlobalObject.ERROR_LOG.error("at FeedCreateThreadServiceImpl.editThread throw an error.", e);
//			return null;
//		}
//	}
//
//	
//
//}
