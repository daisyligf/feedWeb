package com.mofang.feedweb.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class UserHttpClientInfo{
	@Value("#{configProperties['user.host']}")
	private String host;
	@Value("#{configProperties['user.port']}")
	private int port;
	@Value("#{configProperties['user.maxTotal']}")
	private int maxTotal;
	@Value("#{configProperties['user.charset']}")
	private String charset;
	@Value("#{configProperties['user.connTimeout']}")
	private int connTimeout;
	@Value("#{configProperties['user.socketTimeout']}")
	private int socketTimeout;
	@Value("#{configProperties['user.keepAliveTimeout']}")
	private int keepAliveTimeout;
	@Value("#{configProperties['user.checkIdleInitialDelay']}")
	private int checkIdleInitialDelay;
	@Value("#{configProperties['user.checkIdlePeriod']}")
	private int checkIdlePeriod;
	@Value("#{configProperties['user.closeIdleTimeout']}")
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
