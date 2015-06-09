package com.mofang.feedweb.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ExternalUrlInfo {
	@Value("#{configProperties['feed_info_url']}")
	private String feed_info_url;
	@Value("#{configProperties['image_info_url']}")
	private String image_info_url;
	@Value("#{configProperties['user_info_url']}")
	private String user_info_url;
	@Value("#{configProperties['gift_info_url']}")
	private String gift_info_url;
	@Value("#{configProperties['game_info_url']}")
	private String game_info_url;
	@Value("#{configProperties['upload_img_url']}")
	private String upload_img_url;
	@Value("#{configProperties['user_loginstatus_url']}")
	private String user_loginstatus_url;
	@Value("${viper_info_url}")
	private String viper_info_url;

	public String getFeed_info_url() {
		return feed_info_url;
	}

	public void setFeed_info_url(String feed_info_url) {
		this.feed_info_url = feed_info_url;
	}

	public String getImage_info_url() {
		return image_info_url;
	}

	public void setImage_info_url(String image_info_url) {
		this.image_info_url = image_info_url;
	}

	public String getUser_info_url() {
		return user_info_url;
	}

	public void setUser_info_url(String user_info_url) {
		this.user_info_url = user_info_url;
	}

	public String getGift_info_url() {
		return gift_info_url;
	}

	public void setGift_info_url(String gift_info_url) {
		this.gift_info_url = gift_info_url;
	}

	public String getGame_info_url() {
		return game_info_url;
	}

	public void setGame_info_url(String game_info_url) {
		this.game_info_url = game_info_url;
	}

	public String getUpload_img_url() {
		return upload_img_url;
	}

	public void setUpload_img_url(String upload_img_url) {
		this.upload_img_url = upload_img_url;
	}

	public String getUser_loginstatus_url() {
		return user_loginstatus_url;
	}

	public void setUser_loginstatus_url(String user_loginstatus_url) {
		this.user_loginstatus_url = user_loginstatus_url;
	}
	
	public void setViper_info_url(String viper_info_url) {
		this.viper_info_url = viper_info_url;
	}

	public String getViper_info_url() {
		return viper_info_url;
	}

}
