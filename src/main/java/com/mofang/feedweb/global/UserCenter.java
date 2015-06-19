package com.mofang.feedweb.global;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 
 * @author daisyli 
 *
 */
@Component
public class UserCenter {

	@Value("${usercenter_url}")
	private String userCenterUrl;
	
	public static String baseUrl;
	
	@PostConstruct
	public void init() {
		UserCenter.baseUrl = userCenterUrl;
	}
	
}