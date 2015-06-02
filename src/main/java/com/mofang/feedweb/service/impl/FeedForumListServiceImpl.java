//package com.mofang.feedweb.service.impl;
//
//import org.json.JSONObject;
//
//import com.mofang.feedweb.global.Constant;
//import com.mofang.feedweb.global.GlobalObject;
//import com.mofang.feedweb.service.FeedForumContentService;
//import com.mofang.feedweb.service.FeedForumListService;
//import com.mofang.feedweb.util.StringUtil;
//import com.mofang.feedweb.util.Tools;
//
//public class FeedForumListServiceImpl implements FeedForumListService {
//	
//	
//	
//	@Override
//	public JSONObject getForumListByLetterGroup(int p, int pagesize, int type, String letterGroup) throws Exception {
//		
//		try
//		{
//			StringBuffer name = new StringBuffer();
//			StringBuffer content = new StringBuffer();
//			
//			name.append("p");
//			name.append(Constant.STR_COMMA);
//			name.append("pagesize");
//			name.append(Constant.STR_COMMA);
//			name.append("type");
//			name.append(Constant.STR_COMMA);
//			name.append("pagesize");
//			name.append(Constant.STR_COMMA);
//			name.append("letterGroup");
//			content.append(p);
//			content.append(Constant.STR_COMMA);
//			content.append(pagesize);
//			content.append(Constant.STR_COMMA);
//			content.append(type);
//			content.append(Constant.STR_COMMA);
//			content.append(pagesize);
//			content.append(Constant.STR_COMMA);
//			content.append(letterGroup);
//			
//			String parameterURL = Tools.editURLParameter(name.toString(),content.toString());
//			String result = Tools.getHttpInfo(Constant.LIST_FORUM_GET_URL.concat(Constant.STR_QUESTION_MARK).concat(parameterURL));
//			if(StringUtil.isNullOrEmpty(result))
//				return null;
//			
//			return new JSONObject(result);
//		}
//		catch(Exception e)
//		{
//			GlobalObject.ERROR_LOG.error("at FeedForumListServiceImpl.getForumListByLetterGroup throw an error.", e);
//			return null;
//		}
//	}
//
//	
//
//	
//
//}
