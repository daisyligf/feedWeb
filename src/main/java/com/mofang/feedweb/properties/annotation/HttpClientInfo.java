package com.mofang.feedweb.properties.annotation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.mofang.feedweb.global.Constant;

@Component
public class HttpClientInfo {
	@Value("#{configProperties['host']}")
	private String host;
	@Value("#{configProperties['port']}")
	private int port;
	@Value("#{configProperties['maxTotal']}")
	private int maxTotal;
	@Value("#{configProperties['charset']}")
	private String charset;
	@Value("#{configProperties['connTimeout']}")
	private int connTimeout;
	@Value("#{configProperties['socketTimeout']}")
	private int socketTimeout;
	@Value("#{configProperties['keepAliveTimeout']}")
	private int keepAliveTimeout;
	@Value("#{configProperties['checkIdleInitialDelay']}")
	private int checkIdleInitialDelay;
	@Value("#{configProperties['checkIdlePeriod']}")
	private int checkIdlePeriod;
	@Value("#{configProperties['closeIdleTimeout']}")
	private int closeIdleTimeout;

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public int getMaxTotal() {
		return maxTotal;
	}

	public void setMaxTotal(int maxTotal) {
		this.maxTotal = maxTotal;
	}

	public String getCharset() {
		return charset;
	}

	public void setCharset(String charset) {
		this.charset = charset;
	}

	public int getConnTimeout() {
		return connTimeout;
	}

	public void setConnTimeout(int connTimeout) {
		this.connTimeout = connTimeout;
	}

	public int getSocketTimeout() {
		return socketTimeout;
	}

	public void setSocketTimeout(int socketTimeout) {
		this.socketTimeout = socketTimeout;
	}

	public int getKeepAliveTimeout() {
		return keepAliveTimeout;
	}

	public void setKeepAliveTimeout(int keepAliveTimeout) {
		this.keepAliveTimeout = keepAliveTimeout;
	}

	public int getCheckIdleInitialDelay() {
		return checkIdleInitialDelay;
	}

	public void setCheckIdleInitialDelay(int checkIdleInitialDelay) {
		this.checkIdleInitialDelay = checkIdleInitialDelay;
	}

	public int getCheckIdlePeriod() {
		return checkIdlePeriod;
	}

	public void setCheckIdlePeriod(int checkIdlePeriod) {
		this.checkIdlePeriod = checkIdlePeriod;
	}

	public int getCloseIdleTimeout() {
		return closeIdleTimeout;
	}

	public void setCloseIdleTimeout(int closeIdleTimeout) {
		this.closeIdleTimeout = closeIdleTimeout;
	}
	
	

}
