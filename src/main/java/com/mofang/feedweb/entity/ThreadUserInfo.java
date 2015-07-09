package com.mofang.feedweb.entity;

/**
 * @author linjx
 */
public class ThreadUserInfo {

	private long userId;
	private String nickname;
	private String avatar;
	private int coin;
	private int level;
	private int replies;
	private int threads;
	private int eliteThreads;

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

	public int getCoin() {
		return coin;
	}

	public void setCoin(int coin) {
		this.coin = coin;
	}

	public int getReplies() {
		return replies;
	}

	public void setReplies(int replies) {
		this.replies = replies;
	}

	public int getThreads() {
		return threads;
	}

	public void setThreads(int threads) {
		this.threads = threads;
	}

	public int getEliteThreads() {
		return eliteThreads;
	}

	public void setEliteThreads(int eliteThreads) {
		this.eliteThreads = eliteThreads;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

}
