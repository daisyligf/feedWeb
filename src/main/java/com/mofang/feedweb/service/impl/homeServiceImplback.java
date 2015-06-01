//package com.mofang.feedweb.service.impl;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.json.JSONArray;
//import org.json.JSONObject;
//
//import com.mofang.feedweb.component.HttpComponent;
//import com.mofang.feedweb.entity.gameRecommendRank;
//import com.mofang.feedweb.entity.hotForumRank;
//import com.mofang.feedweb.entity.hotGame;
//import com.mofang.feedweb.entity.newsPaper;
//import com.mofang.feedweb.entity.prefecture;
//import com.mofang.feedweb.entity.recommendGame;
//import com.mofang.feedweb.entity.threadsTitle;
//import com.mofang.feedweb.global.Constant;
//import com.mofang.feedweb.global.GlobalConfig;
//import com.mofang.feedweb.global.GlobalObject;
//import com.mofang.feedweb.service.homeService;
//import com.mofang.framework.util.StringUtil;
//
//public class homeServiceImplback implements homeService{
//
//	HttpComponent httpComp = new HttpComponent();
//	
//	@Override
//	public List<newsPaper> getNewsPaper() throws Exception {
//		
//		String requestUrl = GlobalConfig.FEED_INFO_URL + Constant.HOME_NEWSPAPER_URL;
//		String result = httpComp.get(GlobalObject.HTTP_CLIENT_FEEDSERVICE, requestUrl);
//		if(StringUtil.isNullOrEmpty(result))
//			return null;
//		
//		try
//		{
//			JSONObject json = new JSONObject(result);
//			int code = json.optInt("code", -1);
//			if(0 != code)
//				return null;
//			
//			JSONArray data = json.optJSONArray("data");
//			if(null == data)
//				return null;
//			
//			List<newsPaper> listNewsPaper = new ArrayList<newsPaper>();
//			newsPaper objNewsPaper = null;
//			JSONObject jsonNewsPaper = null;
//			for(int i=0; i<data.length(); i++)
//			{
//				jsonNewsPaper = data.getJSONObject(i);
//				objNewsPaper = new newsPaper();
//				objNewsPaper.setIcon(jsonNewsPaper.optString("icon", ""));
//				objNewsPaper.setLink_url(jsonNewsPaper.optString("link_url", ""));
//				listNewsPaper.add(objNewsPaper);
//			}
//			return listNewsPaper;
//		}
//		catch(Exception e)
//		{
//			GlobalObject.ERROR_LOG.error("at homeServiceImpl.getNewsPaper throw an error.", e);
//			return null;
//		}
//	}
//
//	@Override
//	public List<threadsTitle> getThreadsTitle() throws Exception {
//		
//		String requestUrl = GlobalConfig.FEED_INFO_URL + Constant.HOME_THREADS_URL;
//		String result = httpComp.get(GlobalObject.HTTP_CLIENT_FEEDSERVICE, requestUrl);
//		if(StringUtil.isNullOrEmpty(result))
//			return null;
//		
//		try
//		{
//			JSONObject json = new JSONObject(result);
//			int code = json.optInt("code", -1);
//			if(0 != code)
//				return null;
//			
//			JSONArray data = json.optJSONArray("data");
//			if(null == data)
//				return null;
//			
//			
//			List<threadsTitle> listThreadsTitle = new ArrayList<threadsTitle>();
//			threadsTitle objThreadsTitle = null;
//			JSONObject jsonThreadsTitle = null;
//			for(int i=0; i<data.length(); i++)
//			{
//				jsonThreadsTitle = data.getJSONObject(i);
//				objThreadsTitle = new threadsTitle();
//				objThreadsTitle.setContent(jsonThreadsTitle.optString("icon", ""));
//				objThreadsTitle.setDisplay_order(jsonThreadsTitle.optInt("display_order",1));
//				objThreadsTitle.setForum_name(jsonThreadsTitle.optString("forum_name", ""));
//				objThreadsTitle.setLink_url(jsonThreadsTitle.optString("link_url", ""));
//				objThreadsTitle.setThread_id(jsonThreadsTitle.optInt("thread_id",0));
//				objThreadsTitle.setThread_name(jsonThreadsTitle.optString("thread_name", ""));
//				listThreadsTitle.add(objThreadsTitle);
//			}
//			return listThreadsTitle;
//		}
//		catch(Exception e)
//		{
//			GlobalObject.ERROR_LOG.error("at homeServiceImpl.getThreadsTitle throw an error.", e);
//			return null;
//		}
//	}
//
//	@Override
//	public List<hotForumRank> getHotForumRank() throws Exception {
//		String requestUrl = GlobalConfig.FEED_INFO_URL + Constant.HOME_HOTFORUMRANK_URL;
//		String result = httpComp.get(GlobalObject.HTTP_CLIENT_FEEDSERVICE, requestUrl);
//		if(StringUtil.isNullOrEmpty(result))
//			return null;
//		
//		try
//		{
//			JSONObject json = new JSONObject(result);
//			int code = json.optInt("code", -1);
//			if(0 != code)
//				return null;
//			
//			JSONArray data = json.optJSONArray("data");
//			if(null == data)
//				return null;
//			
//			
//			List<hotForumRank> listHotForumRank = new ArrayList<hotForumRank>();
//			hotForumRank objHotForumrank = null;
//			JSONObject jsonHotForumrank = null;
//			for(int i=0; i<data.length(); i++)
//			{
//				jsonHotForumrank = data.getJSONObject(i);
//				objHotForumrank = new hotForumRank();
//				objHotForumrank.setForum_id(jsonHotForumrank.optLong("forum_id", 0));
//				objHotForumrank.setForum_name(jsonHotForumrank.optString("forum_name", ""));
//				objHotForumrank.setLink_url(jsonHotForumrank.optString("link_url", ""));
//				objHotForumrank.setUp_down(jsonHotForumrank.optInt("up_down", 0));
//				listHotForumRank.add(objHotForumrank);
//			}
//			return listHotForumRank;
//		}
//		catch(Exception e)
//		{
//			GlobalObject.ERROR_LOG.error("at homeServiceImpl.getHotForumRank throw an error.", e);
//			return null;
//		}
//	}
//
//	@Override
//	public List<gameRecommendRank> getGameRecommendRank() throws Exception {
//		String requestUrl = GlobalConfig.FEED_INFO_URL + Constant.HOME_GAMERECOMMENDRANK_URL;
//		String result = httpComp.get(GlobalObject.HTTP_CLIENT_FEEDSERVICE, requestUrl);
//		if(StringUtil.isNullOrEmpty(result))
//			return null;
//		
//		try
//		{
//			JSONObject json = new JSONObject(result);
//			int code = json.optInt("code", -1);
//			if(0 != code)
//				return null;
//			
//			
//			JSONArray data = json.optJSONArray("data");
//			if(null == data)
//				return null;
//			
//			
//			List<gameRecommendRank> listGameRecommendRank = new ArrayList<gameRecommendRank>();
//			gameRecommendRank objGameRecommendRank = null;
//			JSONObject jsonGameRecommendRank = null;
//			for(int i=0; i<data.length(); i++)
//			{
//				jsonGameRecommendRank = data.getJSONObject(i);
//				objGameRecommendRank = new gameRecommendRank();
//				objGameRecommendRank.setForum_id(jsonGameRecommendRank.optLong("forum_id", 0));
//				objGameRecommendRank.setForum_name(jsonGameRecommendRank.optString("forum_name", ""));
//				objGameRecommendRank.setLink_url(jsonGameRecommendRank.optString("link_url", ""));
//				objGameRecommendRank.setDownLoad_url(jsonGameRecommendRank.optString("downLoad_url", ""));
//				objGameRecommendRank.setGift_url(jsonGameRecommendRank.optString("gift_url", ""));
//				listGameRecommendRank.add(objGameRecommendRank);
//			}
//			return listGameRecommendRank;
//		}
//		catch(Exception e)
//		{
//			GlobalObject.ERROR_LOG.error("at homeServiceImpl.getGameRecommendRank throw an error.", e);
//			return null;
//		}
//	}
//
//	@Override
//	public List<hotGame> getHotGame() throws Exception {
//		String requestUrl = GlobalConfig.FEED_INFO_URL + Constant.HOME_HOTGAME_URL;
//		String result = httpComp.get(GlobalObject.HTTP_CLIENT_FEEDSERVICE, requestUrl);
//		if(StringUtil.isNullOrEmpty(result))
//			return null;
//		
//		try
//		{
//			JSONObject json = new JSONObject(result);
//			int code = json.optInt("code", -1);
//			if(0 != code)
//				return null;
//			
//			JSONArray data = json.optJSONArray("data");
//			if(null == data)
//				return null;
//			
//			
//			List<hotGame> listHotGame = new ArrayList<hotGame>();
//			hotGame objHotGame = null;
//			JSONObject jsonHotGame = null;
//			for(int i=0; i<data.length(); i++)
//			{
//				jsonHotGame = data.getJSONObject(i);
//				objHotGame = new hotGame();
//				objHotGame.setForum_id(jsonHotGame.optLong("forum_id", 0));
//				objHotGame.setForum_name(jsonHotGame.optString("forum_name", ""));
//				objHotGame.setForum_url(jsonHotGame.optString("forum_url", ""));
//				objHotGame.setGift_url(jsonHotGame.optString("gift_url", ""));
//				objHotGame.setIcon(jsonHotGame.optString("icon", ""));
//				objHotGame.setPrefecture_url(jsonHotGame.optString("prefecture_url", ""));
//				objHotGame.setToday_threads(jsonHotGame.optInt("today_threads", 0));
//				objHotGame.setTotal_threads(jsonHotGame.optInt("total_threads", 0));
//				listHotGame.add(objHotGame);
//			}
//			return listHotGame;
//		}
//		catch(Exception e)
//		{
//			GlobalObject.ERROR_LOG.error("at homeServiceImpl.getHotGame throw an error.", e);
//			return null;
//		}
//	}
//
//	@Override
//	public List<recommendGame> getRecommendGame() throws Exception {
//		String requestUrl = GlobalConfig.FEED_INFO_URL + Constant.HOME_RECOMMENDGAME_URL;
//		String result = httpComp.get(GlobalObject.HTTP_CLIENT_FEEDSERVICE, requestUrl);
//		if(StringUtil.isNullOrEmpty(result))
//			return null;
//		
//		try
//		{
//			JSONObject json = new JSONObject(result);
//			int code = json.optInt("code", -1);
//			if(0 != code)
//				return null;
//			
//			JSONArray data = json.optJSONArray("data");
//			if(null == data)
//				return null;
//			
//			
//			List<recommendGame> listRecommendGame = new ArrayList<recommendGame>();
//			recommendGame objRecommendGame = null;
//			JSONObject jsonRecommendGame = null;
//			for(int i=0; i<data.length(); i++)
//			{
//				jsonRecommendGame = data.getJSONObject(i);
//				objRecommendGame = new recommendGame();
//				objRecommendGame.setForum_id(jsonRecommendGame.optLong("forum_id", 0));
//				objRecommendGame.setForum_name(jsonRecommendGame.optString("forum_name", ""));
//				objRecommendGame.setForum_url(jsonRecommendGame.optString("forum_url", ""));
//				objRecommendGame.setGift_url(jsonRecommendGame.optString("gift_url", ""));
//				objRecommendGame.setIcon(jsonRecommendGame.optString("icon", ""));
//				objRecommendGame.setDownload_url(jsonRecommendGame.optString("download_url", ""));
//				objRecommendGame.setToday_threads(jsonRecommendGame.optInt("today_threads", 0));
//				objRecommendGame.setTotal_threads(jsonRecommendGame.optInt("total_threads", 0));
//				listRecommendGame.add(objRecommendGame);
//			}
//			return listRecommendGame;
//		}
//		catch(Exception e)
//		{
//			GlobalObject.ERROR_LOG.error("at homeServiceImpl.getRecommendGame throw an error.", e);
//			return null;
//		}
//	}
//
//	@Override
//	public List<prefecture> getPrefecture() throws Exception {
//		String requestUrl = GlobalConfig.FEED_INFO_URL + Constant.HOME_PREFECTURE_URL;
//		String result = httpComp.get(GlobalObject.HTTP_CLIENT_FEEDSERVICE, requestUrl);
//		if(StringUtil.isNullOrEmpty(result))
//			return null;
//		
//		try
//		{
//			JSONObject json = new JSONObject(result);
//			int code = json.optInt("code", -1);
//			if(0 != code)
//				return null;
//			
//			JSONArray data = json.optJSONArray("data");
//			if(null == data)
//				return null;
//			
//			
//			List<prefecture> listPrefecture = new ArrayList<prefecture>();
//			prefecture objPrefecture = null;
//			JSONObject jsonPrefecture = null;
//			for(int i=0; i<data.length(); i++)
//			{
//				jsonPrefecture = data.getJSONObject(i);
//				objPrefecture = new prefecture();
//				objPrefecture.setForum_id(jsonPrefecture.optLong("forum_id", 0));
//				objPrefecture.setForum_name(jsonPrefecture.optString("forum_name", ""));
//				objPrefecture.setIcon(jsonPrefecture.optString("icon", ""));
//				objPrefecture.setToday_threads(jsonPrefecture.optInt("today_threads", 0));
//				objPrefecture.setTotal_threads(jsonPrefecture.optInt("total_threads", 0));
//				listPrefecture.add(objPrefecture);
//			}
//			return listPrefecture;
//		}
//		catch(Exception e)
//		{
//			GlobalObject.ERROR_LOG.error("at homeServiceImpl.getPrefecture throw an error.", e);
//			return null;
//		}
//	}
//
//	@Override
//	public JSONObject getAdminThreadList() throws Exception {
//		String feed_info_url = "http://192.168.102.228:8099";
//		String requestObj = "backend/thread/getThreads?atom=880650&fid=185";
//		String requestUrl = feed_info_url + requestObj;
//		String configPath = "/Developer/workmofang/mofang.feed.web/src/main/resources/http_client_feedservice.properties";
//		GlobalObject.initFeedServiceHttpClient(configPath);
//		String result = httpComp.get(GlobalObject.HTTP_CLIENT_FEEDSERVICE, requestUrl);
//		if(StringUtil.isNullOrEmpty(result))
//			return null;
//		
//		try
//		{
//			JSONObject json = new JSONObject(result);
//			int code = json.optInt("code", -1);
//			if(0 != code)
//				return null;
//			
//			JSONArray data = json.optJSONArray("data");
//			if(null == data)
//				return null;
//			
//			return json;
//		}
//		catch(Exception e)
//		{
//			GlobalObject.ERROR_LOG.error("at homeServiceImpl.getPrefecture throw an error.", e);
//			return null;
//		}
//	}
//
//}
