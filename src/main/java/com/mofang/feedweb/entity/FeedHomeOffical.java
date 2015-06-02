package com.mofang.feedweb.entity;

/**
 * @author ke
 *
 */
public class FeedHomeOffical {
	private long forum_id;
	private String forum_name;
	private String icon;
	private int today_threads;
	private int total_threads;

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
}
