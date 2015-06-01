package com.mofang.feedweb.entity;


/**
 * @author ke
 *
 */
public class FeedHomeHotForumRank {

	private long forum_id;
	private String forum_name;
	private int up_down;
	private String link_url;

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

	public int getUp_down() {
		return up_down;
	}

	public void setUp_down(int up_down) {
		this.up_down = up_down;
	}

	public String getLink_url() {
		return link_url;
	}

	public void setLink_url(String link_url) {
		this.link_url = link_url;
	}
}
