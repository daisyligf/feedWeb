package com.mofang.feedweb.entity;

/**
 * 
 * @author daisyli
 *
 */
public class UserInfo {

	private long userId;
	
	private String nickname;
	
	private String avatar;

	public UserInfo() {}
	
	public UserInfo(long userId, String nickname) {
		super();
		this.userId = userId;
		this.nickname = nickname;
	}
	
	public UserInfo(long userId, String nickname, String avatar) {
		super();
		this.userId = userId;
		this.nickname = nickname;
		this.avatar = avatar;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	
}
