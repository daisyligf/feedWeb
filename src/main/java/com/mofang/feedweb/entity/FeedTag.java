package com.mofang.feedweb.entity;

/**
 * @author ke
 * 
 */
public class FeedTag {

	private int tag_id;
	private String tag_name;

	public FeedTag() {
	}
	
	public FeedTag(int tag_id, String tag_name) {
		this.tag_id = tag_id;
		this.tag_name = tag_name;
	}

	public int getTag_id() {
		return tag_id;
	}

	public void setTag_id(int tag_id) {
		this.tag_id = tag_id;
	}

	public String getTag_name() {
		return tag_name;
	}

	public void setTag_name(String tag_name) {
		this.tag_name = tag_name;
	}

}
