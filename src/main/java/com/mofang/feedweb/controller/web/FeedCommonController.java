package com.mofang.feedweb.controller.web;


import javax.servlet.http.HttpServletRequest;

import org.apache.http.impl.client.CloseableHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import com.mofang.feedweb.component.HttpComponent;
import com.mofang.feedweb.form.FeedForumOfficalForm;
import com.mofang.feedweb.form.FeedHomeHotForumRankForm;
import com.mofang.feedweb.form.FeedHomeListHotForumForm;
import com.mofang.feedweb.form.FeedHomeListRecommendGameForm;
import com.mofang.feedweb.form.FeedHomeRecommendGameRankForm;
import com.mofang.feedweb.form.FeedHomeSubjectForm;
import com.mofang.feedweb.form.FeedHomeTickerForm;
import com.mofang.feedweb.global.Constant;
import com.mofang.feedweb.global.GlobalObject;
import com.mofang.feedweb.net.http.HttpClientConfig;
import com.mofang.feedweb.net.http.HttpClientProvider;
import com.mofang.feedweb.properties.annotation.ExternalUrlInfo;
import com.mofang.feedweb.properties.annotation.HttpClientInfo;
import com.mofang.feedweb.util.StringUtil;
import com.mofang.feedweb.util.Tools;


public class FeedCommonController {
	
	@Autowired
	private ExternalUrlInfo externalUrlInfo;
	
	@Autowired
	private HttpClientInfo connInfo;
	
	protected String getFeedUrlInfo() {
		return externalUrlInfo.getFeed_info_url();
	}
	
	protected String getGame_info_url() {
		return externalUrlInfo.getGame_info_url();
	}
	
	protected String getGift_info_url() {
		return externalUrlInfo.getGift_info_url();
	}
	
	protected String getImage_info_url() {
		return externalUrlInfo.getImage_info_url();
	}
	
	protected String getUser_LogOut_info_url() {
		return externalUrlInfo.getUser_info_url() + Constant.USER_LOGOUT_URL;
	}
	
	protected String getUser_LogIn_info_url() {
		return externalUrlInfo.getUser_info_url() + Constant.USER_LOGIN_URL;
	}
	
	protected String getUser_Update_State_url() {
		return externalUrlInfo.getUser_info_url() + Constant.USER_STATE_UPDATE_URL;
	}
	
	protected String getForumInfoGetUrl() {
		return externalUrlInfo.getFeed_info_url() + Constant.FORUM_INFO_GET_URL;
	}
	
	protected String getRoleInfoListGetUrl() {
		return externalUrlInfo.getFeed_info_url() + Constant.LIST_MODERATOR_GET_URL;
	}
	
	protected String getThreadListUrl() {
		return  externalUrlInfo.getFeed_info_url() + Constant.LIST_THREAD_GET_URL;
	}
	
	protected String getTopThreadsUrl() {
		return externalUrlInfo.getFeed_info_url() + Constant.SUBJECT_INFO_GET_URL;
	}
	
	protected String getRecommendGameRankUrl() {
		return externalUrlInfo.getFeed_info_url() + Constant.RECOMMEND_GAME_RANK_GET_URL;
	}
	
	protected String getGameInfoUrl() {
		return externalUrlInfo.getGame_info_url() + Constant.GAME_INFO_URL;
	}
	
	protected String getGameGiftListUrl() {
		return externalUrlInfo.getGift_info_url() + Constant.GIFT_LIST_URL;
	}
	
	
	protected HttpClientProvider getHttpProvider() {
		HttpClientConfig config = new HttpClientConfig();
		config.setHost(connInfo.getHost());
		config.setPort(connInfo.getPort());
		config.setMaxTotal(connInfo.getMaxTotal());
		config.setCharset(connInfo.getCharset());
		config.setConnTimeout(connInfo.getConnTimeout());
		config.setSocketTimeout(connInfo.getSocketTimeout());
		config.setDefaultKeepAliveTimeout(connInfo.getKeepAliveTimeout());
		config.setCheckIdleInitialDelay(connInfo.getCheckIdleInitialDelay());
		config.setCheckIdlePeriod(connInfo.getCheckIdlePeriod());
		config.setCloseIdleTimeout(connInfo.getCloseIdleTimeout());
		
		HttpClientProvider provider = new HttpClientProvider(config);
		return provider;
	}

	protected JSONObject getHttpInfo(String getUrl, String param,HttpServletRequest request) 
	{
        try
        {	String uid = "";
        	if (null != request.getSession().getAttribute(Constant.SESSION_USERID)) {
        		 uid = String.valueOf(request.getSession().getAttribute(Constant.SESSION_USERID));
        	}
        	StringBuffer strb = new StringBuffer();
        	strb.append(getUrl);
        	strb.append(Constant.STR_QUESTION_MARK);
        	strb.append(Tools.encodetoAtom(uid));
        	
    		if (!"".equals(param)) {
    		strb.append(Constant.STR_AND);
    		strb.append(param);
    		}
        	HttpComponent httpComp = new HttpComponent();
        	//String getHttpUrl = getUrl.concat(Constant.STR_QUESTION_MARK).concat(interfaceURL).concat( strb.toString());
    		CloseableHttpClient clientservice = getHttpProvider().getHttpClient();
    		String result = httpComp.get(clientservice, strb.toString());
    		if(StringUtil.isNullOrEmpty(result))
    			return null;
    		
    		return new JSONObject(result);
    		
        }
        catch(Exception e)
        {
        	GlobalObject.ERROR_LOG.error("FeedCommonController.getHttpInfo", e);
        	return null;
        }
	}
	
	protected JSONObject postHttpInfo(String postUrl,  JSONObject postData) 
	{
        try
        {
        	HttpComponent httpComp = new HttpComponent();
    		CloseableHttpClient clientservice = getHttpProvider().getHttpClient();
    		String result = httpComp.post(clientservice, postUrl, postData.toString());
    		if(StringUtil.isNullOrEmpty(result))
    			return null;
    		
    		return new JSONObject(result);
    		
        }
        catch(Exception e)
        {
        	GlobalObject.ERROR_LOG.error("FeedCommonController.postHttpInfo", e);
        	return null;
        }
	}
	
	protected FeedHomeTickerForm getHomeTickers(
			HttpServletRequest request) throws JSONException 
	{
		//海报
		JSONObject tickersResult = getHttpInfo(
				getFeedUrlInfo().concat(
						Constant.TICKER_INFO_GET_URL),"" , request);
		
		FeedHomeTickerForm tickerForm = new FeedHomeTickerForm();
		
		if (null != tickersResult) {
			
			int code = tickersResult.optInt("code", -1);
			if (0 != code) {
			} else {
				
				JSONArray data = tickersResult.optJSONArray("data");
				JSONObject jsonNewsPaper = null;
				for(int i=0; i<data.length(); i++)
				{
					jsonNewsPaper = data.getJSONObject(i);
					if (i == 0) {
						tickerForm.setTickerIcon1(jsonNewsPaper.optString("icon", ""));
						tickerForm.setThreadLink1(jsonNewsPaper.optString("link_url", ""));
					} else if (i == 1) {
						tickerForm.setTickerIcon2(jsonNewsPaper.optString("icon", ""));
						tickerForm.setThreadLink2(jsonNewsPaper.optString("link_url", ""));
					} else if (i == 2) {
						tickerForm.setTickerIcon3(jsonNewsPaper.optString("icon", ""));
						tickerForm.setThreadLink3(jsonNewsPaper.optString("link_url", ""));
					}
				}
			}	
			
		}
		
		return tickerForm;
		
	}
	
	protected FeedHomeSubjectForm getHomeSubjects(
			HttpServletRequest request) throws JSONException 
	{
		FeedHomeSubjectForm subjectForm = new FeedHomeSubjectForm();
		
		//大小标题
		JSONObject subjectResult = getHttpInfo(
				getFeedUrlInfo().concat(
						Constant.SUBJECT_INFO_GET_URL),"" , request);
		if (null != subjectResult) {
		
			int code = subjectResult.optInt("code", -1);
			
			if(0 != code) {
			} else {
				JSONArray data = subjectResult.optJSONArray("data");
				
				JSONObject jsonThreadsTitle = null;
				for(int i=0; i<data.length(); i++)
				{
					jsonThreadsTitle = data.getJSONObject(i);
					if (i == 0) {
						subjectForm.setThreadId1(jsonThreadsTitle.optLong("thread_id",0));
						subjectForm.setThreadName1(jsonThreadsTitle.optString("subject",""));
						subjectForm.setContent1(jsonThreadsTitle.optString("content",""));
						subjectForm.setLinkUrl1(jsonThreadsTitle.optString("link_url",""));
						subjectForm.setForumNmae1(jsonThreadsTitle.optString("forum_name",""));
					} else if (i == 1) {
						subjectForm.setThreadId2(jsonThreadsTitle.optLong("thread_id",0));
						subjectForm.setThreadName2(jsonThreadsTitle.optString("subject",""));
						subjectForm.setContent2(jsonThreadsTitle.optString("content",""));
						subjectForm.setLinkUrl2(jsonThreadsTitle.optString("link_url",""));
						subjectForm.setForumNmae2(jsonThreadsTitle.optString("forum_name",""));
					} else if (i == 2) {
						subjectForm.setThreadId3(jsonThreadsTitle.optLong("thread_id",0));
						subjectForm.setThreadName3(jsonThreadsTitle.optString("subject",""));
						subjectForm.setContent3(jsonThreadsTitle.optString("content",""));
						subjectForm.setLinkUrl3(jsonThreadsTitle.optString("link_url",""));
						subjectForm.setForumNmae3(jsonThreadsTitle.optString("forum_name",""));
					} else if (i == 3) {
						subjectForm.setThreadId4(jsonThreadsTitle.optLong("thread_id",0));
						subjectForm.setThreadName4(jsonThreadsTitle.optString("subject",""));
						subjectForm.setContent4(jsonThreadsTitle.optString("content",""));
						subjectForm.setLinkUrl4(jsonThreadsTitle.optString("link_url",""));
						subjectForm.setForumNmae4(jsonThreadsTitle.optString("forum_name",""));
					} else if (i == 4) {
						subjectForm.setThreadId5(jsonThreadsTitle.optLong("thread_id",0));
						subjectForm.setThreadName5(jsonThreadsTitle.optString("subject",""));
						subjectForm.setContent5(jsonThreadsTitle.optString("content",""));
						subjectForm.setLinkUrl5(jsonThreadsTitle.optString("link_url",""));
						subjectForm.setForumNmae5(jsonThreadsTitle.optString("forum_name",""));
					} else if (i == 5) {
						subjectForm.setThreadId6(jsonThreadsTitle.optLong("thread_id",0));
						subjectForm.setThreadName6(jsonThreadsTitle.optString("subject",""));
						subjectForm.setContent6(jsonThreadsTitle.optString("content",""));
						subjectForm.setLinkUrl6(jsonThreadsTitle.optString("link_url",""));
						subjectForm.setForumNmae6(jsonThreadsTitle.optString("forum_name",""));
					} else if (i == 6) {
						subjectForm.setThreadId7(jsonThreadsTitle.optLong("thread_id",0));
						subjectForm.setThreadName7(jsonThreadsTitle.optString("subject",""));
						subjectForm.setContent7(jsonThreadsTitle.optString("content",""));
						subjectForm.setLinkUrl7(jsonThreadsTitle.optString("link_url",""));
						subjectForm.setForumNmae7(jsonThreadsTitle.optString("forum_name",""));
					}
					
				}
				
			}
		}
		
		return subjectForm;
		
	}
	
	protected FeedHomeHotForumRankForm getHomeHotForumRank(
			HttpServletRequest request) throws JSONException 
	{
		
		
		FeedHomeHotForumRankForm objHotForumrank = new FeedHomeHotForumRankForm();
		//热门版块榜单
		JSONObject hotForumRankResult = getHttpInfo(
				getFeedUrlInfo().concat(
						Constant.HOT_FOURM_RANK_GET_URL),"" , request);
		if (null != hotForumRankResult) {
			
			int code = hotForumRankResult.optInt("code", -1);
			if(0 != code) {
			} else {
				
				JSONArray data = hotForumRankResult.optJSONArray("data");
				
				JSONObject jsonRank = null;
				for(int i=0; i<data.length(); i++)
				{
					jsonRank = data.getJSONObject(i);
					if (i == 0) {
						objHotForumrank.setForumId1(jsonRank.optLong("forum_id", 0));
						objHotForumrank.setForumName1(jsonRank.optString("forum_name", ""));
						objHotForumrank.setUpDown1(jsonRank.optInt("up_down", 0));
					} else if (i == 1) {
						objHotForumrank.setForumId1(jsonRank.optLong("forum_id", 0));
						objHotForumrank.setForumName1(jsonRank.optString("forum_name", ""));
						objHotForumrank.setUpDown1(jsonRank.optInt("up_down", 0));
					} else if (i == 2) {
						objHotForumrank.setForumId1(jsonRank.optLong("forum_id", 0));
						objHotForumrank.setForumName1(jsonRank.optString("forum_name", ""));
						objHotForumrank.setUpDown1(jsonRank.optInt("up_down", 0));
					} else if (i == 3) {
						objHotForumrank.setForumId1(jsonRank.optLong("forum_id", 0));
						objHotForumrank.setForumName1(jsonRank.optString("forum_name", ""));
						objHotForumrank.setUpDown1(jsonRank.optInt("up_down", 0));
					} else if (i == 4) {
						objHotForumrank.setForumId1(jsonRank.optLong("forum_id", 0));
						objHotForumrank.setForumName1(jsonRank.optString("forum_name", ""));
						objHotForumrank.setUpDown1(jsonRank.optInt("up_down", 0));
					}
				}
			}
			
		}
		return objHotForumrank;
		
	}
	
	protected FeedHomeRecommendGameRankForm getHomeRecommendRank(
			HttpServletRequest request) throws JSONException 
	{
		FeedHomeRecommendGameRankForm recommendRank = new FeedHomeRecommendGameRankForm();
		//新游推荐榜单
		JSONObject hotForumRankResult = getHttpInfo(
				getFeedUrlInfo().concat(
						Constant.RECOMMEND_GAME_RANK_GET_URL),"" , request);
		if (null != hotForumRankResult) {
			
			int code = hotForumRankResult.optInt("code", -1);
			if(0 != code) {
			} else {
			
				JSONArray data = hotForumRankResult.optJSONArray("data");
				
				JSONObject jsonRank = null;
				for(int i=0; i<data.length(); i++)
				{
					jsonRank = data.getJSONObject(i);
					if (i == 0) {
						recommendRank.setForumId1(jsonRank.optLong("forum_id", 0));
						recommendRank.setForumName1(jsonRank.optString("forum_name", ""));
						recommendRank.setIcon1(jsonRank.optString("icon", ""));
						recommendRank.setDownLoadUrl1(jsonRank.optString("download_url", ""));
						recommendRank.setGiftUrl1(jsonRank.optString("gift_url", ""));
					} else if (i == 1) {
						recommendRank.setForumId2(jsonRank.optLong("forum_id", 0));
						recommendRank.setForumName2(jsonRank.optString("forum_name", ""));
						recommendRank.setIcon2(jsonRank.optString("icon", ""));
						recommendRank.setDownLoadUrl2(jsonRank.optString("download_url", ""));
						recommendRank.setGiftUrl2(jsonRank.optString("gift_url", ""));
					} else if (i == 2) {
						recommendRank.setForumId3(jsonRank.optLong("forum_id", 0));
						recommendRank.setForumName3(jsonRank.optString("forum_name", ""));
						recommendRank.setIcon3(jsonRank.optString("icon", ""));
						recommendRank.setDownLoadUrl3(jsonRank.optString("download_url", ""));
						recommendRank.setGiftUrl3(jsonRank.optString("gift_url", ""));
					} else if (i == 3) {
						recommendRank.setForumId4(jsonRank.optLong("forum_id", 0));
						recommendRank.setForumName4(jsonRank.optString("forum_name", ""));
						recommendRank.setIcon4(jsonRank.optString("icon", ""));
						recommendRank.setDownLoadUrl4(jsonRank.optString("download_url", ""));
						recommendRank.setGiftUrl4(jsonRank.optString("gift_url", ""));
					} else if (i == 4) {
						recommendRank.setForumId5(jsonRank.optLong("forum_id", 0));
						recommendRank.setForumName5(jsonRank.optString("forum_name", ""));
						recommendRank.setIcon5(jsonRank.optString("icon", ""));
						recommendRank.setDownLoadUrl5(jsonRank.optString("download_url", ""));
						recommendRank.setGiftUrl5(jsonRank.optString("gift_url", ""));
					}
				}
			}
			
		}
		return recommendRank;
		
	}
	
	protected FeedHomeListHotForumForm getHomeListHotForum(HttpServletRequest request) throws JSONException 
	{
		FeedHomeListHotForumForm objHotGame = new FeedHomeListHotForumForm();
		//热门游戏版块list
		JSONObject listHotGameResult = getHttpInfo(
				getFeedUrlInfo().concat(
						Constant.LIST_HOT_FOURM_GET_URL),"" , request);
		if (null != listHotGameResult) {
			
			int code = listHotGameResult.optInt("code", -1);
			if(0 != code) {
			} else {
				
				JSONArray data = listHotGameResult.optJSONArray("data");
				JSONObject jsonHotGame = null;
				for(int i=0; i<data.length(); i++)
				{
					jsonHotGame = data.getJSONObject(i);
					if (i == 0) {
						objHotGame.setHotForumId1(jsonHotGame.optLong("forum_id", 0));
						objHotGame.setHotForumName1(jsonHotGame.optString("forum_name", ""));
						objHotGame.setHotIcon1(jsonHotGame.optString("icon", ""));
						objHotGame.setHotTodayThreads1(jsonHotGame.optInt("today_threads", 0));
						objHotGame.setHotTotalThreads1(jsonHotGame.optInt("total_threads",0));
						objHotGame.setHotPrefectureUrl1(jsonHotGame.optString("prefecture_url", ""));
						objHotGame.setHotGiftUrl1(jsonHotGame.optString("gift_url", ""));
					} else if (i == 1) {
						objHotGame.setHotForumId2(jsonHotGame.optLong("forum_id", 0));
						objHotGame.setHotForumName2(jsonHotGame.optString("forum_name", ""));
						objHotGame.setHotIcon2(jsonHotGame.optString("icon", ""));
						objHotGame.setHotTodayThreads2(jsonHotGame.optInt("today_threads", 0));
						objHotGame.setHotTotalThreads2(jsonHotGame.optInt("total_threads",0));
						objHotGame.setHotPrefectureUrl2(jsonHotGame.optString("prefecture_url", ""));
						objHotGame.setHotGiftUrl2(jsonHotGame.optString("gift_url", ""));
					} else if (i == 2) {
						objHotGame.setHotForumId3(jsonHotGame.optLong("forum_id", 0));
						objHotGame.setHotForumName3(jsonHotGame.optString("forum_name", ""));
						objHotGame.setHotIcon3(jsonHotGame.optString("icon", ""));
						objHotGame.setHotTodayThreads3(jsonHotGame.optInt("today_threads", 0));
						objHotGame.setHotTotalThreads3(jsonHotGame.optInt("total_threads",0));
						objHotGame.setHotPrefectureUrl3(jsonHotGame.optString("prefecture_url", ""));
						objHotGame.setHotGiftUrl3(jsonHotGame.optString("gift_url", ""));
					} else if (i == 3) {
						objHotGame.setHotForumId4(jsonHotGame.optLong("forum_id", 0));
						objHotGame.setHotForumName4(jsonHotGame.optString("forum_name", ""));
						objHotGame.setHotIcon4(jsonHotGame.optString("icon", ""));
						objHotGame.setHotTodayThreads4(jsonHotGame.optInt("today_threads", 0));
						objHotGame.setHotTotalThreads4(jsonHotGame.optInt("total_threads",0));
						objHotGame.setHotPrefectureUrl4(jsonHotGame.optString("prefecture_url", ""));
						objHotGame.setHotGiftUrl4(jsonHotGame.optString("gift_url", ""));
					} else if (i == 4) {
						objHotGame.setHotForumId5(jsonHotGame.optLong("forum_id", 0));
						objHotGame.setHotForumName5(jsonHotGame.optString("forum_name", ""));
						objHotGame.setHotIcon5(jsonHotGame.optString("icon", ""));
						objHotGame.setHotTodayThreads5(jsonHotGame.optInt("today_threads", 0));
						objHotGame.setHotTotalThreads5(jsonHotGame.optInt("total_threads",0));
						objHotGame.setHotPrefectureUrl5(jsonHotGame.optString("prefecture_url", ""));
						objHotGame.setHotGiftUrl5(jsonHotGame.optString("gift_url", ""));
					} else if (i == 5) {
						objHotGame.setHotForumId6(jsonHotGame.optLong("forum_id", 0));
						objHotGame.setHotForumName6(jsonHotGame.optString("forum_name", ""));
						objHotGame.setHotIcon6(jsonHotGame.optString("icon", ""));
						objHotGame.setHotTodayThreads6(jsonHotGame.optInt("today_threads", 0));
						objHotGame.setHotTotalThreads6(jsonHotGame.optInt("total_threads",0));
						objHotGame.setHotPrefectureUrl6(jsonHotGame.optString("prefecture_url", ""));
						objHotGame.setHotGiftUrl6(jsonHotGame.optString("gift_url", ""));
					} else if (i == 6) {
						objHotGame.setHotForumId7(jsonHotGame.optLong("forum_id", 0));
						objHotGame.setHotForumName7(jsonHotGame.optString("forum_name", ""));
						objHotGame.setHotIcon7(jsonHotGame.optString("icon", ""));
						objHotGame.setHotTodayThreads7(jsonHotGame.optInt("today_threads", 0));
						objHotGame.setHotTotalThreads7(jsonHotGame.optInt("total_threads",0));
						objHotGame.setHotPrefectureUrl7(jsonHotGame.optString("prefecture_url", ""));
						objHotGame.setHotGiftUrl7(jsonHotGame.optString("gift_url", ""));
					} else if (i == 7) {
						objHotGame.setHotForumId8(jsonHotGame.optLong("forum_id", 0));
						objHotGame.setHotForumName8(jsonHotGame.optString("forum_name", ""));
						objHotGame.setHotIcon8(jsonHotGame.optString("icon", ""));
						objHotGame.setHotTodayThreads8(jsonHotGame.optInt("today_threads", 0));
						objHotGame.setHotTotalThreads8(jsonHotGame.optInt("total_threads",0));
						objHotGame.setHotPrefectureUrl8(jsonHotGame.optString("prefecture_url", ""));
						objHotGame.setHotGiftUrl8(jsonHotGame.optString("gift_url", ""));
					}
				}
				
			}
		}
		return objHotGame;
		
	}
	
	protected FeedHomeListRecommendGameForm getHomeListRecommendForum(HttpServletRequest request) throws JSONException 
	{
		FeedHomeListRecommendGameForm form = new FeedHomeListRecommendGameForm();
		JSONObject listRecommendGameResult = getHttpInfo(
				getFeedUrlInfo().concat(
						Constant.LIST_RECOMMENDGAME_GET_URL),"" , request);
		if (null != listRecommendGameResult) {
			
			int code = listRecommendGameResult.optInt("code", -1);
			if(0 != code) {
			} else {
				
				JSONArray data = listRecommendGameResult.optJSONArray("data");
				JSONObject jsonGame = null;
				for(int i=0; i<data.length(); i++)
				{
					jsonGame = data.getJSONObject(i);
					if (i == 0) {
						form.setForumId1(jsonGame.optLong("forum_id", 0));
						form.setForumName1(jsonGame.optString("forum_name", ""));
						form.setIcon1(jsonGame.optString("icon", ""));
						form.setTodayThreads1(jsonGame.optInt("today_threads", 0));
						form.setTotalThreads1(jsonGame.optInt("total_threads", 0));
						form.setDownloadUrl1(jsonGame.optString("download_url", ""));
						form.setGiftUrl1(jsonGame.optString("gift_url", ""));
					} else if (i == 1) {
						form.setForumId2(jsonGame.optLong("forum_id", 0));
						form.setForumName2(jsonGame.optString("forum_name", ""));
						form.setIcon2(jsonGame.optString("icon", ""));
						form.setTodayThreads2(jsonGame.optInt("today_threads", 0));
						form.setTotalThreads2(jsonGame.optInt("total_threads", 0));
						form.setDownloadUrl2(jsonGame.optString("download_url", ""));
						form.setGiftUrl2(jsonGame.optString("gift_url", ""));
					} else if (i == 2) {
						form.setForumId3(jsonGame.optLong("forum_id", 0));
						form.setForumName3(jsonGame.optString("forum_name", ""));
						form.setIcon3(jsonGame.optString("icon", ""));
						form.setTodayThreads3(jsonGame.optInt("today_threads", 0));
						form.setTotalThreads3(jsonGame.optInt("total_threads", 0));
						form.setDownloadUrl3(jsonGame.optString("download_url", ""));
						form.setGiftUrl3(jsonGame.optString("gift_url", ""));
					} else if (i == 3) {
						form.setForumId4(jsonGame.optLong("forum_id", 0));
						form.setForumName4(jsonGame.optString("forum_name", ""));
						form.setIcon4(jsonGame.optString("icon", ""));
						form.setTodayThreads4(jsonGame.optInt("today_threads", 0));
						form.setTotalThreads4(jsonGame.optInt("total_threads", 0));
						form.setDownloadUrl4(jsonGame.optString("download_url", ""));
						form.setGiftUrl4(jsonGame.optString("gift_url", ""));
					} else if (i == 4) {
						form.setForumId5(jsonGame.optLong("forum_id", 0));
						form.setForumName5(jsonGame.optString("forum_name", ""));
						form.setIcon5(jsonGame.optString("icon", ""));
						form.setTodayThreads5(jsonGame.optInt("today_threads", 0));
						form.setTotalThreads5(jsonGame.optInt("total_threads", 0));
						form.setDownloadUrl5(jsonGame.optString("download_url", ""));
						form.setGiftUrl5(jsonGame.optString("gift_url", ""));
					} else if (i == 5) {
						form.setForumId6(jsonGame.optLong("forum_id", 0));
						form.setForumName6(jsonGame.optString("forum_name", ""));
						form.setIcon6(jsonGame.optString("icon", ""));
						form.setTodayThreads6(jsonGame.optInt("today_threads", 0));
						form.setTotalThreads6(jsonGame.optInt("total_threads", 0));
						form.setDownloadUrl6(jsonGame.optString("download_url", ""));
						form.setGiftUrl6(jsonGame.optString("gift_url", ""));
					} else if (i == 6) {
						form.setForumId7(jsonGame.optLong("forum_id", 0));
						form.setForumName7(jsonGame.optString("forum_name", ""));
						form.setIcon7(jsonGame.optString("icon", ""));
						form.setTodayThreads7(jsonGame.optInt("today_threads", 0));
						form.setTotalThreads7(jsonGame.optInt("total_threads", 0));
						form.setDownloadUrl7(jsonGame.optString("download_url", ""));
						form.setGiftUrl7(jsonGame.optString("gift_url", ""));
					} else if (i == 7) {
						form.setForumId8(jsonGame.optLong("forum_id", 0));
						form.setForumName8(jsonGame.optString("forum_name", ""));
						form.setIcon8(jsonGame.optString("icon", ""));
						form.setTodayThreads8(jsonGame.optInt("today_threads", 0));
						form.setTotalThreads8(jsonGame.optInt("total_threads", 0));
						form.setDownloadUrl8(jsonGame.optString("download_url", ""));
						form.setGiftUrl8(jsonGame.optString("gift_url", ""));
					}
				}
			}
			
		} 
		return form;
		
	}
	
	protected FeedForumOfficalForm getHomeOfficalForum(HttpServletRequest request) throws JSONException 
	{
		FeedForumOfficalForm form = new FeedForumOfficalForm();
		//官方版块
		JSONObject officalResult = getHttpInfo(
				getFeedUrlInfo().concat(
						Constant.PREFECTURE_INFO_GET_URL),"" , request);
		if (null != officalResult) {
			
			int code = officalResult.optInt("code", -1);
			if(0 != code) {
			} else {
				
				JSONArray data = officalResult.optJSONArray("data");
				JSONObject json = null;
				for(int i=0; i<data.length(); i++)
				{
					json = data.getJSONObject(i);
					if (i == 0) {
						form.setForumId1(json.optLong("forum_id", 0));
						form.setForumName1(json.optString("forum_name", ""));
						form.setIcon1(json.optString("icon", ""));
						form.setTodayThreads1(json.optInt("today_threads", 0));
						form.setTotalThreads1(json.optInt("total_threads", 0));
					} else if (i == 1) {
						form.setForumId2(json.optLong("forum_id", 0));
						form.setForumName2(json.optString("forum_name", ""));
						form.setIcon2(json.optString("icon", ""));
						form.setTodayThreads2(json.optInt("today_threads", 0));
						form.setTotalThreads2(json.optInt("total_threads", 0));
					} else if (i == 2) {
						form.setForumId3(json.optLong("forum_id", 0));
						form.setForumName3(json.optString("forum_name", ""));
						form.setIcon3(json.optString("icon", ""));
						form.setTodayThreads3(json.optInt("today_threads", 0));
						form.setTotalThreads3(json.optInt("total_threads", 0));
					} else if (i == 3) {
						form.setForumId4(json.optLong("forum_id", 0));
						form.setForumName4(json.optString("forum_name", ""));
						form.setIcon4(json.optString("icon", ""));
						form.setTodayThreads4(json.optInt("today_threads", 0));
						form.setTotalThreads4(json.optInt("total_threads", 0));
					}
					
				}
				
			}
			
		}
		return form;
		
	}
}
