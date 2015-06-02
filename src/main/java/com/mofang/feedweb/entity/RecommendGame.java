package com.mofang.feedweb.entity;

/**
 * @author ke
 *
 */
public class RecommendGame {

	private long forum_id;
	private String forum_name;
	private String icon;
	private int today_threads;
	private int total_threads;
	private String forum_url;
	private String download_url;
	private String gift_url;

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

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public int getToday_threads() {
		return today_threads;
	}

	public void setToday_threads(int today_threads) {
		this.today_threads = today_threads;
	}

	public int getTotal_threads() {
		return total_threads;
	}

	public void setTotal_threads(int total_threads) {
		this.total_threads = total_threads;
	}

	public String getForum_url() {
		return forum_url;
	}

	public void setForum_url(String forum_url) {
		this.forum_url = forum_url;
	}

	public String getDownload_url() {
		return download_url;
	}

	public void setDownload_url(String download_url) {
		this.download_url = download_url;
	}

	public String getGift_url() {
		return gift_url;
	}

	public void setGift_url(String gift_url) {
		this.gift_url = gift_url;
	}
}
