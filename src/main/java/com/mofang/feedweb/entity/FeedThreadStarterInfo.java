package com.mofang.feedweb.entity;

/**
 * @author ke
 *
 */
public class FeedThreadStarterInfo {

	private long user_id;
	private String user_name;
	private int magics;
	private int replies;
	private int create_threads;
	private int Elites;
	private int is_moderator;
	
	
	public long getUser_id() {
		return user_id;
	}
	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public int getMagics() {
		return magics;
	}
	public void setMagics(int magics) {
		this.magics = magics;
	}
	public int getReplies() {
		return replies;
	}
	public void setReplies(int replies) {
		this.replies = replies;
	}
	public int getCreate_threads() {
		return create_threads;
	}
	public void setCreate_threads(int create_threads) {
		this.create_threads = create_threads;
	}
	public int getElites() {
		return Elites;
	}
	public void setElites(int elites) {
		Elites = elites;
	}
	public int getIs_moderator() {
		return is_moderator;
	}
	public void setIs_moderator(int is_moderator) {
		this.is_moderator = is_moderator;
	}
	


	
}
