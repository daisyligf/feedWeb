package com.mofang.feedweb.entity;

/**
 * 
 * @author ke
 * 版块列表内容
 *
 */
public class ForumListInfo {

	private long forumId;
	private String forumName;
	private String icon;
	private int todayThreads;
	private int totalThreads;
	private String forumUrl;
	private String prefectureUrl;
	private String giftUrl;
	private String downLoadUrl;
	
	
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
	public String getPrefectureUrl() {
		return prefectureUrl;
	}
	public void setPrefectureUrl(String prefectureUrl) {
		this.prefectureUrl = prefectureUrl;
	}
	public String getGiftUrl() {
		return giftUrl;
	}
	public void setGiftUrl(String giftUrl) {
		this.giftUrl = giftUrl;
	}
	public String getDownLoadUrl() {
		return downLoadUrl;
	}
	public void setDownLoadUrl(String downLoadUrl) {
		this.downLoadUrl = downLoadUrl;
	}

	
	
}
