package com.mofang.feedweb.entity;

/**
 * 
 * @author daisyli
 * 游戏信息
 */
public class Game {
	
	private int id;
	
	private String name;
	
	private String icon;
	
	private String url;
	
	private String comment;
	
	public Game(){}
	
	public Game(int id) {
		super();
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	
}
