//package com.mofang.feedweb.service.impl;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.json.JSONArray;
//import org.json.JSONObject;
//
//import com.mofang.feedweb.entity.GameRecommendRank;
//import com.mofang.feedweb.entity.HotForumRank;
//import com.mofang.feedweb.entity.HotGame;
//import com.mofang.feedweb.entity.NewsPaper;
//import com.mofang.feedweb.entity.RecommendGame;
//import com.mofang.feedweb.entity.ThreadsTitle;
//import com.mofang.feedweb.global.Constant;
//import com.mofang.feedweb.global.GlobalObject;
//import com.mofang.feedweb.service.FeedHomeService;
//import com.mofang.feedweb.util.StringUtil;
//import com.mofang.feedweb.util.Tools;
//
//public class FeedHomeServiceImpl implements FeedHomeService{
//	
//	
//	
//	@Override
//	public JSONObject getSearchKey() throws Exception {
//		
//		try
//		{
//			String result = Tools.getHttpInfo(Constant.HOME_SEARCH_KEYWORD_GET_URL);
//			if(StringUtil.isNullOrEmpty(result))
//				return null;
//			
//			return new JSONObject(result);
//		}
//		catch(Exception e)
//		{
//			GlobalObject.ERROR_LOG.error("at FeedHomeServiceImpl.getSearchKey throw an error.", e);
//			return null;
//		}
//	}
//
//	@Override
//	public JSONObject getTickers() throws Exception {
//
//		try
//		{
//			String result = Tools.getHttpInfo(Constant.TICKER_INFO_GET_URL);
//			if(StringUtil.isNullOrEmpty(result))
//				return null;
//			
//			return new JSONObject(result);
//		}
//		catch(Exception e)
//		{
//			GlobalObject.ERROR_LOG.error("at FeedHomeServiceImpl.getTickers throw an error.", e);
//			return null;
//		}
//	}
//
//	@Override
//	public JSONObject getHotForumRank() throws Exception {
//		
//		try
//		{
//			String result = Tools.getHttpInfo(Constant.HOT_FOURM_RANK_GET_URL);
//			if(StringUtil.isNullOrEmpty(result))
//				return null;
//			
//			return new JSONObject(result);
//		}
//		catch(Exception e)
//		{
//			GlobalObject.ERROR_LOG.error("at FeedHomeServiceImpl.getHotForumRank throw an error.", e);
//			return null;
//		}
//	}
//
//	@Override
//	public JSONObject getGameRecommendRank() throws Exception {
//		
//		try
//		{
//			String result = Tools.getHttpInfo(Constant.RECOMMEND_GAME_RANK_GET_URL);
//			if(StringUtil.isNullOrEmpty(result))
//				return null;
//			
//			return new JSONObject(result);
//		}
//		catch(Exception e)
//		{
//			GlobalObject.ERROR_LOG.error("at FeedHomeServiceImpl.getHotForumRank throw an error.", e);
//			return null;
//		}
//	}
//
//	@Override
//	public JSONObject getHotForumList() throws Exception {
//		
//		try
//		{
//			String result = Tools.getHttpInfo(Constant.LIST_HOT_FOURM_GET_URL);
//			if(StringUtil.isNullOrEmpty(result))
//				return null;
//			
//			return new JSONObject(result);
//		}
//		catch(Exception e)
//		{
//			GlobalObject.ERROR_LOG.error("at FeedHomeServiceImpl.getHotForumRank throw an error.", e);
//			return null;
//		}
//	}
//
//	@Override
//	public JSONObject getRecommendGameList() throws Exception {
//		
//		try
//		{
//			String result = Tools.getHttpInfo(Constant.LIST_RECOMMENDGAME_GET_URL);
//			if(StringUtil.isNullOrEmpty(result))
//				return null;
//			
//			return new JSONObject(result);
//		}
//		catch(Exception e)
//		{
//			GlobalObject.ERROR_LOG.error("at FeedHomeServiceImpl.getRecommendGameList throw an error.", e);
//			return null;
//		}
//	}
//
//	@Override
//	public JSONObject getOffical() throws Exception {
//		
//		
//		try
//		{
//			String result = Tools.getHttpInfo(Constant.PREFECTURE_INFO_GET_URL);
//			if(StringUtil.isNullOrEmpty(result))
//				return null;
//			
//			return new JSONObject(result);
//		}
//		catch(Exception e)
//		{
//			GlobalObject.ERROR_LOG.error("at FeedHomeServiceImpl.getOffical throw an error.", e);
//			return null;
//		}
//	}
//
//	@Override
//	public JSONObject getSubjects() throws Exception {
//		try
//		{
//			String result = Tools.getHttpInfo(Constant.SUBJECT_INFO_GET_URL);
//			if(StringUtil.isNullOrEmpty(result))
//				return null;
//			
//			return new JSONObject(result);
//		}
//		catch(Exception e)
//		{
//			GlobalObject.ERROR_LOG.error("at FeedHomeServiceImpl.getSubjects throw an error.", e);
//			return null;
//		}
//	}
//
//}
