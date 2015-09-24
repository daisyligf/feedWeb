package com.mofang.feedweb.service.impl;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mofang.feedweb.component.HttpComponent;
import com.mofang.feedweb.component.UserComponent;
import com.mofang.feedweb.config.ExternalUrlInfo;
import com.mofang.feedweb.entity.UserInfo;
import com.mofang.feedweb.global.Constant;
import com.mofang.feedweb.global.GlobalObject;
import com.mofang.feedweb.service.FeedSignInService;

@Service("feedSignInService")
public class FeedSignInServiceImpl implements FeedSignInService{

	@Autowired
	private ExternalUrlInfo externalUrlInfo;
	@Autowired
	private HttpComponent httpComp;
	@Autowired
	private UserComponent userComp;
	
	@Override
	public JSONObject getSignInstate(HttpServletRequest request)
			throws Exception {
		try {
			UserInfo userinfo = userComp.getUserInfo(request);
			
			//游客
			String getUrl = Constant.GET_SIGNINSTOTALMEMBER_URL;
			if (null != userinfo && 0 != userinfo.getUserId()) {
				//登陆用户
				getUrl = Constant.GET_SIGNINSTATE_URL;
			}
			JSONObject result = httpComp.getHttpInfo(externalUrlInfo.getFeed_info_url()
					+ getUrl, "", request);
			
			if (result == null) {
				return new JSONObject();
			}
			return result;
		} catch (Exception e) {
			GlobalObject.ERROR_LOG.error("at FeedSignInServiceImpl.getSignInstate throw an error.", e);
			return null;
		}
				
		
	}

	@Override
	public JSONObject addSignIn(HttpServletRequest request)
			throws Exception {
		try {
			JSONObject result = httpComp.postHttpInfo(externalUrlInfo.getFeed_info_url()
					+ Constant.ADD_SIGNIN_URL, new JSONObject(), request);
			
			if (result == null) {
				return new JSONObject();
			}
			return result;
		} catch (Exception e) {
			GlobalObject.ERROR_LOG.error("at FeedSignInServiceImpl.addSignIn throw an error.", e);
			return null;
		}
	}

}
