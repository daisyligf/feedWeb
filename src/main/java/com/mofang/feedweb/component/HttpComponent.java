package com.mofang.feedweb.component;

import javax.annotation.PostConstruct;
import org.apache.http.impl.client.CloseableHttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.mofang.feedweb.global.GlobalObject;
import com.mofang.feedweb.net.http.HttpClientConfig;
import com.mofang.feedweb.net.http.HttpClientProvider;
import com.mofang.feedweb.net.http.HttpClientSender;
import com.mofang.feedweb.properties.annotation.AbstractHttpClientInfo;
import com.mofang.feedweb.properties.annotation.FeedHttpClientInfo;
import com.mofang.feedweb.properties.annotation.UserHttpClientInfo;

@Component
public class HttpComponent {

	@Autowired
	private FeedHttpClientInfo feedHttClientInfo;
	@Autowired
	private UserHttpClientInfo userHttpClientInfo;

	private CloseableHttpClient feedHttpClient;
	
	private CloseableHttpClient userHttpClient;

	@PostConstruct
	public void init() {
		feedHttpClient = getHttpProvider(feedHttClientInfo).getHttpClient();
		userHttpClient = getHttpProvider(userHttpClientInfo).getHttpClient();
	}

	protected HttpClientProvider getHttpProvider(AbstractHttpClientInfo clientInfo) {
		HttpClientConfig config = new HttpClientConfig();
		config.setHost(clientInfo.getHost());
		config.setPort(clientInfo.getPort());
		config.setMaxTotal(clientInfo.getMaxTotal());
		config.setCharset(clientInfo.getCharset());
		config.setConnTimeout(clientInfo.getConnTimeout());
		config.setSocketTimeout(clientInfo.getSocketTimeout());
		config.setDefaultKeepAliveTimeout(clientInfo
				.getKeepAliveTimeout());
		config.setCheckIdleInitialDelay(clientInfo
				.getCheckIdleInitialDelay());
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

}