//package com.mofang.feedweb.service.impl;
//
//import org.json.JSONObject;
//
//import com.mofang.feedweb.global.Constant;
//import com.mofang.feedweb.global.GlobalObject;
//import com.mofang.feedweb.service.FeedSearchPageService;
//import com.mofang.feedweb.util.StringUtil;
//import com.mofang.feedweb.util.Tools;
//
//public class FeedSearchPageServiceImpl implements FeedSearchPageService{
//
//	@Override
//	public JSONObject forumSearch(String keyword, int p, int pagesize)
//			throws Exception {
//		
//		try
//		{
//			StringBuffer name = new StringBuffer();
//			StringBuffer content = new StringBuffer();
//			
//			name.append("keyword");
//			name.append(Constant.STR_COMMA);
//			name.append("p");
//			name.append(Constant.STR_COMMA);
//			name.append("pagesize");
//			content.append(keyword);
//			content.append(Constant.STR_COMMA);
//			content.append(p);
//			content.append(Constant.STR_COMMA);
//			content.append(pagesize);
//			
//			String parameterURL = Tools.editURLParameter(name.toString(),content.toString());
//			String result = Tools.getHttpInfo(Constant.LIST_FORUM_SEARCH_URL.concat(Constant.STR_QUESTION_MARK).concat(parameterURL));
//			if(StringUtil.isNullOrEmpty(result))
//				return null;
//			
//			return new JSONObject(result);
//		}
//		catch(Exception e)
//		{
//			GlobalObject.ERROR_LOG.error("at FeedSearchPageServiceImpl.forumSearch throw an error.", e);
//			return null;
//		}
//	}
//
//	@Override
//	public JSONObject threadSearch(long fid, String author, int status,
//			String keyword, int p, int pagesize) throws Exception {
//		
//		try
//		{
//			StringBuffer name = new StringBuffer();
//			StringBuffer content = new StringBuffer();
//			
//			name.append("fid");
//			name.append(Constant.STR_COMMA);
//			name.append("author");
//			name.append(Constant.STR_COMMA);
//			name.append("status");
//			name.append(Constant.STR_COMMA);
//			name.append("keyword");
//			name.append(Constant.STR_COMMA);
//			name.append("p");
//			name.append(Constant.STR_COMMA);
//			name.append("pagesize");
//			content.append(keyword);
//			content.append(Constant.STR_COMMA);
//			content.append(p);
//			content.append(Constant.STR_COMMA);
//			content.append(pagesize);
//			content.append(Constant.STR_COMMA);
//			content.append(keyword);
//			content.append(Constant.STR_COMMA);
//			content.append(p);
//			content.append(pagesize);
//			
//			String parameterURL = Tools.editURLParameter(name.toString(),content.toString());
//			String result = Tools.getHttpInfo(Constant.LIST_FORUM_SEARCH_URL.concat(Constant.STR_QUESTION_MARK).concat(parameterURL));
//			if(StringUtil.isNullOrEmpty(result))
//				return null;
//			
//			return new JSONObject(result);
//		}
//		catch(Exception e)
//		{
//			GlobalObject.ERROR_LOG.error("at FeedSearchPageServiceImpl.forumSearch throw an error.", e);
//			return null;
//		}
//	}
//
//}
