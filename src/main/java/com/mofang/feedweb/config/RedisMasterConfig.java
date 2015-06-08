package com.mofang.feedweb.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class RedisMasterConfig {
	@Value("#{configProperties['host']}")
	private String host;
	@Value("#{configProperties['port']}")
	private String port;
	@Value("#{configProperties['timeout']}")
	private String timeout;
	@Value("#{configProperties['maxActive']}")
	private String maxActive;
	@Value("#{configProperties['maxIdle']}")
	private String maxIdle;
	@Value("#{configProperties['testOnBorrow']}")
	private String testOnBorrow;
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public String getPort() {
		return port;
	}
	public void setPort(String port) {
		this.port = port;
	}
	public String getTimeout() {
		return timeout;
	}
	public void setTimeout(String timeout) {
		this.timeout = timeout;
	}
	public String getMaxActive() {
		return maxActive;
	}
	public void setMaxActive(String maxActive) {
		this.maxActive = maxActive;
	}
	public String getMaxIdle() {
		return maxIdle;
	}
	public void setMaxIdle(String maxIdle) {
		this.maxIdle = maxIdle;
	}
	public String getTestOnBorrow() {
		return testOnBorrow;
	}
	public void setTestOnBorrow(String testOnBorrow) {
		this.testOnBorrow = testOnBorrow;
	}
	
	
}
