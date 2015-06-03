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
	
	protected String getForumFollowUrl() {
		return externalUrlInfo.getUser_info_url() + Constant.FORUM_FOLLOW_URL;
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
	
}
