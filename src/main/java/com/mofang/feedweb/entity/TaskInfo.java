package com.mofang.feedweb.entity;

public class TaskInfo {
	private boolean registFlg = false;
	private boolean avatarUploadFlg = false;
	private boolean firstNewThreadFlg = false;
	private boolean firstReplyFlg = false;
	private boolean firstRecommendFlg = false;
	
	public boolean isRegistFlg() {
		return registFlg;
	}
	public void setRegistFlg(boolean registFlg) {
		this.registFlg = registFlg;
	}
	public boolean isAvatarUploadFlg() {
		return avatarUploadFlg;
	}
	public void setAvatarUploadFlg(boolean avatarUploadFlg) {
		this.avatarUploadFlg = avatarUploadFlg;
	}
	public boolean isFirstNewThreadFlg() {
		return firstNewThreadFlg;
	}
	public void setFirstNewThreadFlg(boolean firstNewThreadFlg) {
		this.firstNewThreadFlg = firstNewThreadFlg;
	}
	public boolean isFirstReplyFlg() {
		return firstReplyFlg;
	}
	public void setFirstReplyFlg(boolean firstReplyFlg) {
		this.firstReplyFlg = firstReplyFlg;
	}
	public boolean isFirstRecommendFlg() {
		return firstRecommendFlg;
	}
	public void setFirstRecommendFlg(boolean firstRecommendFlg) {
		this.firstRecommendFlg = firstRecommendFlg;
	}
}
