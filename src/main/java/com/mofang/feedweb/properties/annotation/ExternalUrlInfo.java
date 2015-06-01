package com.mofang.feedweb.properties.annotation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;


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
	


}
