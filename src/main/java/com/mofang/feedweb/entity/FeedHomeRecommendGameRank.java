package com.mofang.feedweb.entity;

/**
 * @author ke
 * 
 */
public class FeedHomeRecommendGameRank {

	private long forum_id;
	private String forum_name;
	private String icon;
	private String link_url;
	private String gift_url;
	private String downLoad_url;

	public long getForum_id() {
		return forum_id;
	}

	public void setForum_id(long forum_id) {
		this.forum_id = forum_id;
	}

	public String getForum_name() {
		return forum_name;
	}

	public void setForum_name(String forum_name) {
		this.forum_name = forum_name;
	}

	public String getLink_url() {
		return link_url;
	}

	public void setLink_url(String link_url) {
		this.link_url = link_url;
	}

	public String getGift_url() {
		return gift_url;
	}

	public void setGift_url(String gift_url) {
		this.gift_url = gift_url;
	}

	public String getDownLoad_url() {
		return downLoad_url;
	}

	public void setDownLoad_url(String downLoad_url) {
		this.downLoad_url = downLoad_url;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}
}
