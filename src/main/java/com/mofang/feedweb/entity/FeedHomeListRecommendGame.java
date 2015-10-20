package com.mofang.feedweb.entity;

public class FeedHomeListRecommendGame {
	private long forumId;
	private String forumName;
	private String icon;
	private int todayThreads;
	private int totalThreads;
	private String forumUrl;
	private String downloadUrl;
	private String giftUrl;
	
	public long getForumId() {
		return forumId;
	}
	public void setForumId(long forumId) {
		this.forumId = forumId;
	}
	public String getForumName() {
		return forumName;
	}
	public void setForumName(String forumName) {
		this.forumName = forumName;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public int getTodayThreads() {
		return todayThreads;
	}
	public void setTodayThreads(int todayThreads) {
		this.todayThreads = todayThreads;
	}
	public int getTotalThreads() {
		return totalThreads;
	}
	public void setTotalThreads(int totalThreads) {
		this.totalThreads = totalThreads;
	}
	public String getForumUrl() {
		return forumUrl;
	}
	public void setForumUrl(String forumUrl) {
		this.forumUrl = forumUrl;
	}
	public String getDownloadUrl() {
		return downloadUrl;
	}
	public void setDownloadUrl(String downloadUrl) {
		this.downloadUrl = downloadUrl;
	}
	public String getGiftUrl() {
		return giftUrl;
	}
	public void setGiftUrl(String giftUrl) {
		this.giftUrl = giftUrl;
	}
}
