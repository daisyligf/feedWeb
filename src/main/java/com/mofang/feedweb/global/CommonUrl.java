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
//	//关于魔方
//	@Value("${mf_about_url}")
//	private String mf_about_url;
//	//加入魔方
//	@Value("${mf_join_url}")
//	private String mf_join_url;
//	//广告合作
//	@Value("${mf_contact_url}")
//	private String mf_contact_url;
//	//游戏新闻
//	@Value("${mf_news_url}")
//	private String mf_news_url;
//	//新游评测
//	@Value("${mf_pingce_url}")
//	private String mf_pingce_url;
//	//游戏库
//	@Value("${mf_game_url}")
//	private String mf_game_url;
//	//魔客派
//	@Value("${mf_markpi_url}")
//	private String mf_markpi_url;
//	//非玩不可
//	@Value("${mf_fwbk_url}")
//	private String mf_fwbk_url;
//	//手游全攻略
//	@Value("${mf_introduction_url}")
//	private String mf_introduction_url;
//	//梦幻西游
//	@Value("${mf_my_url}")
//	private String mf_my_url;
//	//暖暖环游世界
//	@Value("${mf_nnhysj_url}")
//	private String mf_nnhysj_url;
//	//火影忍者手游
//	@Value("${mf_hyrzol_url}")
//	private String mf_hyrzol_url;
//	//冒险岛手游
//	@Value("${mf_mxd_url}")
//	private String mf_mxd_url;
//	//产业新闻
//	@Value("${mf_newscy_url}")
//	private String mf_newscy_url;
//	//星观点
//	@Value("${mf_guandian_url}")
//	private String mf_guandian_url;
//	//媒良心
//	@Value("${mf_shilu_url}")
//	private String mf_shilu_url;
	
	
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
