package com.mofang.feedweb.entity;

/**
 * @author ke
 * 
 */
public class ThreadsTitle {
	
	private String forum_name;
	private long thread_id;
	private String thread_name;
	private String content;
	private int display_order;
	private String link_url;

	public String getForum_name() {
		return forum_name;
	}

	public void setForum_name(String forum_name) {
		this.forum_name = forum_name;
	}

	public long getThread_id() {
		return thread_id;
	}

	public void setThread_id(long thread_id) {
		this.thread_id = thread_id;
	}

	public String getThread_name() {
		return thread_name;
	}

	public void setThread_name(String thread_name) {
		this.thread_name = thread_name;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getDisplay_order() {
		return display_order;
	}

	public void setDisplay_order(int display_order) {
		this.display_order = display_order;
	}

	public String getLink_url() {
		return link_url;
	}

	public void setLink_url(String link_url) {
		this.link_url = link_url;
	}
}
