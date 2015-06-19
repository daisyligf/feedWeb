package com.mofang.feedweb.global;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 
 * @author ke 
 *
 */
@Component
public class CommonUrl {

	@Value("${mofang_home_url}")
	private String mofang_home_url;
	@Value("${bbs_home_url}")
	private String bbs_home_url;
	
	public static String mofangHomeUrl;
	public static String bbsHomeUrl;
	
	@PostConstruct
	public void init() {
		CommonUrl.mofangHomeUrl = mofang_home_url;
		CommonUrl.bbsHomeUrl = bbs_home_url;
	}
	
}
