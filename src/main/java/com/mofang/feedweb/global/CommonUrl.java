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
	@Value("${base_url}")
	private String base_url;
	@Value("${m_news_url}")
	private String m_news_url;
	@Value("${m_videos_url}")
	private String m_videos_url;
	@Value("${m_topics_url}")
	private String m_topics_url;
	@Value("${m_changye_url}")
	private String m_changye_url;
	@Value("${m_game_url}")
	private String m_game_url;
	@Value("${m_cs_url}")
	private String m_cs_url;
	@Value("${m_app_url}")
	private String m_app_url;
	
	public static String mofangHomeUrl;
	public static String bbsHomeUrl;
	public static String baseUrl;
	public static String mNewsUrl;
	public static String mVideosUrl;
	public static String mTopicsUrl;
	public static String mChangyeUrl;
	public static String mGameUrl;
	public static String mCsUrl;
	public static String mAppUrl;
	
	@PostConstruct
	public void init() {
		CommonUrl.mofangHomeUrl = mofang_home_url;
		CommonUrl.bbsHomeUrl = bbs_home_url;
		CommonUrl.baseUrl = base_url;
		CommonUrl.mNewsUrl = m_news_url;
		CommonUrl.mVideosUrl = m_videos_url;
		CommonUrl.mTopicsUrl = m_topics_url;
		CommonUrl.mChangyeUrl = m_changye_url;
		CommonUrl.mGameUrl = m_game_url;
		CommonUrl.mCsUrl = m_cs_url;
		CommonUrl.mAppUrl = m_app_url;
	}
	
}
