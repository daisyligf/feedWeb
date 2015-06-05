package com.mofang.feedweb.component;

import javax.annotation.PostConstruct;

import org.apache.http.impl.client.CloseableHttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mofang.feedweb.global.GlobalObject;
import com.mofang.feedweb.net.http.HttpClientConfig;
import com.mofang.feedweb.net.http.HttpClientProvider;
import com.mofang.feedweb.net.http.HttpClientSender;
import com.mofang.feedweb.properties.annotation.HttpClientInfo;

@Component
public class HttpComponent {

	@Autowired
	private HttpClientInfo connInfo;

	private CloseableHttpClient feedHttpClient;

	@PostConstruct
	public void init(){
		feedHttpClient = getHttpProvider().getHttpClient();
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

	public String get(CloseableHttpClient httpClient, String requestUrl) {
		StringBuilder strLog = new StringBuilder();
		strLog.append("request url: " + requestUrl + " ");
		try {
			String result = HttpClientSender.get(httpClient, requestUrl);
			strLog.append("response data: " + ((null == result) ? "" : result)
					+ " ");
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public String post(CloseableHttpClient httpClient, String requestUrl,
			String postData) {
		StringBuilder strLog = new StringBuilder();
		strLog.append("request url: " + requestUrl + " ");
		strLog.append("request data: " + postData + " ");
		try {
			String result = HttpClientSender.post(httpClient, requestUrl,
					postData);
			strLog.append("response data: " + ((null == result) ? "" : result)
					+ " ");
			return result;
		} catch (Exception e) {
			GlobalObject.ERROR_LOG.error(strLog.toString(), e);
			return null;
		}
	}

}