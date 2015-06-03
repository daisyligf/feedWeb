package com.mofang.feedweb.entity;

import java.util.Date;
import java.util.List;

/**
 * @author ke
 *
 */
public class FeedForum {

	private long forum_id;
	private String forum_name;
	private String name_spell;
	private String icon;
	private int type;
	private int total_threads;
	private int today_threads;
	private int yesterday_threads;
	private int total_follows;
	private int yestoday_follows;
	private Date create_time;
//	private int tag_id;
//	private String tag_name;
	private String forum_url;
	private String download_url;
	private String gift_url;
	private String prefecture_url;
	private List<FeedTag> tags;
	private List<RoleInfo> roleList;
	
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
	public String getName_spell() {
		return name_spell;
	}
	public void setName_spell(String name_spell) {
		this.name_spell = name_spell;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getTotal_threads() {
		return total_threads;
	}
	public void setTotal_threads(int total_threads) {
		this.total_threads = total_threads;
	}
	public int getYesterday_threads() {
		return yesterday_threads;
	}
	public void setYesterday_threads(int yesterday_threads) {
		this.yesterday_threads = yesterday_threads;
	}
	public int getTotal_follows() {
		return total_follows;
	}
	public void setTotal_follows(int total_follows) {
		this.total_follows = total_follows;
	}
	public int getYestoday_follows() {
		return yestoday_follows;
	}
	public void setYestoday_follows(int yestoday_follows) {
		this.yestoday_follows = yestoday_follows;
	}
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
//	public int getTag_id() {
//		return tag_id;
//	}
//	public void setTag_id(int tag_id) {
//		this.tag_id = tag_id;
//	}
//	public String getTag_name() {
//		return tag_name;
//	}
//	public void setTag_name(String tag_name) {
//		this.tag_name = tag_name;
//	}
	public int getToday_threads() {
		return today_threads;
	}
	public void setToday_threads(int today_threads) {
		this.today_threads = today_threads;
	}
	public String getForum_url() {
		return forum_url;
	}
	public void setForum_url(String forum_url) {
		this.forum_url = forum_url;
	}
	public String getDownload_url() {
		return download_url;
	}
	public void setDownload_url(String download_url) {
		this.download_url = download_url;
	}
	public String getGift_url() {
		return gift_url;
	}
	public void setGift_url(String gift_url) {
		this.gift_url = gift_url;
	}
	public String getPrefecture_url() {
		return prefecture_url;
	}
	public void setPrefecture_url(String prefecture_url) {
		this.prefecture_url = prefecture_url;
	}
	public List<FeedTag> getTags() {
		return tags;
	}
	public void setTags(List<FeedTag> tags) {
		this.tags = tags;
	}
	public List<RoleInfo> getRoleList() {
		return roleList;
	}
	public void setRoleList(List<RoleInfo> roleList) {
		this.roleList = roleList;
	}
}

