package com.mofang.feedweb.component;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

import org.apache.http.impl.client.CloseableHttpClient;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mofang.feedweb.config.AbstractHttpClientInfo;
import com.mofang.feedweb.config.FeedHttpClientInfo;
import com.mofang.feedweb.config.UserHttpClientInfo;
import com.mofang.feedweb.entity.UserInfo;
import com.mofang.feedweb.global.GlobalObject;
import com.mofang.feedweb.http.HttpClientConfig;
import com.mofang.feedweb.http.HttpClientProvider;
import com.mofang.feedweb.http.HttpClientSender;
import com.mofang.feedweb.util.StringUtil;
import com.mofang.feedweb.util.Tools;

@Component
public class HttpComponent {

	@Autowired
	private FeedHttpClientInfo feedHttClientInfo;
	@Autowired
	private UserHttpClientInfo userHttpClientInfo;
	@Autowired
	private UserComponent userComp;

	private CloseableHttpClient feedHttpClient;

	private CloseableHttpClient userHttpClient;

	@PostConstruct
	public void init() {
		feedHttpClient = getHttpProvider(feedHttClientInfo).getHttpClient();
		userHttpClient = getHttpProvider(userHttpClientInfo).getHttpClient();
	}

	protected HttpClientProvider getHttpProvider(
			AbstractHttpClientInfo clientInfo) {
		HttpClientConfig config = new HttpClientConfig();
		config.setHost(clientInfo.getHost());
		config.setPort(clientInfo.getPort());
		config.setMaxTotal(clientInfo.getMaxTotal());
		config.setCharset(clientInfo.getCharset());
		config.setConnTimeout(clientInfo.getConnTimeout());
		config.setSocketTimeout(clientInfo.getSocketTimeout());
		config.setDefaultKeepAliveTimeout(clientInfo.getKeepAliveTimeout());
		config.setCheckIdleInitialDelay(clientInfo.getCheckIdleInitialDelay());
		config.setCheckIdlePeriod(clientInfo.getCheckIdlePeriod());
		config.setCloseIdleTimeout(clientInfo.getCloseIdleTimeout());
		HttpClientProvider provider = new HttpClientProvider(config);
		return provider;
	}

	public String get(String requestUrl) {
		StringBuilder strLog = new StringBuilder();
		strLog.append("request url: " + requestUrl + " ");
		try {
			String result = HttpClientSender.get(feedHttpClient, requestUrl);
			strLog.append("response data: " + ((null == result) ? "" : result)
					+ " ");
			GlobalObject.INFO_LOG.info(strLog.toString());
			return result;
		} catch (Exception e) {
			GlobalObject.ERROR_LOG.error(strLog.toString(), e);
			return null;
		}
	}

	public String post(String requestUrl, String postData) {
		StringBuilder strLog = new StringBuilder();
		strLog.append("request url: " + requestUrl + " ");
		strLog.append("request data: " + postData + " ");
		try {
			String result = HttpClientSender.post(feedHttpClient, requestUrl,
					postData);
			strLog.append("response data: " + ((null == result) ? "" : result)
					+ " ");
			GlobalObject.INFO_LOG.info(strLog.toString());
			return result;
		} catch (Exception e) {
			GlobalObject.ERROR_LOG.error(strLog.toString(), e);
			return null;
		}
	}

	public String getUser(String requestUrl) {
		StringBuilder strLog = new StringBuilder();
		strLog.append("request url: " + requestUrl + " ");
		try {
			String result = HttpClientSender.get(userHttpClient, requestUrl);
			strLog.append("response data: " + ((null == result) ? "" : result)
					+ " ");
			GlobalObject.INFO_LOG.info(strLog.toString());
			return result;
		} catch (Exception e) {
			GlobalObject.ERROR_LOG.error(strLog.toString(), e);
			return null;
		}
	}

	public JSONObject getHttpInfo(String getUrl, String param,
			HttpServletRequest request) {
		try {
			UserInfo userInfo = userComp.getUserInfo(request);
			StringBuffer strb = new StringBuffer();
			if (userInfo != null) {
				String atom = Tools.encodetoAtom(String.valueOf(userInfo
						.getUserId()));
				strb.append(getUrl).append("?").append(atom);
				if (!StringUtil.isNullOrEmpty(param)) {
					strb.append("&").append(param);
				}
			} else {
				strb.append(getUrl);
				if (!StringUtil.isNullOrEmpty(param)) {
					strb.append("?").append(param);
				}
			}
			String result = get(strb.toString());
			if (StringUtil.isNullOrEmpty(result))
				return null;
			return new JSONObject(result);
		} catch (Exception e) {
			GlobalObject.ERROR_LOG.error("FeedCommonController.getHttpInfo", e);
			return null;
		}
	}

	public JSONObject getHttpInfoWithoutAtom(String getUrl, String param) {
		try {
			StringBuffer strb = new StringBuffer();
			strb.append(getUrl);
			strb.append("?").append(param);
			String result = get(strb.toString());
			if (StringUtil.isNullOrEmpty(result))
				return null;
			return new JSONObject(result);
		} catch (Exception e) {
			GlobalObject.ERROR_LOG.error(
					"FeedCommonController.getHttpInfoWithoutAtom", e);
			return null;
		}
	}

	public JSONObject postHttpInfo(String postUrl, JSONObject postData,
			HttpServletRequest request) {
		try {
			UserInfo userInfo = userComp.getUserInfo(request);
			if (userInfo == null) {
				return null;
			}
			String userId = String.valueOf(userInfo.getUserId());
			String atom = Tools.encodetoAtom(userId);
			String result = post(postUrl + "?" + atom, postData.toString());
			if (StringUtil.isNullOrEmpty(result))
				return null;
			return new JSONObject(result);
		} catch (Exception e) {
			GlobalObject.ERROR_LOG
					.error("FeedCommonController.postHttpInfo", e);
			return null;
		}
	}

}