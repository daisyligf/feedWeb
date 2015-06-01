package com.mofang.feedweb.component;

import org.apache.http.impl.client.CloseableHttpClient;

import com.mofang.feedweb.global.GlobalObject;
import com.mofang.feedweb.net.http.HttpClientSender;




/**
 * 
 * @author zhaodx
 *
 */
public class HttpComponent
{
	public String get(CloseableHttpClient httpClient, String requestUrl)
	{
		StringBuilder strLog = new StringBuilder();
		strLog.append("request url: " + requestUrl + " ");
		try
		{
			String result = HttpClientSender.get(httpClient, requestUrl);
			strLog.append("response data: " + ((null == result) ? "" : result) + " ");
			return result;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	
	public String post(CloseableHttpClient httpClient, String requestUrl, String postData)
	{
		StringBuilder strLog = new StringBuilder();
		strLog.append("request url: " + requestUrl + " ");
		strLog.append("request data: " + postData + " ");
		try
		{
			String result = HttpClientSender.post(httpClient, requestUrl, postData);
			strLog.append("response data: " + ((null == result) ? "" : result) + " ");
			return result;
		}
		catch(Exception e)
		{
			GlobalObject.ERROR_LOG.error(strLog.toString(), e);
			return null;
		}
	}
}