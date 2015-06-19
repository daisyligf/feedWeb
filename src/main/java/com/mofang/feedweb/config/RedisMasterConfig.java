package com.mofang.feedweb.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class RedisMasterConfig {
	@Value("#{configProperties['master.host']}")
	private String host;
	@Value("#{configProperties['master.port']}")
	private String port;
	@Value("#{configProperties['master.timeout']}")
	private String timeout;
	@Value("#{configProperties['master.maxActive']}")
	private String maxActive;
	@Value("#{configProperties['master.maxIdle']}")
	private String maxIdle;
	@Value("#{configProperties['master.testOnBorrow']}")
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
